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

class BasicEnemy extends GameObject{
    
     public BasicEnemy(int x, int y, ID id, Handler handler) 
     {
        super(x, y, id);
        velX = 3;
        velY = 3;
     }
     
     
    @Override
    public void tick() {
        
        x+=velX;
        y+=velY;
        
        if(y <= 0 || y >= Game.HEIGHT - 16 )velY*=-1;
        if(x <= 0 || x >= Game.WIDTH - 16 ) velX*=-1;
             
    }

    
    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);
        
    }

 //collision boundaries 
    @Override
     public Rectangle getBounds(){
         
         return new Rectangle((int)x,(int)y,16,16);
         
     }
     
     
    
}
