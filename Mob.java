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
    private int imageSize = 30;
    private int timer = 0;

    private int width = getImage().getWidth(); 
    private int height = getImage().getHeight();
    private int lookForWalls = width/3;
    private int lookForEdge = width/5; 
    private int lookForGround = height/2;

    // class Direction { // Class to store the values of the rotation for each movement
    // public static final int UP = 270;
    // public static final int DOWN = 90;
    // public static final int LEFT = 180;
    // public static final int RIGHT = 0;
    // }

    // World variables | Variaveis World
    MainWorld mainWorld;

    public Mob() {

    }

    public void addedToWorld(World w) {
        mainWorld = (MainWorld)w;
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

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
        if(getWorld() instanceof MarioStyleWorld) {
            moveMobMW(imageLeft, imageRight, x, y);
        } else if (getWorld() instanceof PacmanWorld) {
            moveMobPW(imageLeft, imageRight, x, y);
        }
    }

    /**
     * Moves the Mob to the right and the left in the MarioStyleWorld
     * 
     */
    private void moveMobMW(GifImage imageLeft, GifImage imageRight, int x, int y) {
        if(onGround(this)) {
            // Check if the Mob is colliding with any walls or cliffs.
            Actor wall = getOneObjectAtOffset(lookForWalls, 0, Ground.class);
            Actor cliff = getOneObjectAtOffset(lookForEdge, lookForGround, Ground.class);

            // If the Mob is colliding with a wall or cliff, reverse its direction
            if (wall != null || cliff != null) {
                SPEED *= -1;
                lookForWalls *= -1;
                lookForEdge *= -1;
            }

            // Check if the Mob is turning left or right
            if (SPEED < 0) {
            // Turning right.
            setImage(imageRight.getCurrentImage());
            } else if (SPEED > 0) {
            // Turning left.
            setImage(imageLeft.getCurrentImage());
            }

            // Move the Mob according to its speed
            setLocation(x + SPEED, y);
        }
    }
    
    public void checkEdges(Mob enemy, int x,int y) {
        if(getWorld() instanceof  MarioStyleWorld){
            if(!onGround(enemy) && SPEED == SPEED){
                setLocation(x + SPEED , y);
            }
            if(!onGround(enemy) && SPEED == -SPEED){
                setLocation(x - SPEED , y);
            }
        }
    }

    /**
     * Simulates the gravity of the Mob
     */
    public void fall(int x,int y) {
        if(getWorld() instanceof  MarioStyleWorld) {
            setLocation(x, y + VSPEED);
            VSPEED += acceleration;
        }
    }

    /**
     *  Checks if the Mob is falling
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

    /**
     * PacmanWorld code begin
     */

    /**
     * Moves the Mob to the right and the left in the PacmanWorld
     * Move o Mob para a direita e a esquerda
     */
    private void moveMobPW(GifImage imageLeft, GifImage imageRight, int x, int y) {
        if (SPEED < 0) { // Check which direction the Mob is moving in.
            setImage(imageRight.getCurrentImage()); // Set the Mob's image to the right-facing image.
        } else {
            setImage(imageLeft.getCurrentImage()); // Set the Mob's image to the left-facing image.
        }

        setLocation(x + SPEED, y); // Move the Mob.

        if (isAtEdge()) { // Check if the Mob has reached the edge of the world.
            setImage(imageLeft.getCurrentImage()); // Reset the Mob's image.
            SPEED *= -1; // Reverse the Mob's direction.
        }
        if (!canMoveLeft() || !canMoveRight()) { // Check if the Mob has reached the edge of the world.
            setImage(imageLeft.getCurrentImage()); // Reset the Mob's image.
            SPEED *= -1; // Reverse the Mob's direction.
        }
    }
    
    /**
     * Checks if the Mob can move left
     * Verifica se o jogador consegue se mover para a esquerda
     */
    public boolean canMoveLeft() {
        boolean canMoveLeft = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/-2-4, imageHeight/-2, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/-2-4, imageHeight/2-1, Block2x2.class) != null) {
            canMoveLeft = false;
        }

        return canMoveLeft;
    }

    /**
     * Checks if the Mob can move right
     * Verifica se o jogador consegue se mover para a direita
     */
    public boolean canMoveRight() {
        boolean canMoveLeft = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/2+4, imageHeight/-2, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/2+4, imageHeight/2-1, Block2x2.class) != null) {
            canMoveLeft = false;
        }

        return canMoveLeft;
    }

    /**
     * Checks if the Mob can move up
     * Verifica se o jogador consegue se mover para cima
     */
    public boolean canMoveUp() {
        boolean canMoveUp = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/-2, imageHeight/-2-4, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/2-1, imageHeight/-2-4, Block2x2.class) != null) {
            canMoveUp = false;
        }

        return canMoveUp;
    }

    /**
     * Checks if the Mob can move down
     * Verifica se o jogador consegue se mover para baixo
     */
    public boolean canMoveDown() {
        boolean canMoveDown = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/-2, imageHeight/2+4, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/2-1, imageHeight/2+4, Block2x2.class) != null) {
            canMoveDown = false;
        }

        return canMoveDown;
    }

    /**
     * PacmanWorld code end
     */

    public GreenfootImage redimencionaImg(GreenfootImage image, int percent) {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        return image;
    }

    public GifImage redimencionaGif(GifImage gif, int percent) {
        for (GreenfootImage image : gif.getImages()) {
            int wide = image.getWidth()*percent/100;
            int high = image.getHeight()*percent/100;
            image.scale(wide, high);
        }
        return gif;
    }

    /**
     * Checks if the Mob is touching the right wall
     */
    public boolean checkRightWall(Actor Mob) { // verifica se está em contacto com a parede da direita
        int spriteWidth = getImage().getWidth();
        int xDistance = spriteWidth/2;

        Actor rWall = getOneObjectAtOffset(xDistance, 0, Block2x2.class);

        if(rWall == null) {
            return false;
        } else {
            StopByTherWall(rWall);
            return true;
        }
    }

    /**
     *  Mob stops when reaches a wall on the right
     */
    public void StopByTherWall(Actor rWall) { // para quando está em contacto na parede da esquerda
        int wallWidth = rWall.getImage().getWidth();
        int newX = rWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX, getY());
    }

    /**
     *  Checks if the Mob is thoucing the left wall
     */
    public boolean checkLeftWall(Actor Mob) { // verifica se está em contacto com a parede da esquerda
        int spriteWidth = getImage().getWidth();
        int xDistance = spriteWidth/-3;

        Actor lWall = getOneObjectAtOffset(xDistance, 0, Block2x2.class);

        if(lWall != null) {
            StopByTheLWall(lWall);
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Mob stops when it reaches a wall on the left
     */
    public void StopByTheLWall(Actor lWall) { // para quando está em contacto na parede da esquerda
        int wallWidth = lWall.getImage().getWidth();
        int newX = lWall.getX() + (wallWidth + getImage().getHeight())/3;
        setLocation(newX, getY());
    }
}
