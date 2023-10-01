import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botao extends Actor
{
    /**
     * Act - do whatever the Botao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Botao()
    {
        GreenfootImage image = getImage();
        int width = image.getWidth();
        int height = image.getHeight();
        image.scale(width/2, height/2);   
    }
    
    public void act()
    {
        play();
    }
    
    private void play()
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(new PlanetaTerra());
        }
    }
}
