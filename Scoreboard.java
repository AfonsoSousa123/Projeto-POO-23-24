import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    MarioStyleWorld myWorld;
    int width;
    int height = 60;
    int score = 0;
    GreenfootImage boardImage;
    
    public void addedToWorld(World w) {
        myWorld = (MarioStyleWorld)w;
        width = myWorld.getWidth();
        boardImage = new GreenfootImage(width, height);
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        setImage(boardImage);
    }
    
    public void addScore(int amount) {
        score += amount;
    }
    
    public void drawScore() {
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setColor(Color.WHITE);
        boardImage.setFont(new Font("Arial", 24));
        boardImage.drawString("Score: "+ score, 20, 40);
    }
    
    public void act()
    {
        drawScore();
    }
    
    public void lives() {
        
    }
}
