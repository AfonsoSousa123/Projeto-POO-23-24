import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends Scoreboard
{
    PlanetaTerra terra;
    
    private int width;
    private int height;
    
    GreenfootImage star = new GreenfootImage("estrela.png");
    GreenfootImage lives = new GreenfootImage("heart.png");
    
    GreenfootImage screen;
    /**
     * Act - do whatever the ScoreScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        drawScore();
    }
    
    public void addedToWorld(World w) {
        terra = (PlanetaTerra)w;
        width = terra.getWidth()/2;
        height = terra.getHeight()/2;
        screen = new GreenfootImage(width, height);
        screen.setColor(Color.BLACK);
        screen.fillRect(0,0,width,height);
        screen.setTransparency(150);
        setImage(screen);
    }
    
    public void drawScore() {
        screen.setColor(Color.WHITE);
        screen.setFont(new Font("Arial", 30));
        screen.drawString("\nScore: "+ score, 10, 30);
        screen.drawString("\nStars: "+ starCount, 10, 80);
        screen.drawString("\nLives: ", 10, 130);
    }
}
