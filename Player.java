import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int SPEED = 5;
    public int VSPEED = 0;
    public int acceleration = 2;
    public int jumpStrenght = 12;
    public int length;
    Actor ken;
    Actor barbie;
    
    // class Direction { // Class to store the values of the rotation for each movement
        // public static final int UP = 270;
        // public static final int DOWN = 90;
        // public static final int LEFT = 180;
        // public static final int RIGHT = 0;
    // }
    
    class KenKeys { // Class to store the values of the Keys for Ken
        public static final String UP = "up";
        public static final String DOWN = "down";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
    }
    
    
    public Player() {
        // movePlayer(KenKeys.UP,KenKeys.DOWN,KenKeys.LEFT,KenKeys.RIGHT, ken.getX(),ken.getY());
    }
    
    public void act()
    {
        
    }
    
    public void movePlayer(string up, string down, string left, string right, int x, int y) {
        if(Greenfoot.isKeyDown(up)) {
            // setRotation(Direction.UP);
            jump(x,y);
        } else if(Greenfoot.isKeyDown(down)) {
            // setRotation(Direction.DOWN);
            // movePlayer(x,y);
            fall(x,y);
        } else if(Greenfoot.isKeyDown(left)) {
            // setRotation(Direction.LEFT);
            moveLeft(x,y);
        } else if(Greenfoot.isKeyDown(right)) {
            moveRight(x,y);
        }
    }
    
    public void fall(int x,int y)
    {
        setLocation(x, y + VSPEED);
        VSPEED = VSPEED + acceleration;
    }
    
    public void jump(int x,int y)
    {
        VSPEED = - jumpStrenght;
        fall(x,y);
    }
    
    public void checkFall(int x,int y)
    {
        if(!isTouching(Ground.class))
        {
            fall(x,y);
        }
    }
    
    public void moveRight(int x,int y)
    {
        setLocation( x + SPEED, y);
    }
    
    public void moveLeft(int x,int y)
    {
        setLocation( x - SPEED, y);
    }
    
    // public void movePlayer(int x, int y) {
        // int currentX = x;
        // int currentY = y;
        // int direction = getRotation();
        // int changeX = getChangeX(direction);
        // int changeY = getChangeY(direction);
        // int adjustedChangeX = adjustOffset(changeX);
        // int adjustedChangeY = adjustOffset(changeY);
        
        // Actor block = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Block.class);
        // // if the block is null then we can move
        // if(block==null) { 
           // setLocation(currentX + changeX, currentY + changeY); 
        // }
        
    // }
    
    // public int getChangeX(int direction) {
        // if(direction == Direction.RIGHT) {
            // return SPEED;
        // } 
        // if(direction == Direction.LEFT) {
            // return -SPEED;
        // }
        // return 0;
    // }
    
    // public int getChangeY(int direction) {
        // if(direction == Direction.DOWN) {
            // return SPEED;
        // } 
        // if(direction == Direction.UP) {
            // return -SPEED;
        // }
        // return 0;
    // }
    
    // private int adjustOffset(int offset) {
        // int signOfOffset = (int)Math.signum(offset);
        // int distanceToFront = length/2;
        // int adjustAmount = distanceToFront * signOfOffset;
        // return offset + adjustAmount;
    // }
}
