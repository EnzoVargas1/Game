/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Enzo
 */
public class BossScene {
    
    Random r = new Random();
    private Game game;
    private Handler handler;
    private HUD hud;
    private Controller c;
    private Spawn spawn;
    private int mx;
    private int my;
    private BufferedImage image;
    private AIDSController ac;
    
    
    public BossScene(Game game, Handler handler, HUD hud, Controller c, AIDSController ac)
    {   
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        this.c = c;
        this.ac = ac;
        this.spawn = spawn;
        
       // Game.handler.addObject(new BigBoss((Game.WIDTH/2),0, ID.BigBoss,handler, ac));
        
             
    }
    
    
    
    
    
    
 
    public void tick(){
        
        handler.tick();
        //ac.tick();
        c.tick();
        hud.tick();
         
    }
    
    
    
    
    public void render(Graphics g){
        
        handler.render(g);
        //ac.render(g);
        c.render(g);
        hud.render(g);
        
    }
    
}
