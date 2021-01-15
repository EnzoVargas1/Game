/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;

/**
 *
 * @author Enzo
 */
public class SpriteSheet {
    
    private BufferedImage sprite;
    
    public SpriteSheet(BufferedImage ss ){
        
        this.sprite = ss;
        
    }
    
    public BufferedImage grabImage(int col, int row, int width, int height){
        
        BufferedImage img = sprite.getSubimage((row*32)-32, (col*32)-32, width, height);
        return img;
    }
    
    
}
