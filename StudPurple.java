import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StudPurple extends Target
{
    /**
     * Constructor for the StudPurple Class.
     * Construtor para a StudPurple Class.
     */
    public StudPurple() {
        resizeImage(getImage(), 50, 50);
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
