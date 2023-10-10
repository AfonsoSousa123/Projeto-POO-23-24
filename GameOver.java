import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends MainWorld
{
    GreenfootSound gameOverSound = new GreenfootSound("game_over.wav");
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // super(1300, 800, 1); 
        prepare();
        playGameOverSound();
    }
    
    private void playGameOverSound() {
        gameOverSound.setVolume(70);
        gameOverSound.play();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Botao botao = new Botao();
        addObject(botao,642,668);
    }
}
