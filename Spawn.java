 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Game.STATE;
import static game.Game.WIDTH;
import static game.Game.handler;
import java.util.Random;

/**
 *
 * @author Enzo
 */
public class Spawn {
    
    private Handler handler;
    public HUD hud;
    private Random r = new Random();
    private int scoreKeep = 0;
    private int levelKeep = 0;
    private BigBoss boss;

    
    public Spawn(Handler handler, HUD hud){
        
        this.handler = handler;
        this.hud = hud;
        boss =  new BigBoss((Game.WIDTH/2),0, ID.BigBoss,handler, Game.ac);
    }
    
    
    public void tick(){
        
       spawnOnPlayer();

        scoreKeep++;
        
        if(scoreKeep >= 250){
            
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            
           if(Game.gameState != STATE.BossScene){
            
            Game.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, Game.handler));
           Game.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, Game.handler));
            spawnHIV();
            spawnCrabs();
            
           }
            
        }
         
         int time = hud.getScore();
          
         if(hud.getLevel() >= 20 && time%400 == 0)spawnPowerUps();
         if(hud.getLevel() >= 40 && hud.getScore()%800 == 0)spawnCondoms();
          
         if(hud.getLevel() >= 100)Game.gameState = STATE.BossScene;
         if(Game.gameState == STATE.BossScene){
             time = hud.getScore();
             if(hud.getLevel() == 100 && time == 23000)spawnAIDS();
             if(hud.getLevel() >= 100 &&hud.getScore()%100== 0)spawnBossBullets();
             if(hud.getLevel() >= 100 &&hud.getScore()%300== 0)Game.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, Game.handler));
             if(hud.getLevel() >= 100 &&hud.getScore()%800 == 0)spawnHIV();
          }
         
        
      
    }
    
    
    //keeps the player from staying in one place
    private void spawnOnPlayer(){
        
         for(int i = 0; i < Game.handler.object.size(); i++){
              
              GameObject object = Game.handler.object.get(i);
              if(object.getid() == ID.Player){
                  
                  if(object.velX == 0 && object.velY == 0){
                      
                   if(hud.getScore()%150 == 0) 
                     Game.handler.addObject(new BasicEnemy((int)object.x, (int)object.y + 14, ID.BasicEnemy,handler));
                    
                  }
                  
              }
              
          }
            
    }
    
    private void spawnPowerUps(){
        
      Game.handler.addObject(new PowerUps(r.nextInt(840), 0, ID.powerUp, Game.handler));
        
    }
    
    private void spawnCondoms(){
        
      Game.handler.addObject(new Condom(r.nextInt(840), 0, ID.Condom, Game.handler));
        
    }
    
    private void spawnHIV(){
        
        for(int i = 0; i < 3; i++)
            if(hud.getLevel() >= 60) Game.handler.addObject(new HIV(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HIV, Game.handler));
                   
    }
    
    
    
    private void spawnAIDS(){

         Game.handler.addObject(boss);
         
    }
    
    private void spawnBossBullets(){
         for(int i = 0; i < Game.handler.object.size(); i++){
           
          GameObject temp = Game.handler.object.get(i);
          
          if(temp.getid() == ID.BigBoss){
               Game.handler.addObject(new AIDSBullet(temp.getX()+10, temp.getY(), ID.AIDSBullet, Game.handler));
             
            }
         }
    }
  
         
   private void spawnCrabs(){
       int time = hud.getScore();
     for(int i = 0; i < 2; i++) 
       if(hud.getLevel() >= 30 && time%150 == 0)Game.handler.addObject(new Crab(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Crab, Game.handler));
        
   }
         
         
    
    
}
