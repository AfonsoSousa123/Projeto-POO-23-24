import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends Scoreboard
{
     // variavel para o comprimento 
    private int height; // variavel para a altura 
    
    private GreenfootImage star = new GreenfootImage("estrela.png"); // Imagem para a estrela
    private GreenfootImage lives = new GreenfootImage("heart.png"); // Imagem para o heart

    /**
     * Act - do whatever the ScoreScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        resize ();
        drawScore(); // Chama o método drawScore();
    }
    
    private void resize () // resize das imagens da estrela e das vidas
    {
        star.scale(130, 160);
        lives.scale(80, 100);
    }
    
    @Override
    public void addedToWorld(World w) {
        mainWorld = (PlanetaTerra)w;
        width = mainWorld.getWidth()/2;
        height = mainWorld.getHeight()/2;
        boardImage = new GreenfootImage(width, height);
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setTransparency(200);
        setImage(boardImage);
    }
    
    @Override
    public void drawScore() {
        boardImage.setColor(Color.WHITE);
        boardImage.setFont(new Font("Arial", 30));
        boardImage.drawString("\nScore: "+ score, 10, 30);
        boardImage.drawImage(star, 0, 50);
        boardImage.drawString(": "+ starCount, 130, 140);
        boardImage.drawImage(lives, 25, 150);
        boardImage.drawString(": " + (barbieLives + kenLives), 130, 230);
    }
}
