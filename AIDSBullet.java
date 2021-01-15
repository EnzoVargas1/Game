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
public class AIDSBullet extends GameObject{

    public AIDSBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        velY = 5;
    }

    @Override
    public void tick() {
      y+=velY;
      
      if(this.y >= Game.HEIGHT)Game.handler.removeObject(this);
      
    }

    @Override
    public void render(Graphics g) {
       
        Color purple = new Color(106, 13, 173);
        
       g.setColor(purple);
       g.fillRect((int)x, (int)y, 10, 15);
    }

    @Override
    public Rectangle getBounds() {
        return new  Rectangle((int)x, (int)y, 5, 15 );
    }
    
}
