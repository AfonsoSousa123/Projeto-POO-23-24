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

    private MainWorld main;

    //Images Ken
    GreenfootImage enemyF = new GreenfootImage(getImage());

    GifImage eWalkingR = new GifImage("enemy_walking_R.gif");
    GifImage eWalkingL = new GifImage("enemy_walking_L.gif");

    public Enemy(int imageSize) {
        this.ImageSize = imageSize;
        redimencionaGif(eWalkingL, ImageSize);
        redimencionaGif(eWalkingR, ImageSize);
        setImage(redimencionaImg(enemyF, ImageSize));
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
        fall(getX(), getY());
        checkFall(this, getX(), getY());
    }
}
