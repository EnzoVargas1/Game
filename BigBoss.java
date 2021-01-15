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
public class BigBoss extends GameObject {
      
    Handler handler;
    AIDSController ac;
    private int timer = 100;
    private int timer2 = 50;
    public static int life; 
    
    public BigBoss(int x, int y, ID id, Handler handler, AIDSController ac) {
        
        super(x, y, id);
        this.handler = handler;
        this.ac = ac;
        velY = (float) 0.6;
        life = 100;
    }

    
    
    @Override
    public void tick() {
      
        x+=velX;
        y+=velY;
        
        if(timer<= 0)velY = 0;
        else timer--;
         
        if(timer<= 0)timer2--;
        if(timer2 <= 0){
            if(velX == 0){
               velX = 5;
               
               
            }
            
        }
        
        if(x <= 0 || x >= Game.WIDTH - 16 ) velX*=-1;
        
        if(BossHud.health <= 0)Game.handler.removeObject(this);
         
    }

    
    @Override
    public void render(Graphics g) {
            
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, 50, 50);
        
    }
    
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, 50, 50);
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
    
}
