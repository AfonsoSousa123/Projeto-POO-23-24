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
    
    class KenKeys { // Class to store the values of the Keys for Ken
        private static final String UP = "up";
        private static final String DOWN = "down";
        private static final String LEFT = "left";
        private static final String RIGHT = "right";
    }
    
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
        moveVehicle(
            KenKeys.UP,
            KenKeys.DOWN, 
            KenKeys.LEFT, 
            KenKeys.RIGHT, 
            getX(), 
            getY()
        );
        collectStuds(this);
        collectHearts(this);
        collectStars(this);
        isTouchingVehicle(this, getX(), getY());
        isTouchingObject(this, getX(), getY());
    }
}
