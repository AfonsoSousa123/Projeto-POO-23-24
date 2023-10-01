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
        if(Greenfoot.isKeyDown("right"))
        {
            setImage(kwalkingR.getCurrentImage());
            moveRight();
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            setImage(kwalkingL.getCurrentImage());
            moveLeft();
        }
        else
        {
            setImage(kenF);
        }
        
        if(Greenfoot.isKeyDown("up"))
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
        setLocation( getX() + Speed , getY());
    }
    
    public  void moveLeft()
    {
        setLocation( getX() - Speed, getY());
    }
}
