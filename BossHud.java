/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Enzo
 */
public class BossHud {
    
    public static double health = 1000;
    private int greenValue = 255; 

    
     public void tick(){
        
        health = (int) Game.clamp((int)health, 0, 1000);
        greenValue = (int) Game.clamp(greenValue, 0, 355);
        greenValue =(int) 255;
         
    }
    
    public void render(Graphics g){
        
       g.setColor(Color.GRAY);
       g.fillRect(300,15,550,32);
       g.setColor(new Color(75, greenValue, 0));
       g.fillRect(300, 15, (int)health,32);
       g.setColor(Color.WHITE);
       g.drawRect(300,15,550,32);
       g.drawString("health:" + health, 600, 65);

    }
    
 
}
