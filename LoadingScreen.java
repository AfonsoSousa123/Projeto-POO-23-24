import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadingScreen extends MainWorld
{
    private GreenfootImage bgImage = new GreenfootImage(getBackground());
    
    /**
     * Constructor for objects of class LoadingScreen.
     * 
     */
    public LoadingScreen() {
        super();
        setBackground(resizeImage(bgImage, 1300, 800)); // Scales the image to the desired width and height 
    }
}
