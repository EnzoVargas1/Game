/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;



import game.Game.STATE;
import static game.Game.handler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;


/**
 *
 * @author Enzo
 */
public class Menu extends MouseAdapter {
    
    Random r = new Random();
    private Game game;
    private Handler handler;
    private HUD hud;
    private Controller c;
    private int mx;
    private int my;
    private BufferedImage image;
    
    public Menu(Game game, Handler handler, Controller c, HUD hud){
         
        this.game = game;
        this.handler = handler;
        this.c = c;
        this.hud = hud;
       
       
        
    }

   
    
    
    @Override
    public void  mousePressed(MouseEvent e){
        
         mx = e.getX();
         my = e.getY();
         
            
         
        
        
        if(game.gameState == STATE.End){
         if(mouseOver(mx,my,(Game.WIDTH/2)- 140, 395, 235, 64)){
        
           game.gameState = STATE.Game;
            
            for(int i = 0; i<800;i++){
          Game.handler.addObject(new Star(Game.r.nextInt(Game.WIDTH),Game.r.nextInt(Game.HEIGHT),ID.Star,Game.handler));
           
           }
            
            
          Game.handler.addObject(new Player(Game.WIDTH/2,Game.HEIGHT*3/4,ID.Player,handler,game));
          Game.handler.addObject(new BasicEnemy(Game.r.nextInt(Game.WIDTH),0, ID.BasicEnemy,handler));
         
           
          }
         
         else if(mouseOver(mx, my, (Game.WIDTH/2)-140, 475, 235, 64)){
              
              game.gameState = STATE.ScoreBoard;
                          
          }
        }
        
        
        if(game.gameState == STATE.ScoreBoard) {
             if(mouseOver(mx,my, (Game.WIDTH/2)+260, 520, 150, 60)){
                   game.gameState = STATE.Menu;
              }
            
        }
        
        if(game.gameState == STATE.Input){
             if(mouseOver(mx,my, (Game.WIDTH/2)+260, 520, 150, 60)){
                   game.gameState = STATE.Menu;
              }
            
        }
        
       if(game.gameState == STATE.Menu){
            
        if(mouseOver(mx,my,(Game.WIDTH/2)- 60,Game.HEIGHT/2, 125, 64) ){
        
           game.gameState = STATE.Game;
           
              for(int i = 0; i<800;i++){
          Game.handler.addObject(new Star(Game.r.nextInt(Game.WIDTH),Game.r.nextInt(Game.HEIGHT),ID.Star,Game.handler));
           
           }
      
          Game.handler.addObject(new Player(Game.WIDTH/2,Game.HEIGHT*3/4,ID.Player,handler,game));
          Game.handler.addObject(new BasicEnemy(Game.r.nextInt(Game.WIDTH),0, ID.BasicEnemy,handler));
          

          }
          
          
            if(mouseOver(mx, my, (Game.WIDTH/2)-100, ((Game.HEIGHT/2) + 130 +30), 220, 64)){
                
                game.gameState = STATE.ScoreBoard;
                
            }
            
            if(mouseOver(mx,my,(Game.WIDTH/2) - 90,((Game.HEIGHT)/2)+20 + 60, 195, 64)){
                game.gameState = STATE.Options;
           
            }
            
            if(mouseOver(mx,my,30, 520, 185, 55)){
                game.gameState = STATE.Input;
           
            }
            
           
         }
       
       if(game.gameState == STATE.Options){
           
            if(mouseOver(mx,my,(Game.WIDTH/2)- 53,(Game.HEIGHT)/2, 125, 64)){
                HighScore.delete();
                game.gameState = STATE.Menu;
           
            }
            
            if(mouseOver(mx,my,730, 520, 105, 60)){
                
                game.gameState = STATE.Menu;
           
            }
           
       }
       
       
       
       
    }
    
