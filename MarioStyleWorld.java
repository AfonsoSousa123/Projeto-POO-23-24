import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MarioStyleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarioStyleWorld extends MainWorld
{
    private int imageCount = 0;
    private GreenfootImage bgImage = new GreenfootImage("space1.jpg");

    /**
     * Constructor for objects of class MarioStyleWorld.
     * 
     */
    public MarioStyleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // super(1300, 800, 1); 
        prepare();
    }

    public void act() {
        imageCount -= 1; //(or any other value; small -> slow moving, big -> fast movement)
        drawBackgroundImage();
    }

    public void drawBackgroundImage() {
        if (imageCount < -bgImage.getWidth()) {
            imageCount += bgImage.getWidth();
        }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BarbieCar barbieCar = new BarbieCar();
        addObject(barbieCar,229,718);
        KenCar kenCar = new KenCar();
        addObject(kenCar,709,479);
    }
}
