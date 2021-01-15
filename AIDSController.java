/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Enzo
 */
public class AIDSController {
    
     LinkedList<GameObject> ab =new LinkedList<GameObject>();
     
     GameObject tempBullet;
    
    public void tick(){
        
        for(int i = 0; i < ab.size(); i++){
            
            tempBullet = ab.get(i);
            tempBullet.tick();
            
        }
        
        
    }
    
    
     public void render(Graphics g){
        
         for(int i = 0; i < ab.size(); i++){
            
            tempBullet = ab.get(i);
            tempBullet.render(g);
            
       }
         
    }
    
    
    public void addBullet(GameObject block){
        
        this.ab.add(block);
        
    }
    
     public void removeBullet(GameObject block){
        
        this.ab.remove(block);
        
    }
     
     public void removeAll(){
         
         for(int i = 0; i < ab.size(); i++){
             
           GameObject tempObject = ab.get(i);
           
           if(tempObject.getid() == ID.Bullet){
              ab.clear();
               
           }
             
         }
         
         
     }
    
}
