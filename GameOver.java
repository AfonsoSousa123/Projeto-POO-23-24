import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends MainWorld
{
    Scoreboard sb;
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver() {    
        prepare();
        playGameOverSound();
        sb.resetVariables();
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
