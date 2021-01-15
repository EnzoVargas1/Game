/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Condom.time;
import static game.Game.time;
import java.awt.Color;
import java.util.LinkedList;
import java.awt.Graphics;
/**
 *
 * @author Enzo
 */


/**The Handler class will loop through all of the objects in the game
 * and update them and render them on to the screen
 * 
 * 
 */
public class Handler {
  
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(){
        
       for(int i = 0; i < object.size(); i++){
          
           GameObject tempObj = object.get(i);
           
           tempObj.tick();
       }
        
        if(Game.allowCollision == false){
           
             Game.time--;
           
           if(Game.time <=0){
               
               Game.allowCollision = true;
               Game.time = 1200;
               
            } 
       
        }
       
    }
    
    
    public void render(Graphics g){
        
         for(int i = 0;i < object.size();i++){
          
           GameObject tempObj = object.get(i);
           tempObj.render(g);
       }
        
    }
    
    
    public void clearEnemies(){
        
        for(int i = 0; i < object.size(); i++){
            
            GameObject tempObj = object.get(i);
            
            if(tempObj.getid() == ID.Player){
                object.clear();
                
                if(Game.gameState != Game.STATE.End){
                 //addObject(new Player((int)tempObj.getX(),(int)tempObj.getY(),ID.Player, Game.handler,  ));
                 
                }
            }
            
        }
        
    }
    
    
    public void addObject(GameObject object){
        
        this.object.add(object);
        
    }
    
    public void removeObject(GameObject object){
        
        this.object.remove(object);
        
      }

   

   }
