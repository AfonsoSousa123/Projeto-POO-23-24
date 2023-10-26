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
    private int timer = 0;
    private int heartsTimer = 0;
    private int objectsTimer = 0;
    private int starsTimer = 0;

    private KenCar ken;
    private BarbieCar barbie;

    int maxX = 630;
    int minX = 300;
    int maxY = 50;
    int minY = 0;

    /**
     * Constructor for objects of class RaceWorld.
     * 
     */
    public RaceWorld()
    {
        prepare();
        setPaintOrder(Scoreboard.class,Player.class);
    }

    public void act() {
        timer++; // timer for the studs
        heartsTimer++; // timer for the hearts
        objectsTimer++; // timer for the objects
        starsTimer++; // timer for the Stars

        imageCount += 3; //(small -> slow moving, big -> fast movement)
        drawBackgroundImage();

        populateWorld(); // Spawns the Objects into the World
    }

    /**
     * Draws the backgroundImage
     * Desenha o fundo do mundo
     */
    public void drawBackgroundImage() {
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
        spawnMoedas();
        spawnStars();
        spawnHearts();
        spawnObjects();
    }

    /**
     * Populates the Stars in the world
     * Adiciona as estrelas no mundo
     */
    private void spawnStars() {
        if(starsTimer > 5000) {      
            addObject(new Star(), Greenfoot.getRandomNumber(630)+300, minY);
            starsTimer = 0;
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
            heartsTimer = 0;
        }
    }

    /**
     * Populates the Objects in the world
     * Adiciona as Objetos no mundo
     */
    private void spawnObjects() {
        if(objectsTimer > 600) {
            addObject(new Ground(), Greenfoot.getRandomNumber(maxX)+ minX, minY);
            // addObject(new Block2x2(), Greenfoot.getRandomNumber(maxX)+ minX, minY);
            objectsTimer = 0;
        }
    }  

    /**
     * Populates the Studs in the world
     * Adiciona as stud no mundo
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
