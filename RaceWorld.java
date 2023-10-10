import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RaceWorld extends MainWorld
{
    private GreenfootImage bgImage = new GreenfootImage(getBackground());
    private int imageCount = 0;

    private Ken ken;
    private Barbie barbie;
    private int imageSize = 60;

    /**
     * Constructor for objects of class RaceWorld.
     * 
     */
    public RaceWorld()
    {

        prepare();
    }

    public void act() {
        imageCount += 1; //(or any other value; small -> slow moving, big -> fast movement)
        drawBackgroundImage();
    }

    public void drawBackgroundImage() {
        if (imageCount < -bgImage.getHeight()) {
            imageCount += bgImage.getHeight();
        }
        int temp = imageCount;
        getBackground().drawImage(bgImage, 0, temp);
        getBackground().drawImage(bgImage, 0, temp + bgImage.getHeight());
    }

    /**
     * Populate the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void populateWorld()
    {

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BarbieCar barbieCar = new BarbieCar();
        addObject(barbieCar,458,629);

        KenCar kenCar = new KenCar();
        addObject(kenCar,870,631);
    }
}
