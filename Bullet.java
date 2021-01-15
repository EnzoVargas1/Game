/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Enzo
 */

public class Bullet extends GameObject {

    public Bullet(int x, int y, ID id) {
        super(x, y, id);
         velY = -5;
         
    }

   

    @Override
    public void tick() {
        
       if(this.gety()<=20){
           
         Game.c.removeBullet(this);
           
       }else{
           
         y+=velY;
        collision();
         
       }
        
        
    }

    @Override
    public void render(Graphics g) {
       g.setColor(Color.orange);
       g.fillRect((int)x, (int)y, 5, 15);
    }

    @Override
    public Rectangle getBounds() {
       return new  Rectangle((int)x, (int)y, 5, 15 );
    }
    
    
    
     private void collision(){
         
         for(int i = 0; i < Game.handler.object.size(); i++){
             
              GameObject test = Game.handler.object.get(i);
              
           if(test.getid() == ID.BasicEnemy){   
             
             if(getBounds().intersects(test.getBounds())){
                 
                 Game.handler.removeObject(test);
                 
             }
                     
           }
           
           if(test.getid() == ID.HIV){
               
               if(getBounds().intersects(test.getBounds())){
                   
                   Game.handler.removeObject(test);
                   
               }
               
               
           }
           
           if(test.getid() == ID.powerUp){
               
               if(getBounds().intersects(test.getBounds())){
                   
                   HUD.health+=10;
                   Game.handler.removeObject(test);
                   
               }
               
           }
           
           if(test.getid() == ID.BigBoss){
               
               if(getBounds().intersects(test.getBounds())){
                   
                   BossHud.health-=1;
                   
               }
               
           }
           
           if(test.getid() == ID.Condom){
               
               if(getBounds().intersects(test.getBounds())){
                   Game.allowCollision = false;
                   Game.handler.removeObject(test);
                   
               }
               
           }
           if(test.getid() == ID.AIDSBullet){
               
               if(getBounds().intersects(test.getBounds())){
                   Game.handler.removeObject(test);
                   
               }
               
           }
           if(test.getid() == ID.Crab){
               
               if(getBounds().intersects(test.getBounds())){
                   Game.handler.removeObject(test);
                   
               }
               
           }
           
         }
         
         
     }
     
     
   
     
     public int gety(){
         
         return (int)this.y;
         
     }
    
}
