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
    int livesCounter = 3;
    GreenfootImage boardImage;
    GreenfootImage heart = new GreenfootImage("heart.png");

    public void addedToWorld(World w) {
        myWorld = (MarioStyleWorld)w;
        width = myWorld.getWidth();
        boardImage = new GreenfootImage(width, height);
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        setImage(boardImage);
    }
    
    public void addScore(int amount) { // increments the score with the given amount
        score += amount;
    }
    
    public void drawScore() {
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setColor(Color.WHITE);
        boardImage.setFont(new Font("Arial", 24));
        boardImage.drawString("Score: "+ score, 20, 40);
        
        // for(int i=0; i < livesCounter; i++) {
            // heart;
        // }
    }
    
    public void act()
    {
        drawScore();
    }
    
    private void lives(int x, int y) {
        heart.drawImage(heart, x, y);
    }
}
