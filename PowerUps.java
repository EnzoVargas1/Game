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
public class PowerUps extends GameObject{
    
    private  Handler handler;

    public PowerUps(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velY = 2;
        
    }

  

    @Override
    public void tick() {
        
       y+=velY;
       if(this.y > Game.HEIGHT){
          
           Game.handler.removeObject(this);
           handler.removeObject(this);
           
       }
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int) y, 24, 24);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 24, 24);
       
    }
    
    
    
}
