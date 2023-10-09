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
    private int jumpStrenght = 50;
    private int length;
    private int volume = 20;
    private int oneUpVolume = 70;
    private int imageSize = 30;

    // Initializes the sounds
    GreenfootSound fallingSound = new GreenfootSound("Falling-object.mp3");
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
        GifImage imageLeft,
        GifImage imageRight,
        GreenfootImage imageFront
    ) {
        if(getWorld() instanceof  MarioStyleWorld) {
            if(Greenfoot.isKeyDown(up) && onGround(this)) {
                // setRotation(Direction.UP);
                jump(x,y);
            } else if(Greenfoot.isKeyDown(down)) {
                // setRotation(Direction.DOWN);
                //fall(x,y);
            } else if(Greenfoot.isKeyDown(left)) {
                setImage(imageLeft.getCurrentImage());
                moveLeft(x,y);
            } else if(Greenfoot.isKeyDown(right)) {
                setImage(imageRight.getCurrentImage());
                moveRight(x,y);
            } else {
                setImage(imageFront);
            }
        }
        else if (getWorld() instanceof PacmanWorld) {
            if(Greenfoot.isKeyDown(up)) {
                // setRotation(Direction.UP);
                //jump(x,y);
                moveUp(x,y);
            } else if(Greenfoot.isKeyDown(down)) {
                // setRotation(Direction.DOWN);
                // fall(x,y);
                moveDown(x,y);
            } else if(Greenfoot.isKeyDown(left)) {
                setImage(imageLeft.getCurrentImage());
                moveLeft(x,y);
            } else if(Greenfoot.isKeyDown(right)) {
                setImage(imageRight.getCurrentImage());
                moveRight(x,y);
            } else {
                setImage(imageFront);
            }
        }
    }
    
    /**
     * Checks if the Player is out of the boundaries of the world and if so removes one live
     */
    public void checkBounds(Actor player) {
        if (player.getY() > getWorld().getHeight() + 120) {
            fallingSound.setVolume(volume);
            fallingSound.play();
            
            if (player.getClass() == Barbie.class) {
                mainWorld.removeBarbieLives(1);
                player.setLocation(300,300);
            } else if (player.getClass() == Ken.class) {
                mainWorld.removeKenLives(1);
                player.setLocation(300,300);
            }
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
    
    public GreenfootImage redimencionaImg(GreenfootImage image, int percent)
    {
    int wide = image.getWidth()*percent/100;
    int high = image.getHeight()*percent/100;
    image.scale(wide, high);
    return image;
    }
    
    
    public GifImage redimencionaGif(GifImage gif, int percent)
    {
        for (GreenfootImage image : gif.getImages())
        {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        }
        return gif;
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
            if(!onGround(player)) {
                fall(x,y);
            } else if (onGround(player)) {
                VSPEED = 0;
            }
        }
    }
    
    /**
     *  Checks if the Player is falling
     */    
    public boolean onGround(Actor player) {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/3, Ground.class);
        return ground != null;
    }
    
    /**
     * Checks if the Player is touching the above platform
     */
    public boolean platformAbove(Actor player) {
        int spriteHeight = getImage().getHeight();
        int yDistance = spriteHeight/-4;
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Ground.class);
        
        if(ceiling != null) {
            VSPEED = 0;
            bopHead(ceiling);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     *  Adds an offset to the height of the Player
     */
    public void bopHead(Actor ceiling) {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/3;
        setLocation(getX(), newY);
    }
    
    /**
     * Checks if the player is touching the right wall
     */
    public boolean checkRightWall(Actor player)
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
     *  Player stops when reaches a wall on the right
     */
    public void StopByTherWall(Actor rWall) {
        int wallWidth = rWall.getImage().getWidth();
        int newX = rWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX, getY());
    }
    
    /**
     *  Checks if the player is thoucing the left wall
     */
    public boolean checkLeftWall(Actor player)
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
     *  Player stops when reaches a wall on the left
     */
    public void StopByTheLWall(Actor lWall) {
        int wallWidth = lWall.getImage().getWidth();
        int newX = lWall.getX() + (wallWidth + getImage().getHeight())/3;
        setLocation(newX, getY());
    }
    
    public boolean cubeAbove(Actor player) {
        int spriteHeight = getImage().getHeight();
        int yDistance = spriteHeight/-3;
        Actor upCube = getOneObjectAtOffset(0, yDistance, Block2x2.class);
        
        if(upCube != null) {
            bateUpCube(upCube);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     *  Adds an offset to the height of the Player
     */
    public void bateUpCube(Actor upCube) {
        int upCubeHeight = upCube.getImage().getHeight();
        int newY = upCube.getY() + (upCubeHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }
    
    public boolean cubeUnder(Actor player) {
        int spriteHeight = getImage().getHeight();
        int yDistance = spriteHeight/3;
        Actor downCube = getOneObjectAtOffset(0, yDistance, Block2x2.class);
        
        if(downCube == null) {
            return true;
        } else {
            bateUpCube(downCube);
            return true;
        }
    }
    
    /**
     *  Adds an offset to the height of the Player
     */
    public void bateDownCube(Actor downCube) {
        int downCubeHeight = downCube.getImage().getHeight();
        int newY = downCube.getY() - (downCubeHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }
    
    /**
     * Moves the Player to the right
     */
    public void moveRight(int x,int y) {
        setLocation( x + SPEED, y);
    }
    
    /**
     * Moves the Player to the left
     */
    public void moveLeft(int x,int y) {
        setLocation( x - SPEED, y);
    }
    
    /**
     * Moves the Player Down
     */
    public void moveDown(int x, int y) {
        setLocation(x, y + SPEED);
    }
    
    /**
     * Moves the Player Up
     */
     public void moveUp(int x, int y) {
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
    public void collectStuds(Actor player) {
        Actor studBlue = getOneIntersectingObject(StudBlue.class);
        Actor studPurple = getOneIntersectingObject(StudPurple.class);
        
        if(studBlue != null&& player.getClass() == Ken.class) {
            coinSound.setVolume(volume); // Sets the volume of the coinSound
            coinSound.play(); // Plays the coinSound
            mainWorld.addScore(20); // Adds 20 score to the main score
            mainWorld.removeObject(studBlue); // Removes the studBlue object
        } else if (studPurple != null && player.getClass() == Barbie.class) {
            coinSound.setVolume(volume); 
            coinSound.play();
            mainWorld.addScore(100); // Adds 100 score to the main score
            mainWorld.removeObject(studPurple); // Removes the studPurple object
        }
    }
    
    /**
     * Collects the studs and adds points to the Scoreboard
     */
    public void collectHearts(Actor player) {
        Actor heart = getOneIntersectingObject(Heart.class);
        
        if(heart!= null) {
            oneUpSound.setVolume(oneUpVolume); // Sets the volume of the oneUpSound
            oneUpSound.play(); // Plays the oneUpSound
            
            if (player.getClass() == Barbie.class) {
                mainWorld.addBarbieLives(1); // Adds one live to the livesCounter
            } else if (player.getClass() == Ken.class) {
                mainWorld.addKenLives(1);
            }
            mainWorld.removeObject(heart); // Removes the heart object
        }
    }
}
