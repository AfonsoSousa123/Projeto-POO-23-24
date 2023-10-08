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
        super(1300, 800, 1, false); // the boolean atribute, is to set the world with bounds
        sb = new Scoreboard();
        addObject(sb, getWidth()/2, 30); // Adds the Scoreboard onto the Worlds
    }
    
    public void act()
    {
        
    }
    
    /**
     * Public Method for the score to be accessible to all the Project
     */
    public void addScore(int amount) { 
        sb.addScore(amount);
    }
    
    /**
     * Public Method for the lives to be accessible to all the Project
     */
    public void addBarbieLives(int amount) { 
        sb.addBarbieLives(amount);
    }
    
    /**
     * Public Method for the lives to be accessible to all the Project
     */
    public void addKenLives(int amount) { 
        sb.addKenLives(amount);
    }
    
    /**
     * Public Method for the lives to be accessible to all the Project
     */
    public void removeBarbieLives(int amount) { 
        sb.removeBarbieLives(amount);
    }
    
    /**
     * Public Method for the lives to be accessible to all the Project
     */
    public void removeKenLives(int amount) { 
        sb.removeKenLives(amount);
    }
    
    /**
     * Resizes the given background to the widht and height specified
     */
    public GreenfootImage resizeImage(GreenfootImage imageBackground, int width, int height) {
        imageBackground.scale(width, height);
        setBackground(imageBackground);
        return imageBackground;
    }
}
