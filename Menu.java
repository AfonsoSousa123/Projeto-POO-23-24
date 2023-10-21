import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ecra_inicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends MainWorld
{
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu() {    
        populateWorld();
        playStartGameSound();
    }
    
    private void populateWorld() {
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
}
