/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Condom.time;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Enzo
 */

public class Game extends Canvas implements Runnable {
    
    public static final int WIDTH = 840, HEIGHT = WIDTH/12*9;
    private Thread thread;
    private boolean running = false;
    public static boolean paused = false; 
    public static Random r;
    public static  Handler handler;
    public static   HUD hud;
    public static BossHud bossHud;
    private Spawn spawn;
    private Menu menu;
    private BossScene bossScene;
    public static AIDSController ac;
    private Input input;
    public static Controller c;
    public  Player player;
    public static Window window;
    public static int scoreKeep = 0;
    public static boolean allowCollision = true;
    public static int time = 1200;
    
    public static enum STATE{
        
        Menu,Game,End,ScoreBoard, Input, Options,
        BossScene,
        
    };
    
    public static STATE gameState = STATE.Input;
    
      public Game(){
          
          handler = new Handler();
          c = new Controller();
          hud = new HUD();
          bossHud = new BossHud();
          menu = new Menu(this, handler, c, hud);
          bossScene = new BossScene(this, handler, hud, c, ac);
          input = new Input("");
          this.addKeyListener(new KeyInput(handler));
          this.addKeyListener(input);
          this.addMouseListener(menu);
          window = new Window(WIDTH, HEIGHT,"Killing Herpes",this );
  
          spawn = new Spawn(handler,hud);
          
          r = new Random();
         
          this.requestFocusInWindow();
          
      }
    
    
    
    
      //This method starts the thread
     public synchronized void start(){
         
         thread = new Thread(this);
         thread.start();
         running = true;
         
     }
    
     
      public synchronized void stop(){
         
          try{
            thread.join();
            running = false;
          }
        catch(Exception e){
            e.printStackTrace();
            
        }
     }
     
     
       //Game Loop - where it update itself
     @Override
      public void run(){
          
          this.requestFocus();
          long lastTime = System.nanoTime();
          double amountOfTicks = 120.0;
          double ns = 1000000000/amountOfTicks;
          double delta = 0;
          long timer = System.currentTimeMillis();
          int frames = 0;
          
          while(running){
             
              long now = System.nanoTime();
              delta+=(now - lastTime)/ns;
              lastTime = now;
              while(delta >= 1){
                  
                  tick();
                  delta--;
              }
              if(running)
                  render();
              frames++; 
              
              if(System.currentTimeMillis() - timer > 1000){
                  
                  timer+=1000;
                  System.out.println("FPS: " + frames);
                 frames = 0;
              }
              
          }
          
          stop();
      }
    
      
    public static float clamp(float var, float min , float max ){
        
        if(var >= max)
                return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
        
    }
    
  
    
    
     public static void main(String[] args) {
           
        new Game();
        
        }
     
     
   
    private void tick() {
     
      if(gameState == STATE.Game){
        if(!paused){
        handler.tick();
        c.tick();
        hud.tick();
        spawn.tick();
         
        if(HUD.health <= 0){ 
            
            HUD.health = 100;
            hud.setLevel(1);
            
            if(hud.getScore() > HighScore.getHighScores()[6].getScore() )
            {
               HighScore.addHighScore(new HighScore(hud.getScore(), Input.username));
            }
        
            hud.score(0);
            scoreKeep = 0;
            handler.removeObject(player);
            gameState = STATE.End;
            handler.clearEnemies();
            c.removeAll();
            
            
           }
       
        }
         
        } else if(gameState == STATE.Menu || gameState == STATE.End){
            
            menu.tick();
            
      
        }
        
        else if(gameState == STATE.ScoreBoard){
 
            menu.tick();
            
        }
        else if (gameState == STATE.Input){
            
            menu.tick();
       
            
        }
        else if (gameState == STATE.Options){
            menu.tick();
        }
        else if(gameState == STATE.BossScene){
             if(!paused){
            bossScene.tick();
            bossHud.tick();
            spawn.tick();
              if(HUD.health <= 0){ 
            
            HUD.health = 100;
            hud.setLevel(1);
            
            if(hud.getScore() > HighScore.getHighScores()[6].getScore() )
            {
               HighScore.addHighScore(new HighScore(hud.getScore(), Input.username));
            }
        
            hud.score(0);
            scoreKeep = 0;
            handler.removeObject(player);
            gameState = STATE.End;
            handler.clearEnemies();
            c.removeAll();
              }
            
           }
            
        }
        
    }
     
    
    
    private void render() {
       BufferStrategy bs = this.getBufferStrategy();
       
       if(bs == null){
          this.createBufferStrategy(3);
          return;
           
       }
       
       Graphics g = bs.getDrawGraphics();
       Color black = new Color(0, 0, 0);
       Color b = new Color(255, 150, 16);
       g.setColor(black);
     // if (gameState == STATE.BossScene) g.setColor(b);

       g.fillRect(0,0,WIDTH,HEIGHT);
       handler.render(g);
       c.render(g);
       
      if(gameState == STATE.Game){
          
          handler.render(g);
          c.render(g);
          hud.render(g);
          if(Game.allowCollision == false){
           g.setColor(Color.white);
           g.drawString("Protection:" + time/100,Game.WIDTH - 150, 400);
          }
          
          if(paused == true)g.drawString("paused", WIDTH/2, HEIGHT/2);

      }else if(gameState == STATE.Menu || gameState == STATE.End){
            
           menu.render(g);
            
        }
      
      else if(gameState == STATE.ScoreBoard){
          
          menu.render(g);
          
      }
      else if(gameState == STATE.Input){

          menu.render(g);
          
      }else if(gameState == STATE.Options){
          
          menu.render(g);
      }
      else if (gameState == STATE.BossScene){
          
         bossScene.render(g);
         bossHud.render(g);
         
         if(Game.allowCollision == false){
             
           g.setColor(Color.white);
           g.drawString("Protection:" + time/100,Game.WIDTH - 150, 400);
           
          }
         
      }
      
       g.dispose();
       bs.show();
       
    }
    
    
}
