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
public class Condom extends GameObject {

    private Handler handler;
    private HUD hud;
    public static int time = 1200;
    
    
    public Condom(int x, int y, ID id, Handler handler ){
        super(x, y, id);
        this.handler = handler;
        velY = 2;

    }

    @Override
    public void tick() {
       
       y+=velY;
       
       if(this.y > Game.HEIGHT){
          
           Game.handler.removeObject(this);
           
       }
       
       if(Game.allowCollision == false){
           
           time--;
           
           if(time <=0){
               
               Game.allowCollision = true;
               time = 1200;
               
           }
           
       }
        
    }

    
    
    
    @Override
    public void render(Graphics g) {
       g.setColor(Color.WHITE);
       g.fillRect((int) x, (int) y, 24, 24);
       if(Game.allowCollision == false){
           g.setColor(Color.white);
           g.drawString("Protection:" + Game.time/100,Game.WIDTH - 150, 400);
          }
       
       
    }

    @Override
    public Rectangle getBounds() {
        
        return new Rectangle((int)x, (int)y, 24, 24);
    }
    
    private void collision(){
        
        for(int i = 0; i < Game.c.b.size(); i++){
            
            GameObject temp  = Game.c.b.get(i);
            
            if(temp.getBounds().intersects(getBounds())){
                
                
                
            }
            
            
        }
    }
    
    
}
