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
public class Star extends GameObject {

    Handler handler;
    
    public Star(int x, int y, ID id,Handler handler) {
        
        super(x, y, id);
         this.handler = handler;
         
    }

    @Override
    public void tick() {
       
        
    }

    @Override
    public void render(Graphics g) {
        
      g.setColor(Color.WHITE);
      g.drawOval((int)x, (int)y, 1, 1);
      
    }

    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
