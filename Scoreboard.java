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
    private static final int LIVES = 2;
    private int width;
    private int height = 60;
    public int score = 0;
    public int starCount = 0;
    public int barbieLives = LIVES;
    public int kenLives = LIVES;

    GreenfootImage boardImage;
    // GreenfootImage heart = new GreenfootImage("heart.png");

    public Scoreboard() {
        
    }
    
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
     * Draws the score onto the 
     */
    public void drawScore() {
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setColor(Color.WHITE);
        boardImage.setFont(new Font("Arial", 30));
        boardImage.drawString("Score: "+ score, 20, 40);
        boardImage.drawString("Lives: ", 965, 40);
        boardImage.drawString("Barbie: "+ barbieLives, 1065, 40);
        boardImage.drawString("Ken: "+ kenLives, 1200, 40);
    }
    
    /**
     * Increments the score with the given amount
     */
    public void addScore(int amount) {
        score += amount;
    }

    public void addBarbieLives(int amount) {
        if(barbieLives > 0) {
            barbieLives += amount; // increments the lives to the barbieLives
        }
    }
    
    public void removeBarbieLives(int amount) {
        if(barbieLives > 0) {
            barbieLives -= amount; // decrements the lives to the barbieLives
        } else if(barbieLives == 0) {
            reset();
        }
    }
    
    public void addKenLives(int amount) {
        if(kenLives > 0) {
            kenLives += amount; // increments the lives to the kenLives
        }
    }
    
    public void removeKenLives(int amount) {
        if(kenLives > 0) {
            kenLives -= amount; // decrements the lives to the kenLives
        } else if(kenLives == 0) {
            reset();
        }
    }
    
    /**
     * Counts the stars
     * Conta as estrelas
     */
    public void countStars(int amount) {
        starCount += amount;
    }
    
    public void reset() {
        Greenfoot.setWorld(new GameOver()); // sends the Player to the GameOver World
        barbieLives = LIVES; // resets the counter to its original value
        kenLives = LIVES; // resets the counter to its original value
    }
}
