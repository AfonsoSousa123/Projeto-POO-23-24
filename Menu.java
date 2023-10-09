import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ecra_inicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends MainWorld
{
    GreenfootSound startSound = new GreenfootSound("press_start.wav");
    
    /**
     * Constructor for objects of class Ecra_inicial.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // super(1300, 800, 1);
        populateWorld();
        
    }
    
    private void populateWorld()
    {
        Titulo titulo = new Titulo();
        addObject(titulo, 349, 193);
        
        Desenho desenho = new Desenho();
        addObject(desenho, 226, 568);
        
        Botao botao = new Botao();
        addObject(botao, 556, 452);
    }
    
    public void act() {
        // pressStartSound();
    }
    
    private void pressStartSound() {
        startSound.setVolume(70);
        startSound.play();
    }
}
