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
    MainWorld myWorld;
    
    class Direction { // Class to store the values of the rotation for each movement
        public static final int UP = 270;
        public static final int DOWN = 90;
        public static final int LEFT = 180;
        public static final int RIGHT = 0;
    }
   
    public Player() {
         
    }
    
    public void addedToWorld(World w) {
        myWorld = (MainWorld)w;
    }
    
    public void act()
    {
        collectStuds();
    }
    
    public void movePlayer(
        String up, 
        String down, 
        String left, 
        String right, 
        int x, 
        int y, 
        GreenfootImage imageLeft,
        GreenfootImage imageRight,
        GreenfootImage imageFront
    ) {
        if(Greenfoot.isKeyDown(up)) {
            // setRotation(Direction.UP);
            jump(x,y);
        } else if(Greenfoot.isKeyDown(down)) {
            // setRotation(Direction.DOWN);
            fall(x,y);
        } else if(Greenfoot.isKeyDown(left)) {
            setImage(imageLeft);
            moveLeft(x,y);
        } else if(Greenfoot.isKeyDown(right)) {
            setImage(imageRight);
            moveRight(x,y);
        } else {
            setImage(imageFront);
        }
        // Actor ground = getOneObjectAtOffset(adjustOffset(x), adjustOffset(y), Ground.class);
        
        // if(ground==null) { 
           // setLocation(x, y + adjustOffset(y));
        // }
    }
    
    public void moveTopView(int x, int y, int rotation) {
        int currentX = x;
        int currentY = y;
        int direction = rotation; // getRotation()
        int changeX = getChangeX(direction);
        int changeY = getChangeY(direction);
        int adjustedChangeX = adjustOffset(changeX);
        int adjustedChangeY = adjustOffset(changeY);
        
        Actor block = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Block2x2.class);
        // if the block is null then we can move
        if(block==null) { 
           setLocation(currentX + changeX, currentY + changeY);
        }
    }
    
    /**
     * Resizes the given image to the widht and height specified
     */
    public GreenfootImage resizeImage(GreenfootImage image, int width, int height) {
        image.scale(width, height);
        setImage(image);
        
        return image;
    }
    
    /**
     * Simulates the gravity of the Player
     */
    public void fall(int x,int y)
    {
        setLocation(x, y + VSPEED);
        VSPEED = VSPEED + acceleration;
    }
    
    /**
     * Simulates the jump of the Player
     */
    public void jump(int x,int y)
    {
        VSPEED = - jumpStrenght;
        fall(x,y);
    }
    
    /**
     *  Checks if the Player is falling
     */
    public void checkFall(int x,int y)
    {
        if(!isTouching(Ground.class))
        {
            fall(x,y);
        }
    }
    
    /**
     * Moves the Player to the right
     */
    public void moveRight(int x,int y)
    {
        setLocation( x + SPEED, y);
    }
    
    /**
     * Moves the Player to the left
     */
    public void moveLeft(int x,int y)
    {
        setLocation( x - SPEED, y);
    }
    
    public int getChangeX(int direction) {
        if(direction == Direction.RIGHT) {
            return SPEED;
        } 
        if(direction == Direction.LEFT) {
            return -SPEED;
        }
        return 0;
    }
    
    public int getChangeY(int direction) {
        if(direction == Direction.DOWN) {
            return SPEED;
        } 
        if(direction == Direction.UP) {
            return -SPEED;
        }
        return 0;
    }
    
    private int adjustOffset(int offset) {
        int signOfOffset = (int)Math.signum(offset); // casting the offset to be int instead of double
        int distanceToFront = length/2;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
    }
    
    public void collectStuds() {
        Actor studBlue = getOneIntersectingObject(StudBlue.class);
        Actor studPurple = getOneIntersectingObject(StudPurple.class);
        
        if(studBlue!= null) {
            myWorld.removeObject(studBlue);
            myWorld.addScore(5);
        } else if (studPurple!= null) {
            myWorld.removeObject(studPurple);
            myWorld.addScore(1);
        }
    }
}
