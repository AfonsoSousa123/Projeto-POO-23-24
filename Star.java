import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Target
{
    /**
     * Constructor for the Star Class.
     * Construtor para a Star Class.
     */
    public Star() {
        resizeImage(getImage(), getImage().getWidth()/4, getImage().getHeight()/4);
    }
    
    /**
     * Act - do whatever the Stud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveTarget(getX(), getY());
    }
}
