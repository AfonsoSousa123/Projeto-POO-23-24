import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    private Scoreboard score;
    private MainWorld mainWorld;
    
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        teletransport();
    }
    
    public void teletransport() {
        if (checkPlayer1() && checkPlayer2() && (score.starCount >= 6)) { // checks if both Players are in the portal and have greater or equal to 6 Stars
            Greenfoot.setWorld(new BarbieLand()); 
        } else if (checkPlayer1() && checkPlayer2() && (score.starCount <= 6) ) { // checks if both Players are in the portal and have less or equal to 6 Stars
            Greenfoot.setWorld(new MarioStyleWorld());
        }
    }
    
    public boolean checkPlayer1() { // checks if Player1 is in contact with the Portal
        Actor ken = getOneIntersectingObject(Ken.class);
        
        if(ken != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkPlayer2() { // checks if Player2 is in contact with the Portal
        Actor barbie = getOneIntersectingObject(Barbie.class);
        
        if(barbie != null) {
            return true;
        } else {
            return false;
        }
    }
}
