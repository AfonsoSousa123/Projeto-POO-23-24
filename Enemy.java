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
    GreenfootImage enemyF = new GreenfootImage(getImage());
    
    GifImage ewalkingR = new GifImage("ken_walking_right.gif");
    GifImage ewalkingL = new GifImage("ken_walking_left.gif");
    
    public Enemy(int imageSize) {
        this.ImageSize = imageSize;
        redimencionaGif(ewalkingL, ImageSize);
        redimencionaGif(ewalkingR, ImageSize);
        setImage(redimencionaImg(enemyF, ImageSize));
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
