import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KenCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KenCar extends Vehicle
{
    private int ImageSize;
    
    //Images Ken
    GreenfootImage kenCar = new GreenfootImage(getImage());
    
    public KenCar() {
        redimencionaImg(kenCar, 50);
        setImage(kenCar);
    }
    
    /**
     * Act - do whatever the KenCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
