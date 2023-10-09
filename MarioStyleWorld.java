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
    private GreenfootImage bgImage = new GreenfootImage("Clouds.jpg");
    private Ken ken;
    private Barbie barbie;
    private int imageSize = 80;

    /**
     * Constructor for objects of class MarioStyleWorld.
     * 
     */
    public MarioStyleWorld()
    {    
        super();
        setBackground(resizeImage(bgImage, 1000, 800)); // Scales the image to the desired width and height 
        prepare();
        populateWorld();
    }

    public void act() {
        // imageCount -= 1; //(or any other value; small -> slow moving, big -> fast movement)
        // drawBackgroundImage();
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
     * Populate the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void populateWorld()
    {
        Barbie barbie = new Barbie(imageSize);
        addObject(barbie,241,600);
        Ken ken = new Ken(imageSize);
        addObject(ken,423,604);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground,107,763);
        Ground ground2 = new Ground();
        addObject(ground2,358,763);
        Ground ground3 = new Ground();
        addObject(ground3,609,762);
        Ground ground4 = new Ground();
        addObject(ground4,858,762);
        Ground ground5 = new Ground();
        addObject(ground5,1202,582);
        Ground ground7 = new Ground();
        addObject(ground7,952,281);
        Ground ground8 = new Ground();
        addObject(ground8,1574,761);
        Ground ground9 = new Ground();
        addObject(ground9,1563,384);
        Ground ground10 = new Ground();
        addObject(ground10,1961,224);
        Ground ground11 = new Ground();
        addObject(ground11,1911,660);
        Ground ground12 = new Ground();
        addObject(ground12,2256,763);
        Ground ground14 = new Ground();
        addObject(ground14,160,191);
        Ground ground15 = new Ground();
        addObject(ground15,428,360);
        Ground ground17 = new Ground();
        addObject(ground17,2628,693);
        ground17.setLocation(2689,659);
        Ground ground18 = new Ground();
        addObject(ground18,2689,659);
        Ground ground19 = new Ground();
        addObject(ground19,2753,627);
        Ground ground20 = new Ground();
        addObject(ground20,3134,493);
        Ground ground21 = new Ground();
        addObject(ground21,3467,350);
        Ground ground22 = new Ground();
        addObject(ground22,3467,350);
        StudPurple studPurple = new StudPurple();
        addObject(studPurple,123,141);
        StudPurple studPurple2 = new StudPurple();
        addObject(studPurple2,953,225);
        StudBlue studBlue = new StudBlue();
        addObject(studBlue,1197,544);
        StudBlue studBlue2 = new StudBlue();
        addObject(studBlue2,1114,545);
        StudBlue studBlue3 = new StudBlue();
        addObject(studBlue3,1278,545);
        StudBlue studBlue4 = new StudBlue();
        addObject(studBlue4,512,309);
        StudBlue studBlue5 = new StudBlue();
        addObject(studBlue5,401,307);
        StudBlue studBlue6 = new StudBlue();
        addObject(studBlue6,1504,342);
        StudBlue studBlue7 = new StudBlue();
        addObject(studBlue7,1602,340);
        Ground ground23 = new Ground();
        addObject(ground23,3898,765);
        Ground ground24 = new Ground();
        addObject(ground24,4260,641);
        Ground ground25 = new Ground();
        addObject(ground25,4268,197);
        Ground ground26 = new Ground();
        addObject(ground26,4684,444);
        Ground ground27 = new Ground();
        addObject(ground27,5186,773);
        Ground ground28 = new Ground();
        addObject(ground28,4934,774);
        Ground ground29 = new Ground();
        addObject(ground29,5159,742);
        Ground ground30 = new Ground();
        addObject(ground30,4934,740);
        StudPurple studPurple3 = new StudPurple();
        addObject(studPurple3,1958,177);
        StudPurple studPurple4 = new StudPurple();
        addObject(studPurple4,3463,283);
        StudPurple studPurple5 = new StudPurple();
        addObject(studPurple5,4275,142);
        StudPurple studPurple6 = new StudPurple();
        addObject(studPurple6,5243,128);
        StudPurple studPurple7 = new StudPurple();
        addObject(studPurple7,5246,198);
        StudPurple studPurple8 = new StudPurple();
        addObject(studPurple8,5247,286);
        StudBlue studBlue8 = new StudBlue();
        addObject(studBlue8,5246,367);
        StudBlue studBlue9 = new StudBlue();
        addObject(studBlue9,5246,451);
        StudBlue studBlue10 = new StudBlue();
        addObject(studBlue10,5249,528);
        StudBlue studBlue11 = new StudBlue();
        addObject(studBlue11,5250,590);
        StudBlue studBlue12 = new StudBlue();
        addObject(studBlue12,5255,668);
        StudBlue studBlue13 = new StudBlue();
        addObject(studBlue13,4612,407);
        StudBlue studBlue14 = new StudBlue();
        addObject(studBlue14,4693,411);
        StudBlue studBlue15 = new StudBlue();
        addObject(studBlue15,4769,410);
        StudBlue studBlue16 = new StudBlue();
        addObject(studBlue16,4183,601);
        StudBlue studBlue17 = new StudBlue();
        addObject(studBlue17,4281,603);
        StudBlue studBlue18 = new StudBlue();
        addObject(studBlue18,4349,606);
        StudBlue studBlue19 = new StudBlue();
        addObject(studBlue19,3815,731);
        StudBlue studBlue20 = new StudBlue();
        addObject(studBlue20,1496,726);
        StudBlue studBlue21 = new StudBlue();
        addObject(studBlue21,1624,728);
        StudBlue studBlue22 = new StudBlue();
        addObject(studBlue22,1854,627);
        StudBlue studBlue23 = new StudBlue();
        addObject(studBlue23,1970,621);
        StudBlue studBlue24 = new StudBlue();
        addObject(studBlue24,2651,600);
        StudBlue studBlue25 = new StudBlue();
        addObject(studBlue25,2751,599);
        StudBlue studBlue26 = new StudBlue();
        addObject(studBlue26,2852,598);
        StudBlue studBlue27 = new StudBlue();
        addObject(studBlue27,3377,290);
        StudBlue studBlue28 = new StudBlue();
        addObject(studBlue28,3960,727);
        StudBlue studBlue29 = new StudBlue();
        addObject(studBlue29,4185,146);
        StudBlue studBlue30 = new StudBlue();
        addObject(studBlue30,4361,144);
        StudBlue studBlue31 = new StudBlue();
        addObject(studBlue31,3129,457);
        StudBlue studBlue32 = new StudBlue();
        addObject(studBlue32,3553,291);
        StudBlue studBlue33 = new StudBlue();
        addObject(studBlue33,2251,727);
        Heart heart = new Heart();
        addObject(heart,5114,131);
        heart.setLocation(5152,128);
        Heart heart2 = new Heart();
        addObject(heart2,1963,97);
        heart2.setLocation(1962,82);
        heart2.setLocation(2069,156);
        heart2.setLocation(2065,160);
    }
}