      @Override
    public void mouseReleased(MouseEvent e){
            
    }
    
    
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        
        if(mx > x && mx < x + width){
            
            if(my > y && my < y + height){
                
                return true;
                
            } else return false;
        }else return false;
        
        
            
      }
       
    
    
   
    
    public void tick(){
        
        
        
    }
    
    public void render(Graphics g)  {
        
        if(game.gameState == STATE.Menu){
            
          Font fnt = new Font("Futura",1,50);
          Font fnt2 = new Font("damion",1,35);
          Font fnt3 = new Font("Futura",1,51);
            
          
          
          g.setFont(fnt3);
          g.setColor(Color.YELLOW);
          g.drawString("Killing Herpes", 253, 150);
          g.setFont(fnt);
          g.setColor(Color.RED);
          g.drawString("Killing Herpes", 255, 150);
          
          g.setFont(fnt2);
          g.setColor(Color.RED);
          g.drawString("Play", 385, 360);
          
          g.setColor(Color.YELLOW);
          g.drawRect((Game.WIDTH/2)- 60,(Game.HEIGHT)/2, 125, 64);
          
          g.setFont(fnt2);
          g.setColor(Color.RED);
          g.drawString("ScoreBoard", 335, 520);
          
          g.setColor(Color.YELLOW);
          g.drawRect((Game.WIDTH/2) - 100,((Game.HEIGHT)/2)+30 + 130, 220, 64);
          
          g.setFont(fnt2);
          g.setColor(Color.RED);
          g.drawString("Options", 355, 440);
          
          g.setColor(Color.YELLOW);
          g.drawRect((Game.WIDTH/2) - 90,((Game.HEIGHT)/2)+20 + 60, 195, 64);
          
           g.setColor(Color.yellow);
           g.drawRect(30, 520, 185, 55);
           g.setFont(fnt2);
           g.setColor(Color.red);
           g.drawString("New User", 35, 560);
          
           for(int i = 0; i<500;i++){
               
           g.setColor(Color.WHITE);
           //g.drawOval(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 1, 1);
           
           }
          
        }
     
        else if (game.gameState == STATE.End)   {
            
             Font fnt = new Font("futura",1,60);
             Font fnt2 = new Font("futura",1,35);
             
             for(int i = 0; i<500;i++){
               
           g.setColor(Color.WHITE);
           g.drawOval(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 1, 1);
           
           }
          
     
            g.setFont(fnt);
            g.setColor(Color.RED);
            g.drawString("Game Over", 230, 270);
            g.setColor(Color.yellow);
            
            g.setFont(fnt2);
            g.setColor(Color.yellow);
            g.drawRect((Game.WIDTH/2)- 140, 395, 235, 64);
            g.setColor(Color.red);
            g.drawString("Restart", 330, 435);
            
            g.setColor(Color.yellow);
            g.drawRect((Game.WIDTH/2)-140, 475, 235, 64);
            g.setFont(fnt2);
            g.setColor(Color.RED);
            g.drawString("ScoreBoard", 290, 525 );
            
        }
        
        else if (game.gameState == STATE.ScoreBoard){
            
             Font fnt = new Font("futura",1,60);
             Font fnt2 = new Font("futura",1,25);
             Font fnt3 = new Font("futura",1,62);
             Font fnt4 = new Font("futura",1,35);
             
            for(int i = 0; i<800;i++){
              
                 g.setColor(Color.WHITE);
                 g.drawOval(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 1, 1);
           
             }
            
             g.setFont(fnt3);
             g.setColor(Color.yellow);
             g.drawString("ScoreBoard", 235 , 90);
            
             g.setFont(fnt);
             g.setColor(Color.RED);
             g.drawString("ScoreBoard", 235, 90);
             
             g.setColor(Color.yellow);
             g.drawRect(10, 131, 665, 64);
             g.setFont(fnt2);
             g.drawString("1",11, 165);
             g.drawString(HighScore.getHighScores()[0].getName(), 30, 175);
             g.drawString("" + HighScore.getHighScores()[0].getScore(), 550, 175);
             
             g.setColor(Color.yellow);
             g.drawRect(10, 197, 665, 64);
             g.setFont(fnt2);
             g.drawString("2",11, 231);
             g.drawString(HighScore.getHighScores()[1].getName(), 30, 241);
             g.drawString("" + HighScore.getHighScores()[1].getScore(),550 , 241);
           
             g.setColor(Color.yellow);
             g.drawRect(10, 263, 665, 64);
             g.setFont(fnt2);
             g.drawString("3",11, 300);
             g.drawString(HighScore.getHighScores()[2].getName(), 30, 310);
             g.drawString("" + HighScore.getHighScores()[2].getScore(),550 , 310);
             
             
             g.setColor(Color.yellow);
             g.drawRect(10, 329, 665, 64);
             g.setFont(fnt2);
             g.drawString("4",11, 363);
             g.drawString(HighScore.getHighScores()[3].getName(), 30, 373);
             g.drawString("" + HighScore.getHighScores()[3].getScore(),550 , 373);
             
             g.setColor(Color.yellow);
             g.drawRect(10, 395, 665, 64);
             g.setFont(fnt2);
             g.drawString("5",11, 429);
             g.drawString(HighScore.getHighScores()[4].getName(), 30, 439);
             g.drawString("" + HighScore.getHighScores()[4].getScore(),550 , 439);
             
             g.setColor(Color.yellow);
             g.drawRect(10, 461, 665, 64);
             g.setFont(fnt2);
             g.drawString("6",11, 495);
             g.drawString(HighScore.getHighScores()[5].getName(), 30, 505);
             g.drawString("" + HighScore.getHighScores()[5].getScore(),550, 505);
             
             g.setColor(Color.yellow);
             g.drawRect(10, 527, 665, 64);
             g.setFont(fnt2);
             g.drawString("7",11, 561);
             g.drawString(HighScore.getHighScores()[6].getName(), 30, 571);
             g.drawString("" + HighScore.getHighScores()[6].getScore(),550 , 571);
             
             g.setColor(Color.yellow);
             g.drawRect(730, 520, 105, 60);
             g.setFont(fnt4);
             g.setColor(Color.red);
             g.drawString("Menu", 730, 560);
             
             g.setColor(Color.red);
             g.drawLine(548, 130, 548, 590);
             g.setColor(Color.red);
             g.drawLine(548, 130, 548, 590);
            
        } 
        else if(game.gameState == STATE.Input) {
              
             Color green = new Color(255, 201,34);
            
             Font fnt = new Font("Menlo",0,35);
             Font fnt2 = new Font("Menlo",0,35);
             int y = r.nextInt(Game.HEIGHT);
  
             for(int i = 0; i<800;i++){
                 
                 g.setColor(Color.YELLOW);
                 //g.drawOval(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 1, 1);
                 g.setColor(Color.WHITE);
                 //g.drawLine(r.nextInt(50), y,r.nextInt(Game.WIDTH), y);
                 
             }
            
            g.setFont(fnt);
            g.setColor(Color.GREEN);
            g.drawString("Enter Your Name", 255, 150);
            
            g.setColor(Color.GREEN);
            g.drawRect((Game.WIDTH/2)- 250,(Game.HEIGHT)/2, 525, 64);
            
            if(Input.username.length()>25)
               Input.username = Input.username.substring(0, 25);
            
            g.setFont(fnt);
            g.setColor(Color.GREEN);
            g.drawString(Input.username, (Game.WIDTH/2)- 249 , (Game.HEIGHT)/2 + 50);
              
            
            
            g.drawRect((Game.WIDTH/2)+260, 520, 150, 60);
            g.setFont(fnt2);
            g.setColor(Color.GREEN);
            g.drawString("Enter", (Game.WIDTH/2)+280, 560);
             
              
        }
        
        else if(game.gameState == STATE.Options){
            
             Font fnt = new Font("Lexend Mega",1,50);
          Font fnt2 = new Font("damion",1,35);
          
           for(int i = 0; i<500;i++){
               
           g.setColor(Color.WHITE);
           g.drawOval(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 1, 1);
           
           }
          
          g.setFont(fnt);
          g.setColor(Color.RED);
          g.drawString("Options", 330, 150);
          
          g.setFont(fnt2);
          g.setColor(Color.RED);
          g.drawString("Reset", 380, 360);
          g.setColor(Color.YELLOW);
          g.drawRect((Game.WIDTH/2)- 53,(Game.HEIGHT)/2, 125, 64);
          
          g.setColor(Color.yellow);
          g.drawRect(730, 520, 105, 60);
          g.setFont(fnt2);
          g.setColor(Color.red);
          g.drawString("Menu", 730, 560);
             
        }
        
    }

   
    
}