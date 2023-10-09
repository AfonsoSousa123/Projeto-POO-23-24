import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mob extends Actor
{
    // Local variables
    private int SPEED = 2;
    private int VSPEED = 0;
    private int acceleration = 2;
    private int jumpStrenght = 50;
    private int length;
    private int volume = 20;
    private int oneUpVolume = 70;
    private int imageSize = 30;
    
    public Mob() {
        
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Moves the Mob
     */
    public void moveMob(
        String up, 
        String down, 
        String left, 
        String right, 
        int x, 
        int y, 
        GifImage imageLeft,
        GifImage imageRight,
        GreenfootImage imageFront
    ) {
        if(getWorld() instanceof  MarioStyleWorld) {
            if(Greenfoot.isKeyDown(up) && onGround(this)) {
                
            } else if(Greenfoot.isKeyDown(down)) {
                
            } else if(Greenfoot.isKeyDown(left)) {
                setImage(imageLeft.getCurrentImage());
                // moveLeft(x,y);
            } else if(Greenfoot.isKeyDown(right)) {
                setImage(imageRight.getCurrentImage());
                // moveRight(x,y);
            } else {
                setImage(imageFront);
            }
        }
        else if (getWorld() instanceof PacmanWorld) {
            if(Greenfoot.isKeyDown(up)) {
                // moveUp(x,y);
            } else if(Greenfoot.isKeyDown(down)) {
                // moveDown(x,y);
            } else if(Greenfoot.isKeyDown(left)) {
                setImage(imageLeft.getCurrentImage());
                // moveLeft(x,y);
            } else if(Greenfoot.isKeyDown(right)) {
                setImage(imageRight.getCurrentImage());
                // moveRight(x,y);
            } else {
                setImage(imageFront);
            }
        }
    }
    
    /**
     *  Checks if the Mob is on the Ground
     */    
    public boolean onGround(Actor Mob) {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/3, Ground.class);
        return ground != null;
    }
    
    public GreenfootImage redimencionaImg(GreenfootImage image, int percent) {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        return image;
    }

    public GifImage redimencionaGif(GifImage gif, int percent) {
        for (GreenfootImage image : gif.getImages())
        {
            int wide = image.getWidth()*percent/100;
            int high = image.getHeight()*percent/100;
            image.scale(wide, high);
        }
        return gif;
    }
    
    /**
     * Checks if the Mob is touching the right wall
     */
    public boolean checkRightWall(Actor Mob)
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = spriteWidth/2;
        
        Actor rWall = getOneObjectAtOffset(xDistance, 0, Block2x2.class);
        
        if(rWall == null)
        {
            return false;
        }
        else {
            StopByTherWall(rWall);
            return true;
        }
    }
    
    /**
     *  Mob stops when reaches a wall on the right
     */
    public void StopByTherWall(Actor rWall) {
        int wallWidth = rWall.getImage().getWidth();
        int newX = rWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX, getY());
    }
    
    /**
     *  Checks if the Mob is thoucing the left wall
     */
    public boolean checkLeftWall(Actor Mob)
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = spriteWidth/-3;
        
        Actor lWall = getOneObjectAtOffset(xDistance, 0, Block2x2.class);
        
        if(lWall != null)
        {
            StopByTheLWall(lWall);
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     *  Mob stops when reaches a wall on the left
     */
    public void StopByTheLWall(Actor lWall) {
        int wallWidth = lWall.getImage().getWidth();
        int newX = lWall.getX() + (wallWidth + getImage().getHeight())/3;
        setLocation(newX, getY());
    }
    
    /**
     * Moves the Mob to the right
     */
    public void moveRight(int x,int y) {
        setLocation(x + SPEED, y);
    }
    
    /**
     * Moves the Mob to the left
     */
    public void moveLeft(int x,int y) {
        setLocation(x - SPEED, y);
    }
    
    /**
     * Moves the Mob Down
     */
    public void moveDown(int x, int y) {
        setLocation(x, y + SPEED);
    }
    
    /**
     * Moves the Mob Up
     */
     public void moveUp(int x, int y) {
        setLocation(x, y - SPEED);
    }
}
