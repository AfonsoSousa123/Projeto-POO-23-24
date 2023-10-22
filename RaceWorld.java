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
    private int imageCount = -600;
    private int imageSize = 60;
    
    
    private KenCar ken;
    private BarbieCar barbie;
    
    /**
     * Constructor for objects of class RaceWorld.
     * 
     */
    public RaceWorld()
    {
        populateWorld();
        prepare();
         moedas();
        //setPaintOrder(Scoreboard.class,BabieCar.class,KenCar.class,StudBlue.class,StudPurple.class,Heart.class,Star.class);
    }

    public void act() {
        imageCount += 1; //(small -> slow moving, big -> fast movement)
        drawBackgroundImage();
        checkStarCount();
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
        BarbieCar barbieCar = new BarbieCar();
        addObject(barbieCar,432,629);

        KenCar kenCar = new KenCar();
        addObject(kenCar,802,631);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
    
     private void moedas(){
        for(int i = 0; i<Greenfoot.getRandomNumber(5)+10;i++){
            addObject(new StudBlue(),Greenfoot.getRandomNumber(630)+300,Greenfoot.getRandomNumber(630));
            addObject(new StudPurple(),Greenfoot.getRandomNumber(630)+300,Greenfoot.getRandomNumber(630));
        }
    }
}
