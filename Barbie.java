import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barbie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barbie extends Player
{
    GreenfootImage barbieF = new GreenfootImage("Barbie_front.png");
    
    GifImage bwalkingR = new GifImage("barbie_walking_right.gif");
    GifImage bwalkingL = new GifImage("barbie_walking_left.gif");
    
    class BarbieKeys { // Class to store the values of the Keys for Barbie
        public static final String UP = "W";
        public static final String DOWN = "S";
        public static final String LEFT = "A";
        public static final String RIGHT = "D";
    }
    
    public void act()
    {
        movePlayer(BarbieKeys.UP, BarbieKeys.DOWN, BarbieKeys.LEFT, BarbieKeys.RIGHT, getX(), getY(), bwalkingL.getCurrentImage(), bwalkingR.getCurrentImage());
        // checkKeys();
        // checkFall();
    }
    
    // private void checkKeys()
    // {
        // //Andar esuqerda e direita
        // if(Greenfoot.isKeyDown(BarbieKeys.RIGHT))
        // {
            // setImage(bwalkingR.getCurrentImage());
            // moveRight();
        // }
        // else if(Greenfoot.isKeyDown(BarbieKeys.LEFT))
        // {
            // setImage(bwalkingL.getCurrentImage());
            // moveLeft();
        // }
        // else
        // {
            // setImage(barbieF);
        // }
        
        // if(Greenfoot.isKeyDown("W"))
        // {
            // jump();
        // }
    // }
    
    // public void jump()
    // {
        // vSpeed = - jumpStrenght;
        // fall();
    // }
    
    // public void checkFall()
    // {
        // if(!isTouching(Ground.class))
        // {
            // fall();
        // }
    // }
}
