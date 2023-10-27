import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlanetaTerra extends MainWorld
{
    private int playerSize = 80;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PlanetaTerra()
    {    
        // Create a new world with 1300x800  cells with a cell size of 1x1 pixels.
        // super(1300, 800, 1);
        populateWorld();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void populateWorld()
    {
        Barbie barbie = new Barbie(playerSize);
        addObject(barbie,570, 634);

        Ken ken = new Ken(playerSize);
        addObject(ken,750, 634);
        
        Ground ground = new Ground();
        addObject(ground,1163,754);
        Ground ground2 = new Ground();
        addObject(ground2,912,755);
        Ground ground3 = new Ground();
        addObject(ground3,653,753);
        Ground ground4 = new Ground();
        addObject(ground4,384,753);
        Ground ground5 = new Ground();
        addObject(ground5,115,754);
        
        Portal portal = new Portal();
        addObject(portal,1111,645);
        
        setPaintOrder(Player.class, Portal.class);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}
