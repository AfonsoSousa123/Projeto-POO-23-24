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
    
    private int volume = 20; // volume geral dos .mp3
    private int oneUpVolume = 70; // volume dos .wav
    
    // Initializes the sounds | Inicializa os sons
    public GreenfootSound fallingSound = new GreenfootSound("Falling-object.mp3");
    public GreenfootSound coinSound = new GreenfootSound("8bit-coin-sound-effect.mp3");
    public GreenfootSound oneUpSound = new GreenfootSound("1-up.wav");
    public GreenfootSound healthSound = new GreenfootSound("health_up.wav");
    public GreenfootSound exitLevelSound = new GreenfootSound("exit_course.wav");
    
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
     * Metodo act
     */
    public void act()
    {
        
    }
    
    /**
     * Returns the Score
     * Retorna o Score
     */
    public int getScore() {
        return sb.getScore();
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
     * Counts the stars
     * Conta as estrelas
     */
    public void countStars(int amount) {
        sb.countStars(amount);
    }
    
    /**
     * Counts the stars
     * Conta as estrelas
     */
    public void checkStarCount() {
        if (sb.starCount == 2) {
            Greenfoot.setWorld(new PacmanWorld()); // Sends the Players to a new world | Manda os Players para um novo world
        }else if (sb.starCount == 4) {
            Greenfoot.setWorld(new RaceWorld()); // Sends the Players to a new world | Manda os Players para um novo world
        } else if (sb.starCount == 6) {
            Greenfoot.setWorld(new BarbieLand());  // Sends the Players to a new world | Manda os Players para um novo world
        }
    }
    
    // BEGIN Sounds --------------------------------------------------------------------
    
    /**
     * Plays the OneUpSound
     * Toca o OneUpSound
     */
    public void playOneUpSound() {
        oneUpSound.setVolume(oneUpVolume); // Sets the volume of the oneUpSound
        oneUpSound.play(); // Plays the oneUpSound
    }
    
    /**
     * Plays the CoinSound
     * Toca o CoinSound
     */
    public void playCoinSound() {
        coinSound.setVolume(volume); // Sets the volume of the coinSound
        coinSound.play(); // Plays the coinSound
    }
    
    /**
     * Plays the HealthSound
     * Toca o HealthSound
     */
    public void playHealthSound() {
        healthSound.setVolume(oneUpVolume); // Sets the volume of the healthSound
        healthSound.play(); // Plays the healthSound
    }
    
    /**
     * Plays the ExitLevelSound
     * Toca o ExitLevelSound
     */
    public void playExitLevelSound() {
        exitLevelSound.setVolume(volume); // Sets the volume of the ExitLevelSound
        exitLevelSound.play(); // Plays the ExitLevelSound
    }
    
    /**
     * Plays the FallingSound
     * Toca o FallingSound
     */
    public void playFallingSound() {
        fallingSound.setVolume(volume); // Sets the volume of the fallingSound
        fallingSound.play(); // Plays the fallingSound
    }
    
    // END Sounds -------------------------------------------------------
    
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
