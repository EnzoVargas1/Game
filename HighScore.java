/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.io.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Enzo
 */
public class HighScore implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;
    private int score;
    
    public HighScore(int score, String name ){
        this.score = score;
        this.name = name;
          
    }
    
    public void setScore(int score){
        this.score = score;
        
    }
    
    public int getScore(){
        return score;
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int compareTo(HighScore h){
        return new Integer(this.score).compareTo(h.score);
        
    }
    
    //this where there is an empty file in order to prevent exceptions
    private static void initializeFile(){
        HighScore[] h = {new HighScore(0, ""),new HighScore(0, ""),
                         new HighScore(0, ""), new HighScore(0, ""),
                         new HighScore(0, ""),new HighScore(0, ""),
                         new HighScore(0, "")};
        
        try{
            
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("HighScores.dat"));
            o.writeObject(h);
            o.close();
            
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        
    }
    
    //Reads the .dat file and returns the constants 
    public static HighScore[] getHighScores(){
        
   
        
        if(!new File("HighScores.dat").exists())
            initializeFile();
        
        
        try{
            
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("HighScores.dat"));
            HighScore[] h = (HighScore[])o.readObject();
            return h;
        }catch(IOException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
        
        return null;
    }
    
    //Adds a new HighScore .dat file and maintains the proper order
    public static void addHighScore(HighScore h){
        
        HighScore[] highscores = getHighScores();
        highscores [highscores.length-1] =  h;
        
        for(int i = highscores.length-2; i >= 0; i--){
            
            if(highscores[i+1].compareTo(highscores[i])>0)
            {
               HighScore temp = highscores[i];
               highscores[i] = highscores[i+1];
               highscores[i+1] = temp;   
            }
            
        }
         try{
            
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("HighScores.dat"));
            o.writeObject(highscores);
            o.close();
        }catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        
    }
    
    public static void delete(){
        
  
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("HighScores.dat"));
            o.reset();
            o.close();
        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        HighScore.initializeFile();
        HighScore.getHighScores();
        
    }
    
}