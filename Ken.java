import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ken extends Player
{
    private int ImageSize;
    
    //Images Ken
    GreenfootImage kenF = new GreenfootImage("Ken_front.png");
    
    GifImage kwalkingR = new GifImage("ken_walking_right.gif");
    GifImage kwalkingL = new GifImage("ken_walking_left.gif");
    
    public class KenKeys { // Class to store the values of the Keys for Ken
        public static final String UP = "up";
        public static final String DOWN = "down";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
    }
    
    /**
     * Constructor for the Ken Class.
     * 
     */
    public Ken(int imageSize)
    {
        this.ImageSize = imageSize;
        redimencionaGif(kwalkingL, ImageSize);
        redimencionaGif(kwalkingR, ImageSize);
        setImage(redimencionaImg(kenF, ImageSize));
    }
    
    public void act()
    {
        movePlayer(
            KenKeys.UP, 
            KenKeys.DOWN, 
            KenKeys.LEFT, 
            KenKeys.RIGHT, 
            getX(), 
            getY(), 
            kwalkingL, 
            kwalkingR,
            kenF
        );
        checkBounds(this);
        checkFall(this, getX(), getY());
        onGround(this);
        platformAbove(this);
        collectStuds(this);
        collectHearts(this);
        collectStars(this);
        checkRightWall(this);
        checkLeftWall(this);
        cubeAbove(this);
        cubeUnder(this);
    }
}
