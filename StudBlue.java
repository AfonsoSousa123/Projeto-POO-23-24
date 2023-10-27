import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StudBlue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StudBlue extends Target
{
    /**
     * Constructor for the StudBlue Class.
     * Construtor para a StudBlue Class.
     */
    public StudBlue() {
        resizeImage(getImage(), 50, 50);
    }
    
    /**
     * Act - do whatever the StudBlue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveTarget(getX(), getY());
    }
}
