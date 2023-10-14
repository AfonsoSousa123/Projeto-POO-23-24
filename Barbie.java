import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barbie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barbie extends Player
{
    private int ImageSize;
    
    GreenfootImage barbieF = new GreenfootImage("Barbie_front.png");
    
    GifImage bwalkingR = new GifImage("barbie_walking_right.gif");
    GifImage bwalkingL = new GifImage("barbie_walking_left.gif");
    
    class BarbieKeys { // Class to store the values of the Keys for Barbie
        private static final String UP = "W";
        private static final String DOWN = "S";
        private static final String LEFT = "A";
        private static final String RIGHT = "D";
    }
    
    /**
     * Constructor for the Barbie Class.
     * 
     */
    public Barbie(int imageSize)
    {
        this.ImageSize = imageSize;
        redimencionaGif(bwalkingL, ImageSize);
        redimencionaGif(bwalkingR, ImageSize);
        setImage(redimencionaImg(barbieF, ImageSize));
    }
    
    public void act()
    {
        movePlayer(
            BarbieKeys.UP, 
            BarbieKeys.DOWN, 
            BarbieKeys.LEFT, 
            BarbieKeys.RIGHT, 
            getX(), 
            getY(), 
            bwalkingL, 
            bwalkingR,
            barbieF
        );
        checkBounds(this);
        checkFall(this, getX(), getY());
        onGround(this);
        platformAbove(this);
        collectStuds(this);
        collectHearts(this);
        checkRightWall(this);
        checkLeftWall(this);
        cubeAbove(this);
        cubeUnder(this);
    }
}
