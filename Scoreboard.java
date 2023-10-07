import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    MainWorld myWorld;
    int width;
    int height = 60;
    int score = 0;
    int livesCounter = 3;
    GreenfootImage boardImage;
    GreenfootImage heart = new GreenfootImage("heart.png");

    public void addedToWorld(World w) {
        myWorld = (MainWorld)w;
        width = myWorld.getWidth();
        boardImage = new GreenfootImage(width, height);
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setTransparency(100);
        
        setImage(boardImage);
    }
    
    public void act() {
        drawScore();
    }
    
    /**
     * Increments the score with the given amount
     */
    public void addScore(int amount) {
        score += amount;
    }
    
    public void drawScore() {
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setColor(Color.WHITE);
        boardImage.setFont(new Font("Arial", 24));
        boardImage.drawString("Score: "+ score, 20, 40);
        boardImage.drawImage(heart, 1200, 60);
    }

    private void lives(int x, int y) {
        
    }
}
