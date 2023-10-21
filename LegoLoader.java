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
    private int percent = 70;
    
    GifImage loader = new GifImage("lego-progress.gif");
    GreenfootImage loaderImage = new GreenfootImage(redimencionaImg(loader.getCurrentImage(), percent));
    
    public LegoLoader() {
        redimencionaGif(loader, percent);
        redimencionaGif(loader, 70);
        setImage(loaderImage);
    }
    
    /**
     * Act - do whatever the LegoLoader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(loader.getCurrentImage());
    }
    
    /**
     * Resizes the given Image to a width and height times the percent specified 
     * Redimensiona a Image dada para um comprimento e uma altura de acordo com a percentagem fornecida
     */
    public GreenfootImage redimencionaImg(GreenfootImage image, int percent) {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        return image;
    }

    /**
     * Resizes the given Gif to a width and height times the percent specified 
     * Redimensiona o Gif dado para um comprimento e uma altura de acordo com a percentagem fornecida
     */
    public GifImage redimencionaGif(GifImage gif, int percent) {
        for (GreenfootImage image : gif.getImages())
        {
            int wide = image.getWidth()*percent/100;
            int high = image.getHeight()*percent/100;
            image.scale(wide, high);
        }
        return gif;
    }
}
