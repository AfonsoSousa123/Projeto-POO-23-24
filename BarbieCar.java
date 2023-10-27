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
    
    Player player;
    
    //Images Ken
    GreenfootImage barbieCar = new GreenfootImage(getImage());
    
    class BarbieKeys { // Class to store the values of the Keys for Barbie
        private static final String UP = "W";
        private static final String DOWN = "S";
        private static final String LEFT = "A";
        private static final String RIGHT = "D";
    }
    
    public BarbieCar() {
       ImageSize = 30;
    }
    
    public BarbieCar(int imageSize) {
        this.ImageSize = imageSize;
        redimencionaImg(barbieCar, 50);
        setImage(barbieCar);
    }
    
    /**
     * Act - do whatever the BarbieCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveVehicle(
            BarbieKeys.UP,
            BarbieKeys.DOWN, 
            BarbieKeys.LEFT, 
            BarbieKeys.RIGHT, 
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
