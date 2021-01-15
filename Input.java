/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Enzo
 */
public class Input extends KeyAdapter {
    
    public static String username;
  
    
    public Input(String u){
        
        username = u;
        
    }
    
    
    public void setUserName(String u){
        username = u;
    }
    
    public String getUserName(){
        return username;
        
    }
    
   
  
    public void tick(){
        
        
    }
     
     @Override
     public void keyReleased(KeyEvent e){
         
         
        
    }
     
     
    @Override
     public void keyTyped(KeyEvent e){
         
       char key = KeyEvent.CHAR_UNDEFINED;
          
       if(Game.gameState == Game.STATE.Input){
            
            key = e.getKeyChar();
       
         if(key == KeyEvent.VK_BACK_SPACE)
           {
             if(username.length()>1){
               
              username = username.substring(0, username.length()-2);
               
            }
             else
             {
                username = username.substring(0, username.length()-1);
                 
             }
             
           }
           
           username = username + key;
              
        }
         
     }
     
    
}
