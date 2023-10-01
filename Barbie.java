import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barbie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barbie extends Player
{
    //GreenfootImage BARBIE;
    GreenfootImage barbieF = new GreenfootImage("Barbie_front.png");
    
    GifImage bwalkingR = new GifImage("barbie_walking_right.gif");
    GifImage bwalkingL = new GifImage("barbie_walking_left.gif");
    
    private int Speed = 5;
    private int vSpeed = 0;
    private int acceleration = 2;
    private int jumpStrenght = 12;
    
    public void act()
    {
        checkKeys();
        checkFall();
    }
    
    private void checkKeys()
    {
        //Andar esuqerda e direita
        if(Greenfoot.isKeyDown("D"))
        {
            setImage(bwalkingR.getCurrentImage());
            moveRight();
        }
        else if(Greenfoot.isKeyDown("A"))
        {
            setImage(bwalkingL.getCurrentImage());
            moveLeft();
        }
        else
        {
            setImage(barbieF);
        }
        
        if(Greenfoot.isKeyDown("W"))
        {
            jump();
        }
    }
    
    public void jump()
    {
        vSpeed = - jumpStrenght;
        fall();
    }
    
    public void checkFall()
    {
        if(!isTouching(Ground.class))
        {
            fall();
        }
    }
    
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    public void moveRight()
    {
        setLocation( getX() + Speed, getY());
    }
    
    public void moveLeft()
    {
        setLocation( getX() - Speed, getY());
    }
}
