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
    private int SPEED = 1;
    private int VSPEED = 0;
    private int acceleration = 2;
    private int imageSize = 30;
    private int count = 0;
    
    private int width = getImage().getWidth(); 
    private int height = getImage().getHeight();
    private int lookForWalls = width/3;
    private int lookForEdge = width/5; 
    private int lookForGround = height/2;
    
    public Mob() {
        
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        count++;
    }
    
    /**
     * Moves the Mob
     */
    public void moveMob(
        int x, 
        int y, 
        GifImage imageLeft,
        GifImage imageRight
    ) {
        if(getWorld() instanceof  MarioStyleWorld) {
            if(onGround(this)) {
                moveAround(imageLeft, imageRight, x, y);
            }
        } else if (getWorld() instanceof PacmanWorld) {
            // if(Greenfoot.isKeyDown(up)) {
                // // moveUp(x,y);
            // } else if() {
                // // moveDown(x,y);
            // } else if() {
                // setImage(imageLeft.getCurrentImage());
                // // moveLeft(x,y);
            // } else if() {
                // setImage(imageRight.getCurrentImage());
                // // moveRight(x,y);
            // }
        }
    }
    
    /**
     * Moves the Mob to the right and the left
     */
    public void moveAround(GifImage imageLeft, GifImage imageRight, int x, int y) {
        // Check if the Mob is colliding with any walls or cliffs.
        Actor wall = getOneObjectAtOffset(lookForWalls, 0, Ground.class);
        Actor cliff = getOneObjectAtOffset(lookForEdge, lookForGround, Ground.class);
        
        // If the Mob is colliding with a wall or cliff, reverse its direction
        if (wall != null || cliff != null) {
            SPEED *= -1;
            lookForWalls *= -1;
            lookForEdge *= -1;
        }
    
        // // Check if the Mob is turning left or right
        // if (x > 0) {
            // // Turning right.
            // setImage(imageRight.getCurrentImage());
        // } else if (x < 0) {
            // // Turning left.
            // setImage(imageLeft.getCurrentImage());
        // }
    
        // Move the Mob according to its speed
        setLocation(x + SPEED, y);
    }

    /**
     * Simulates the gravity of the Player
     */
    public void fall(int x,int y) {
        setLocation(x, y + VSPEED);
        VSPEED += acceleration;
    }
    
    /**
     *  Checks if the Player is falling
     */
    public void checkFall(Mob enemy, int x,int y) {
        if(getWorld() instanceof  MarioStyleWorld){
            if(!onGround(enemy)) {
                fall(x,y);
            } else if (onGround(enemy)) {
                VSPEED = 0;
            }
        }
    }
    
    /**
     *  Checks if the Mob is on the Ground
     */    
    public boolean onGround(Mob enemy) {
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
}
