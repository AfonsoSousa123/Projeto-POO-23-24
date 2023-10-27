import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RaceWorld extends MainWorld
{
    private GreenfootImage bgImage = new GreenfootImage(getBackground()); // Image Variable
    
    private int imageCount = 0; // counter for the Image
    private int ImageSize = 60; // Size for the Image
    private int timer = 0; // timer for the studs
    private int heartsTimer = 0; // timer for the hearts
    private int obstaclesTimer = 0; // timer for the objects
    private int starsTimer = 0; // timer for the Stars

    private KenCar ken;
    private BarbieCar barbie;

    private int maxX = 630; // maximum X
    private int minX = 300; // minimum X
    private int maxY = 50; // maximum Y
    private int minY = 0; // minimum Y

    /**
     * Constructor for RaceWorld class.
     * Contrutor para a Classe RaceWorld.
     */
    public RaceWorld()
    {
        prepare(); // Calls the prepare method
        setPaintOrder(Scoreboard.class, Player.class); // Sets the Paint Order for the RaceWorld
    }

    public void act() {
        timer++; // timer for the studs
        heartsTimer++; // timer for the hearts
        obstaclesTimer++; // timer for the objects
        starsTimer++; // timer for the Stars

        imageCount += 3; //(small -> slow moving, big -> fast movement)
        drawBackgroundImage(); // Prints the BackgroundImage

        populateWorld(); // Spawns the Objects into the World
        checkStarCount(); // Calls the checkStarCount
    }

    /**
     * Draws the backgroundImage
     * Desenha o fundo do mundo
     */
    public void drawBackgroundImage() {
        int temp = imageCount % bgImage.getHeight();
        
        // enquanto o temp for maior que a 
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
        spawnMoedas(); // Chama o método spawnMoedas
        spawnStars(); // Chama o método spawnStars
        spawnHearts(); // Chama o método spawnHearts
        spawnObstacles(); // Chama o método spawnObjects
    }

    /**
     * Populates the Stars in the world
     * Adiciona as estrelas no mundo
     */
    private void spawnStars() {
        if(starsTimer > 1000) {      
            addObject(new Star(), Greenfoot.getRandomNumber(630)+300, minY);
            starsTimer = 0; // reseta o starsTimer
        }
    }

    /**
     * Populates the Hearts in the world
     * Adiciona as Hearts no mundo
     */
    private void spawnHearts() {
        if(heartsTimer > 1000) {
            for (int i = 0; i < 2; i++) {            
                addObject(new Heart(), Greenfoot.getRandomNumber(630)+300, minY);
            }
            heartsTimer = 0; // reseta o heartsTimer
        }
    }

    /**
     * Populates the Obstacles in the world
     * Adiciona as Obstacles no mundo
     */
    private void spawnObstacles() {
        if(obstaclesTimer > 600) {
            addObject(new Ground(), Greenfoot.getRandomNumber(maxX)+ minX, minY);
            // addObject(new Block2x2(), Greenfoot.getRandomNumber(maxX)+ minX, minY);
            obstaclesTimer = 0;
        }
    }  

    /**
     * Populates the Studs in the world
     * Adiciona as Studs no mundo
     */
    private void spawnMoedas() {
        if(timer > 200) {
            for(int i = 0; i < Greenfoot.getRandomNumber(5)+2; i++){
                addObject(new StudBlue(), Greenfoot.getRandomNumber(630)+300, minY);
            }
            for(int i = 0; i < Greenfoot.getRandomNumber(5)+2; i++){
                addObject(new StudPurple(), Greenfoot.getRandomNumber(630)+300, minY);
            }
            timer = 0;
        }
    }
}
