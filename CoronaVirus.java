/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Enzo
 */
public class CoronaVirus extends GameObject {
    
    private Handler handler;
    
    public CoronaVirus(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 10;
    }

    @Override
    public void tick() {
       
        y+=velY;
        
    }

    @Override
    public void render(Graphics g) {
      
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 50, 50);
    }
    
}
