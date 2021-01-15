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
public class Crab extends GameObject {

    private Handler handler;
    private int timer = 500;
    private int timer2 = 10;
    private boolean move = true;
    private GameObject player;
    
    public Crab(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 6;
        velY = 6;
        
       for(int i = 0; i < handler.object.size(); i++){
           
         if(handler.object.get(i).getid() == ID.Player) player = Game.handler.object.get(i);
         
      }
        
    }

    @Override
    public void tick() {
      
      if(move == true){
       
       timer2 = 10;
        
       x+=velX;
       y+=velY;

       if(y <= 0 || y >= Game.HEIGHT - 16 )velY*=-1;
       if(x <= 0 || x >= Game.WIDTH - 16 ) velX*=-1;
       timer--;
      
       }
       
       if(timer<=0){
          move = false;
         if(move == false){
           
          x = player.x;
          y = player.y;
          timer2--;
          
         }
       }
       
       if(timer2<=0){
           
         move = true;
         timer = 500;
           
       }
      
      
    
    }

    @Override
    public void render(Graphics g) {
       Color coral = new Color(255,127,80);
       g.setColor(coral);
       g.fillRect((int)x,(int)y, 9, 9);
    }

    @Override
    public Rectangle getBounds() {
       return new Rectangle((int)x,(int)y, 9, 9);
    }
    
    private void follow(){
        
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
    
}
