import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    private int SPEED = 8;
    
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void moveObstacle() {
        if (getWorld() instanceof  MarioStyleWorld) {
            if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")) {
                move(SPEED);
            } else if(Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right")) {
                move(-SPEED);
            }
        }
    }
}
