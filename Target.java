import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Actor
{
    MarioStyleWorld marioWorld;
    private int SPEED = 8;

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
    
    public void moveTarget() {
         if (getWorld() instanceof  MarioStyleWorld) {
            if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")) {
                move(SPEED);
            } else if(Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right")) {
                move(-SPEED);
            }
         }
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
