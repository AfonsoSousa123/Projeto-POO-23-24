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
    
    @Override
    public void addedToWorld(World w) {
        terra = (PlanetaTerra)w;
        width = terra.getWidth()/2;
        height = terra.getHeight()/2;
        screen = new GreenfootImage(width, height);
        screen.setColor(Color.BLACK);
        screen.fillRect(0,0,width,height);
        screen.setTransparency(200);
        setImage(screen);
    }
    
    @Override
    public void drawScore() {
        star.scale(130, 160);
        lives.scale(80, 100);
        screen.setColor(Color.WHITE);
        screen.setFont(new Font("Arial", 30));
        screen.drawString("\nScore: "+ score, 10, 30);
        screen.drawImage(star, 0, 50);
        screen.drawString(": "+ starCount, 130, 140);
        screen.drawImage(lives, 25, 150);
        screen.drawString(": " + (barbieLives + kenLives), 130, 230);
    }
}
