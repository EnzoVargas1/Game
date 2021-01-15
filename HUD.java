/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author Enzo
 */
public class HUD  {
    
    public static int health = 100;
    private int greenValue = 255; 
    public int score = 0;
    private int level = 1;
    
    public void tick(){
        
        health = (int) Game.clamp(health, 0, 100);
        greenValue = (int) Game.clamp(greenValue, 0, 255);
        greenValue = health*2;
        score++;
        
    }
    
    public void render(Graphics g){
        
       g.setColor(Color.GRAY);
       g.fillRect(15,15,200,32);
       g.setColor(new Color(75, greenValue, 0));
       g.fillRect(15, 15, health*2,32);
       g.setColor(Color.WHITE);
       g.drawRect(15,15,200,32);
       g.drawString("Score: " + score, 10, 64 );
       g.drawString("level: " + level, 10, 80 );
       
    }
    
    public void score(int score){
        
        this.score = score;
        
    }
    
    public int getScore(){
        
        return score;
    }
    
    public int getLevel(){
        
       return level;
        
    }
    
    public void setLevel(int level){
        
        this.level = level;
        
    }
}
