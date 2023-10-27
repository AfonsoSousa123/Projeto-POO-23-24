import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Mob
{
    private int ImageSize;

    //Images Ken
    private GreenfootImage enemyF = new GreenfootImage(getImage());

    private GifImage eWalkingR = new GifImage("enemy_walking_R.gif");
    private GifImage eWalkingL = new GifImage("enemy_walking_L.gif");
    
    /**
     * Constructor for the Enemy Class.
     * Construtor para a Enemy Class.
     */
    public Enemy() {
        ImageSize = 30;
        redimencionaGif(eWalkingL, ImageSize);
        redimencionaGif(eWalkingR, ImageSize);
        setImage(redimencionaImg(enemyF, ImageSize));
    }
    
    /**
     * Overloaded Constructor for the Enemy Class.
     * Overloaded Construtor para a Enemy Class.
     */
    public Enemy(int imageSize) {
        this.ImageSize = imageSize;
        redimencionaGif(eWalkingL, imageSize);
        redimencionaGif(eWalkingR, imageSize);
        setImage(redimencionaImg(enemyF, imageSize));
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveMob(
            getX(), 
            getY(), 
            eWalkingR,
            eWalkingL
        );
        checkEdges(this, getX(), getY());
    }
}
