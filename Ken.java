import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ken extends Player
{
    //Images Ken
    GreenfootImage kenF = new GreenfootImage("Ken_front.png");
    
    GifImage kwalkingR = new GifImage("ken_walking_right.gif");
    GifImage kwalkingL = new GifImage("ken_walking_left.gif");
    
    class KenKeys { // Class to store the values of the Keys for Ken
        public static final String UP = "up";
        public static final String DOWN = "down";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
    }
    
    public void act()
    {
        movePlayer(KenKeys.UP, KenKeys.DOWN, KenKeys.LEFT, KenKeys.RIGHT, getX(), getY(), kwalkingL.getCurrentImage(), kwalkingR.getCurrentImage());
        // checkKeys();
        // checkFall();
    }
    
    // private void checkKeys()
    // {
        // //Andar esuqerda e direita 
        // if(Greenfoot.isKeyDown("right"))
        // {
            // setImage(kwalkingR.getCurrentImage());
            // moveRight(getX(),getY());
        // }
        // else if(Greenfoot.isKeyDown("left"))
        // {
            // setImage(kwalkingL.getCurrentImage());
            // moveLeft(getX(),getY());
        // }
        // else
        // {
            // setImage(kenF);
        // }
        
        // if(Greenfoot.isKeyDown("up"))
        // {
            // jump();
        // }
    // }

}
