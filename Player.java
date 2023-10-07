import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // Local variables
    private int SPEED = 2;
    private int VSPEED = 0;
    private int acceleration = 2;
    private int jumpStrenght = 20;
    private int length;
    private int volume = 20;
    private int oneUpVolume = 70;

    // Initializes the sounds
    GreenfootSound gameOverSound = new GreenfootSound("Falling-object.mp3");
    GreenfootSound coinSound = new GreenfootSound("8bit-coin-sound-effect.mp3");
    GreenfootSound oneUpSound = new GreenfootSound("1-up.wav");

    // World variables
    MainWorld mainWorld;
    
    // class Direction { // Class to store the values of the rotation for each movement
        // public static final int UP = 270;
        // public static final int DOWN = 90;
        // public static final int LEFT = 180;
        // public static final int RIGHT = 0;
    // }
   
    public Player() {
        
    }
    
    public void addedToWorld(World w) {
        mainWorld = (MainWorld)w;
    }
    
    public void act()
    {
        
    }
    
    /**
     * Moves the Player
     */
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
        if(getWorld() instanceof  MarioStyleWorld) {
        if(Greenfoot.isKeyDown(up)) {
            // setRotation(Direction.UP);
            jump(x,y);
        } else if(Greenfoot.isKeyDown(down)) {
            // setRotation(Direction.DOWN);
            //fall(x,y);
        } else if(Greenfoot.isKeyDown(left)) {
            setImage(imageLeft);
            moveLeft(x,y);
        } else if(Greenfoot.isKeyDown(right)) {
            setImage(imageRight);
            moveRight(x,y);
        } else {
            setImage(imageFront);
        }
    }
    else if ((getWorld() instanceof PacmanWorld))
    {
        if(Greenfoot.isKeyDown(up)) {
            // setRotation(Direction.UP);
            //jump(x,y);
            moveUp(x,y);
        } else if(Greenfoot.isKeyDown(down)) {
            // setRotation(Direction.DOWN);
            // fall(x,y);
            moveDown(x,y);
        } else if(Greenfoot.isKeyDown(left)) {
            setImage(imageLeft);
            moveLeft(x,y);
        } else if(Greenfoot.isKeyDown(right)) {
            setImage(imageRight);
            moveRight(x,y);
        } else {
            setImage(imageFront);
        }
    }
    }
    
    /**
     * Checks if the Player is out of the boundaries of the world and if so the Game is Over
     */
    public void gameOver(Actor player) {
        if (player.getY() > getWorld().getHeight() + 100) {
            gameOverSound.setVolume(volume);
            gameOverSound.play();
            Greenfoot.setWorld(new GameOver());
            // Greenfoot.stop();
        }
    }
    
    // public void moveTopView(int x, int y, int rotation) {
        // int currentX = x;
        // int currentY = y;
        // int direction = rotation; // getRotation()
        // int changeX = getChangeX(direction);
        // int changeY = getChangeY(direction);
        // int adjustedChangeX = adjustOffset(changeX);
        // int adjustedChangeY = adjustOffset(changeY);
        
        // Actor block = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Block2x2.class);
        // // if the block is null then we can move
        // if(block==null) { 
           // setLocation(currentX + changeX, currentY + changeY);
        // }
    // }
    
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
    public void fall(int x,int y) {
        setLocation(x, y + VSPEED);
        VSPEED += acceleration;
    }
    
    /**
     * Simulates the jump of the Player
     */
    public void jump(int x,int y) {
        VSPEED = -jumpStrenght;
        fall(x,y);
    }
    
    /**
     *  Checks if the Player is falling
     */
    public void checkFall(Player player, int x,int y, int offset) {
        if(getWorld() instanceof  MarioStyleWorld){
        if(!onGround(player))
        {
            fall(x,y);
        } else if (onGround(player)) {
            VSPEED = 0;
        }
    }
    }
    
    
    // /**
     // *  Checks if the Player is falling
     // */
    // public void checkFall(Player player, int x,int y, int offset) {
        // if(!player.isTouching(Ground.class))
        // {
            // VSPEED++;
        // } else {
            // setLocation(x, y - offset);
            // // setLocation(x, y);
            // VSPEED = 0;
        // }
    // }
    
    public boolean onGround(Actor player) {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/3, Ground.class);
        return under != null;
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
    
    public void moveDown(int x, int y)
    {
        setLocation(x, y + SPEED);
    }
     public void moveUp(int x, int y)
    {
        setLocation(x, y - SPEED);
    }
    
    // /**
     // * Moves the Player into the X direction
     // */
    // public int getChangeX(int direction) {
        // if(direction == Direction.RIGHT) {
            // return SPEED;
        // } 
        // if(direction == Direction.LEFT) {
            // return -SPEED;
        // }
        // return 0;
    // }
    
    // /**
     // * Moves the Player into the Y direction
     // */
    // public int getChangeY(int direction) {
        // if(direction == Direction.DOWN) {
            // return SPEED;
        // } 
        // if(direction == Direction.UP) {
            // return -SPEED;
        // }
        // return 0;
    // }
    
    private int adjustOffset(int offset) {
        int signOfOffset = (int)Math.signum(offset); // casting the offset to be int instead of double
        int distanceToFront = length/2;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
    }
    
    /**
     * Collects the studs and adds points to the Scoreboard
     */
    public void collectStuds() {
        Actor studBlue = getOneIntersectingObject(StudBlue.class);
        Actor studPurple = getOneIntersectingObject(StudPurple.class);
        
        if(studBlue!= null) {
            coinSound.setVolume(volume);
            coinSound.play();
            mainWorld.addScore(20);
            mainWorld.removeObject(studBlue);
        } else if (studPurple!= null) {
            coinSound.setVolume(volume);
            coinSound.play();
            mainWorld.addScore(100);
            mainWorld.removeObject(studPurple);
        }
    }
    
    /**
     * Collects the studs and adds points to the Scoreboard
     */
    public void collectHearts() {
        Actor heart = getOneIntersectingObject(Heart.class);
        
        if(heart!= null) {
            oneUpSound.setVolume(oneUpVolume);
            oneUpSound.play();
            // mainWorld.addLive();
            mainWorld.removeObject(heart);
        }
    }
}
