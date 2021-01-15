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
public abstract class GameObject {
    
    //Only can be accessed by which object inherits the game object
    protected float x,y;
    protected ID id;
    protected float velX,velY;
  
    
    GameObject(int x , int y,ID id)
    {
      
        this.x = x;
        this.y = y;
        this.id = id;
        
    }
    
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public void setX(int x){
        
        this.x = x;
        
    }
    
    public void setY(int y){
        
        this.y = y;
        
    }
    
    public int getX(){
        
        return (int)x;
        
    }
    
    public int getY(){
        
        return (int)y;
        
    }
    
    public void setID(ID id){
        
        this.id = id;
    }
    
    public ID getid(){
        
        return id;
        
    }
    
    public void setVelX(int velX){
        
        this.velX = velX;
        
    }
    
    public void setVelY(int velY){
        
        this.velY = velY;
        
    }
    
    public float getVelX(){
        
        return velX;
        
    }
    
    public float getVelY(){
        
      return velY;  
        
    }
    
}
