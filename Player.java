/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Enzo
 */
public  class Player extends GameObject{
    
      Handler handler;
      Game game;
      Random r = new Random();
      public static boolean allowCollision = true;
      private BufferedImage image;
      
    public Player(int x, int y, ID id, Handler handler, Game game) {
        
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 0;
        this.game = game;
         
    }

    
     //collision boundaries 
    @Override
     public Rectangle getBounds(){
         
         return new Rectangle((int)x,(int)y,32,32);
          
          
     }
     
    @Override
    public void tick() {
      
       x+=velX;
       y+=velY;
       
       x = Game.clamp((int)x, 0, Game.WIDTH - 32);
       y =  Game.clamp((int)y, 0, Game.HEIGHT - 60);
       
       collision();
    }
    
      private void collision(){
          
         if(Game.allowCollision == true){
          
          for(int i = 0; i < Game.handler.object.size(); i++){
              
              GameObject tempObject = Game.handler.object.get(i);
              
              if(tempObject.getid() == ID.BasicEnemy){//tempObject is now BasicEnemy
                  
                  if(getBounds().intersects(tempObject.getBounds())){
                      //collison code 
                      HUD.health-=1;
 
                      
                  }
                  
              }
              else if(tempObject.getid() == ID.BigBoss){
                  
                  if(getBounds().intersects(tempObject.getBounds())){
                      //collison code 
                      HUD.health-=3;
                  }
                  
              }
              else if(tempObject.getid() == ID.HIV){
                  
                  if(getBounds().intersects(tempObject.getBounds())){
                      //collison code 
                      HUD.health-=1;
                  }
              }
                else if(tempObject.getid() == ID.AIDSBullet){
                  
                  if(getBounds().intersects(tempObject.getBounds())){
                      //collison code 
                      HUD.health-=1;
                  }
              }
                else if(tempObject.getid() == ID.Crab){
                  
                  if(getBounds().intersects(tempObject.getBounds())){
                      //collison code 
                      HUD.health-=1;
                  }
              }
              
          }
          
       }
          
    }
    
    @Override
    public void render(Graphics g) {
        /**
        Graphics2D g2d = (Graphics2D) g;
       g.setColor(Color.BLUE);
       g.fillRect((int)x,(int)y,32,32);
       **/
       try {
              image = ImageIO.read(getClass().getResourceAsStream("SpriteExample.jpeg"));
           } catch (IOException e) {
              e.printStackTrace();

           }
         g.drawImage(image, (int)x, (int)y, 32, 32, game);
          
        
    }
    
      @Override
    public void setX(int x){
        
        this.x = x;
        
    }
    
      @Override
     public void setY(int y){
        
        this.y = y;
        
    }
    
    
      @Override
   public int getX(){
       
       return (int)this.x;
       
   }
   
      @Override
   public int getY(){
       
      return (int)this.y ;
       
   }
   
   public void dontAllowColllision(){
       allowCollision = false;
       
   }
    
}
