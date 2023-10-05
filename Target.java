import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Actor
{
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Constructor for the Target class.
     * 
     */
    public Target() {
        
    }
    
    /**
     * Resizes the given image to the widht and height specified
     */
    public GreenfootImage resizeImage(GreenfootImage image, int width, int height) {
        image.scale(width, height);
        setImage(image);
        return image;
    }
}
