import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LegoLoader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LegoLoader extends Actor
{
    MainWorld mainWorld;

    private GifImage loader = new GifImage("lego-loading.gif");
    private GreenfootImage loaderImage = new GreenfootImage(loader.getCurrentImage());

    /**
     * Constructor of LegoLoader Class
     * Contrutor da Classe LegoLoader
     */
    public LegoLoader() {
        setImage(loaderImage);
    }

    /**
     * Sets the current image of the Gif
     * Define a imagem atual do gif
     */
    private void runLoading() {
        setImage(loader.getCurrentImage());
    }

    /**
     * Act - do whatever the LegoLoader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        runLoading();
    }
}
