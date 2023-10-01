import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    final int speed = 2;
    public int length;
    
    class Direction { // Class to store the values of the rotation for each movement
        public static final int UP = 270;
        public static final int DOWN = 90;
        public static final int LEFT = 180;
        public static final int RIGHT = 0;
    }
    
    public Player() {
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("w")) {
            setRotation(Direction.UP);
            movePlayer();
        } else if(Greenfoot.isKeyDown("s")) {
            setRotation(Direction.DOWN);
            movePlayer();
        } else if(Greenfoot.isKeyDown("a")) {
            setRotation(Direction.LEFT);
            movePlayer();
            // image.mirrorHorizontally();
        } else if(Greenfoot.isKeyDown("d")) {
            setRotation(Direction.RIGHT);
            movePlayer();
            // image.mirrorHorizontally();
        }
    }
    
    private void movePlayer() {
        int currentX = getX();
        int currentY = getY();
        int direction = getRotation();
        int changeX = getChangeX(direction);
        int changeY = getChangeY(direction);
        int adjustedChangeX = adjustOffset(changeX);
        int adjustedChangeY = adjustOffset(changeY);
        
        Actor block = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Block.class);
        // if the block is null then we can move
        if(block==null) { 
           setLocation(currentX + changeX, currentY + changeY); 
        }
        
    }
    
    private int getChangeX(int direction) {
        if(direction == Direction.RIGHT) {
            return speed;
        } 
        if(direction == Direction.LEFT) {
            return -speed;
        }
        return 0;
    }
    
    private int getChangeY(int direction) {
        if(direction == Direction.DOWN) {
            return speed;
        } 
        if(direction == Direction.UP) {
            return -speed;
        }
        return 0;
    }
    
    private int adjustOffset(int offset) {
        int signOfOffset = (int)Math.signum(offset);
        int distanceToFront = length/2;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
    }
}
