import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barbie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barbie extends Player
{
    private int ImageSize; // tamanho da imagem
    
    GreenfootImage barbieF = new GreenfootImage("Barbie_front.png");
    
    GifImage bwalkingR = new GifImage("barbie_walking_right.gif");
    GifImage bwalkingL = new GifImage("barbie_walking_left.gif");
    
    public class BarbieKeys { // Class to store the values of the Keys for Barbie
        public static final String UP = "W";
        public static final String DOWN = "S";
        public static final String LEFT = "A";
        public static final String RIGHT = "D";
    }
    
    /**
     * Constructor for the Barbie Class.
     * Construtor para a Classe da Barbie.
     */
    public Barbie() {
        ImageSize = 30;
        redimencionaGif(bwalkingL, ImageSize); // redimensiona a imagem da Barbie
        redimencionaGif(bwalkingR, ImageSize); // redimensiona a imagem da Barbie
        setImage(redimencionaImg(barbieF, ImageSize)); // define a imagem da Barbie
    }
    
    /**
     * Overloaded Constructor for the Barbie Class.
     * Overloaded Construtor para a Classe da Barbie.
     */
    public Barbie(int imageSize) {
        this.ImageSize = imageSize;
        redimencionaGif(bwalkingL, imageSize);
        redimencionaGif(bwalkingR, imageSize);
        setImage(redimencionaImg(barbieF, imageSize));
    }
    
    public void act() {
        movePlayer(
            BarbieKeys.UP, 
            BarbieKeys.DOWN, 
            BarbieKeys.LEFT, 
            BarbieKeys.RIGHT, 
            getX(), 
            getY(), 
            bwalkingL, 
            bwalkingR,
            barbieF
        );
        checkBounds(this);
        checkFall(this, getX(), getY());
        onGround(this);
        platformAbove(this);
        collectStuds(this);
        collectHearts(this);
        collectStars(this);
        touchEnemy(this);
        teleportPlayer(this);
    }
}
