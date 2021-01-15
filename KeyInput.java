/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Game.STATE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Enzo
 */
public class KeyInput extends KeyAdapter{
    
    private Handler handler;
    private boolean keyDown [] = new boolean[4];
    
    
    KeyInput(Handler handler)
     {
        
     this.handler = handler; 
     keyDown[0] = false;
     keyDown[1] = false;
     keyDown[2] = false;
     keyDown[3] = false;
        
     }
    
    
    
    @Override
    public void keyPressed(KeyEvent e){
        
        int key = e.getKeyCode();
             
        for(int i = 0;i < handler.object.size();i++){
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getid() == ID.Player ){
              
                switch (key) {
                    case KeyEvent.VK_UP:
                         tempObject.setVelY(-3);
                         keyDown[0] = true;
                         break;
                    case KeyEvent.VK_DOWN:
                        tempObject.setVelY(3);
                        keyDown[1] = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        tempObject.setVelX(3);
                        keyDown[2] = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        tempObject.setVelX(-3);
                        keyDown[3] = true;
                        break;
                    case KeyEvent.VK_W:
                        tempObject.setVelY(-3);
                        keyDown[0] = true;
                        break;
                    case KeyEvent.VK_S:  
                        tempObject.setVelY(3);
                        keyDown[1] = true;
                        break;
                    case KeyEvent.VK_D:
                        tempObject.setVelX(3);
                        keyDown[2] = true;
                        break;
                    case KeyEvent.VK_A:
                        tempObject.setVelX(-3);
                        keyDown[3] = true;
                        break; 
                        
                }
                
              if(key == KeyEvent.VK_SPACE)Game.c.addBullet(new Bullet(tempObject.getX() +  14,tempObject.getY(),ID.Bullet));
                
          }
            
        }
      if(key == KeyEvent.VK_ESCAPE) System.exit(1);
      
      if(Game.gameState == Game.STATE.Input){
          if(key == KeyEvent.VK_ENTER) Game.gameState = STATE.Menu; 
      }
      
      if(Game.gameState == Game.STATE.Game || Game.gameState == Game.STATE.BossScene){
    
          if(key == KeyEvent.VK_P){
              
              if(Game.paused)Game.paused = false;
              else Game.paused = true;
             
          }
          
          
      }
    }
    
    
    @Override
    public void keyReleased(KeyEvent e){
        
        int key = e.getKeyCode();
        
        for(int i = 0; i<handler.object.size(); i++){
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getid()==ID.Player){
                
                if(key == KeyEvent.VK_UP)keyDown[0] = false;
                if(key == KeyEvent.VK_DOWN)keyDown[1] = false;
                if(key == KeyEvent.VK_RIGHT)keyDown[2] = false;
                if(key == KeyEvent.VK_LEFT)keyDown[3] = false;
                
                
                if(!keyDown[0] && !keyDown[1])tempObject.setVelY(0);
                if(!keyDown[2] && !keyDown[3])tempObject.setVelX(0);
                
                
            }
            
             if(tempObject.getid()==ID.Player){
                
                if(key == KeyEvent.VK_W)keyDown[0] = false;
                if(key == KeyEvent.VK_S)keyDown[1] = false;
                if(key == KeyEvent.VK_D)keyDown[2] = false;
                if(key == KeyEvent.VK_A)keyDown[3] = false;
                
                if(!keyDown[0] && !keyDown[1])tempObject.setVelY(0);
                if(!keyDown[2] && !keyDown[3])tempObject.setVelX(0);
                
            }
            
        }
        
    }
    
    
    
    
}
