import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        teletranport();
    }
    
    public void teletranport() {
        if (checkPlayer1() && checkPlayer2()) {
            Greenfoot.setWorld(new BarbieLand());
        }
    }
    
    public boolean checkPlayer1() {
        Actor ken = getOneIntersectingObject(Ken.class);
        
        if(ken != null) {
            return true;
        }
        else {
        return false;
        }
    }
    public boolean checkPlayer2() {
        Actor barbie = getOneIntersectingObject(Barbie.class);
        
        if(barbie != null) {
            return true;
        }
        else {
        return false;
        }
    }
}
