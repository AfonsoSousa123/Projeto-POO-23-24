import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarbieCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarbieCar extends Vehicle
{
    private int ImageSize;
    
    //Images Ken
    GreenfootImage barbieCar = new GreenfootImage(getImage());
    
    public BarbieCar() {
        redimencionaImg(barbieCar, 50);
        setImage(barbieCar);
    }
    
    /**
     * Act - do whatever the BarbieCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
