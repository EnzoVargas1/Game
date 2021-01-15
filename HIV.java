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
 * 
 */
public class HIV extends GameObject {

    private GameObject player;
    private Handler handler;
    
    public HIV(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velY = (float) 0.9;
        velX = (float)0.9;
        
        
      for(int i = 0; i < handler.object.size(); i++){
           
         if(handler.object.get(i).getid() == ID.Player) player = Game.handler.object.get(i);
         
      }
    
    }
    
    
    
    @Override
    public void tick() {
        
    float px = player.x;
    float py = player.y;
  
     if(x-px<0) {
      x+=velX;
      }
    else {
     x-=velX;
    }
  
    if(y-py<0) {
     y+=velY;
    } 
   else {
    y-=velY;
     }
      
    }

    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.MAGENTA);
        g.fillRect((int)x, (int)y, 30, 30);
        
    }
    
    @Override
    public Rectangle getBounds() {
       
        return new Rectangle((int)x,(int)y,30,30);
        
    }
    
     
    
}
