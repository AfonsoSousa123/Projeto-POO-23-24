import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlanetaTerra extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PlanetaTerra()
    {    
        // Create a new world with 1300x800  cells with a cell size of 1x1 pixels.
        super(1300, 800, 1);
        populateWorld();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void populateWorld()
    {
        Barbie barbie = new Barbie();
        addObject(barbie,570, 622);
        
        Ken ken = new Ken();
        addObject(ken,750, 591);
        
        Ground ground = new Ground();
        addObject(ground,944, 797);
    }}
