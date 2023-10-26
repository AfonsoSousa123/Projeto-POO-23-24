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
    private int imageSize = 60;
    
    private int randomY = 5000;
    private int randomX = 630;
    
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
        //setPaintOrder(Scoreboard.class,BabieCar.class,KenCar.class,StudBlue.class,StudPurple.class,Heart.class,Star.class);
    }

    public void act() {
        imageCount += 3; //(small -> slow moving, big -> fast movement)
        drawBackgroundImage();
        checkStarCount();
    }

    /**
     * Draws the backgroundImage
     * Desenha o fundo do mundo
     */
    public void drawBackgroundImage() {
        /*if (imageCount < -bgImage.getHeight()) {
            imageCount += bgImage.getHeight();
        }
        
        int temp = imageCount;
        getBackground().drawImage(bgImage, 0, temp);
        getBackground().drawImage(bgImage, 0, temp + bgImage.getHeight());
        */
        int temp = imageCount % bgImage.getHeight();
        
        while (temp > -bgImage.getHeight()) {
            temp -= bgImage.getHeight();
        }
        // Desenha instâncias da imagem de fundo
        while (temp < getHeight()) {
            getBackground().drawImage(bgImage, 0, temp);
            temp += bgImage.getHeight();
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        BarbieCar barbieCar = new BarbieCar();
        addObject(barbieCar,432,631);

        KenCar kenCar = new KenCar();
        addObject(kenCar,802,631);
    }

    /**
     * Populate the world for the start of the program.
     * 
     */
    private void populateWorld() {
        moedas();
        spawnStars();
        spawnHearts();
        spawnObjects();
    }
    
    /**
     * Populates the Stars in the world
     * Adiciona as estrelas no mundo
     */
    private void spawnStars() {
        for (int i = 0; i < 2; i++) {            
            addObject(new Star(), Greenfoot.getRandomNumber(630)+300, Greenfoot.getRandomNumber(5000)-900);
        }
    }
    
    /**
     * Populates the Hearts in the world
     * Adiciona as Hearts no mundo
     */
    private void spawnHearts() {
        for (int i = 0; i < 2; i++) {            
            addObject(new Heart(), Greenfoot.getRandomNumber(630)+300, Greenfoot.getRandomNumber(5000)-1000);
        }
    }
    
    /**
     * Populates the Objects in the world
     * Adiciona as Objetos no mundo
     */
    private void spawnObjects() {
        int max = 5000;
        int min = 900;
        
        for (int i = 0; i < Greenfoot.getRandomNumber(5)+5; i++) {            
            addObject(new Ground(), Greenfoot.getRandomNumber(630)+300, Greenfoot.getRandomNumber(max-min)-min);
            addObject(new Block2x2(), Greenfoot.getRandomNumber(630)+300, Greenfoot.getRandomNumber(max-min)-min);
            // addObject(new Block2x4(), Greenfoot.getRandomNumber(630)+300, Greenfoot.getRandomNumber(5000)-1000);
        }
    }  
    
    /**
     * Populates the Studs in the world
     * Adiciona as stud no mundo
     */
    private void moedas() {
        for(int i = 0; i < Greenfoot.getRandomNumber(5)+10;i++){
            addObject(new StudBlue(), Greenfoot.getRandomNumber(630)+300, Greenfoot.getRandomNumber(5000)-900);
            addObject(new StudPurple(), Greenfoot.getRandomNumber(630)+300, Greenfoot.getRandomNumber(5000)-900);
        }
    }
}
