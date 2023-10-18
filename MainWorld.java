import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    Scoreboard sb; // space variable
    
    /**
     * Constructor for objects of class MainWorld.
     * Contrutor para os objetos da classe MainWorld.
     * 
     */
    public MainWorld()
    {    
        // Create a new world with 1300x800 cells with a cell size of 1x1 pixels. | Cria um novo mundo com 1300x800 células, com um tamanho de célula de 1x1 pixeis
        super(1300, 800, 1, false); // The boolean atribute, is to set the world with bounds | O atributo boolean, define se o mundo tem ou não bordas
        sb = new Scoreboard(); // Initializes the Scoreboard object | Inicializa o objeto Scoreboard
        if (getClass() != Menu.class) // all worlds but not the Menu
            addObject(sb, getWidth()/2, 30); // Adds the Scoreboard onto the Worlds
    }
    
    /**
     * Act method
     * 
     */
    public void act()
    {
        
    }
    
    /**
     * Adds the given amount to the score
     * Adiciona o amount ao score
     */
    public void addScore(int amount) { 
        sb.addScore(amount);
    }
    
    /**
     * Adds Barbie lives
     * Adiciona as vidas da Barbie
     */
    public void addBarbieLives(int amount) { 
        sb.addBarbieLives(amount);
    }
    
    /**
     * Adds Ken lives
     * Adiciona as vidas do Ken
     */
    public void addKenLives(int amount) { 
        sb.addKenLives(amount);
    }
    
    /**
     * Removes the lives of Barbie
     * Remove as vidas da Barbie
     */
    public void removeBarbieLives(int amount) { 
        sb.removeBarbieLives(amount);
    }
    
    /**
     * Removes the lives of Ken
     * Remove as vidas do Ken
     */
    public void removeKenLives(int amount) { 
        sb.removeKenLives(amount);
    }
    
    /**
     * Resizes the given image to the width and height specified
     * Redimensiona a imagem dada para um comprimento e uma altura fornecidos
     */
    public GreenfootImage resizeImage(GreenfootImage imageBackground, int width, int height) {
        imageBackground.scale(width, height);
        setBackground(imageBackground);
        return imageBackground;
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
