import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    Scoreboard sb; // space variable
    
    /**
     * Constructor for objects of class MainWorld.
     * 
     */
    public MainWorld()
    {    
        // Create a new world with 1300x800 cells with a cell size of 1x1 pixels.
        super(1300, 800, 1, true); // the boolean atribute, is to set the world with bounds
        sb = new Scoreboard();
        addObject(sb, getWidth()/2, 30); // Adds the Scoreboard onto the Worlds
    }
    
    /**
     * Public Method for the score to be accessible from all the Project
     */
    public void addScore(int amount) { 
        sb.addScore(amount);
    }
    
}
