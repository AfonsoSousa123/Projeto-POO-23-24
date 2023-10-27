import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    private Scoreboard sb; // Scoreboard variable
    private Portal portal; // Portal variable
    private Player player; // Player variable

    private int volume = 10; // volume geral dos .mp3
    private int volumeWav = 70; // volume geral dos .wav

    // Initializes the sounds | Inicializa os sons
    private GreenfootSound fallingSound = new GreenfootSound("Falling-object.mp3");
    private GreenfootSound coinSound = new GreenfootSound("coin.wav");
    private GreenfootSound deathSound = new GreenfootSound("Pacman-death-sound.mp3");
    private GreenfootSound victorySound =  new GreenfootSound("Retro-winning-sound-effect.mp3");
    private GreenfootSound explosionSound =  new GreenfootSound("Cartoon-explosion.mp3");
    private GreenfootSound oneUpSound = new GreenfootSound("1-up.wav");
    private GreenfootSound healthSound = new GreenfootSound("super_mushroom.wav");
    private GreenfootSound exitLevelSound = new GreenfootSound("exit_course.wav");
    private GreenfootSound gameOverSound = new GreenfootSound("smb_gameover.wav");
    private GreenfootSound startGameSound = new GreenfootSound("press_start.wav");
    private GreenfootSound jumpSound = new GreenfootSound("jump-super.wav");
    
    /**
     * Constructor for objects of class MainWorld.
     * Contrutor para os objetos da classe MainWorld.
     * 
     */
    public MainWorld() {    
        // Create a new world with 1300x800 cells with a cell size of 1x1 pixels. | Cria um novo mundo com 1300x800 células, com um tamanho de célula de 1x1 pixeis
        super(1300, 800, 1, false); // The boolean atribute, is to set the world with bounds | O atributo boolean, define se o mundo tem ou não bordas
        spawnScore(); // Imprime o Score
    }

    /**
     * Spawns the Scoreboard Object onto the World
     * Imprime o Objeto do Scoreboard no World
     */
    private void spawnScore() {
        sb = new Scoreboard(); // Initializes the Scoreboard object | Inicializa o objeto Scoreboard
        if (getClass() != Menu.class && getClass() != PlanetaTerra.class &&
        getClass() != BarbieLand.class) // all worlds but not the Menu
            addObject(sb, getWidth()/2, 30); // Adds the Scoreboard onto the Worlds
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
     * Adds the stars
     * Adiciona as estrelas
     */
    public void addStars(int amount) {
        sb.addStars(amount);
    }

    /**
     * Counts the stars
     * Conta as estrelas
     */
    public void checkStarCount() {
        if (sb.starCount == 2 && sb.level == 1 && getClass() == MarioStyleWorld.class) {
            sb.level++; // Increments one level | Incrementa um nivel
            loadingScreen(); // Teleports the player to LoadingScreen | Teleporta o player para o LoadingScreen
        } else if (sb.starCount == 4 && sb.level == 2 && getClass() == PacmanWorld.class) {
            sb.level++; // Increments one level | Incrementa um nivel
            loadingScreen(); 
        } else if (sb.starCount == 6 && sb.level == 3 && getClass() == RaceWorld.class) {
            sb.level++; // Increments one level | Incrementa um nivel
            loadingScreen();
        } else if (getClass() == PlanetaTerra.class) {
            sb.level++; // Increments one level | Incrementa um nivel
            loadingScreen();
        }
    }

    // Loading Screen | Ecra de carregamento
    public void loadingScreen() {
        Greenfoot.setWorld(new LoadingScreen()); 
    }

    // Sends the Players to the GameOver World | Manda os Players para o GameOver World
    public void gameOver() {
        Greenfoot.setWorld(new GameOver());  
    }

    // Sends the Players to a new world | Manda os Players para um novo world
    public void levelOne() {
        Greenfoot.setWorld(new MarioStyleWorld()); 
    }

    // Sends the Players to a new world | Manda os Players para um novo world
    public void levelTwo() {
        Greenfoot.setWorld(new PacmanWorld()); 
    }

    // Sends the Players to a new world | Manda os Players para um novo world
    public void levelThree() {
        Greenfoot.setWorld(new RaceWorld()); 
    }
    
    // Sends the Players to Planeta Terra | Manda os players para o Planeta Terra
    public void planetaTerra() {
        Greenfoot.setWorld(new PlanetaTerra());  
    }

    // Sends the Players to the Barbie Land | Manda os Players para Barbie Land
    public void barbieLand() {
        Greenfoot.setWorld(new BarbieLand());  
    }

    // BEGIN Sounds --------------------------------------------------------------------

    /**
     * Plays the OneUpSound
     * Toca o OneUpSound
     */
    public void playOneUpSound() {
        oneUpSound.setVolume(volumeWav); // Sets the volume of the oneUpSound
        oneUpSound.play(); // Plays the oneUpSound
    }
    
    /**
     * Plays the JumpSound
     * Toca o JumpSound
     */
    public void playJumpSound() {
        jumpSound.setVolume(volumeWav); // Sets the volume of the jumpSound
        jumpSound.play(); // Plays the jumpSound
    }

    /**
     * Plays the GameOverSound
     * Toca o GameOverSound
     */
    public void playGameOverSound() {
        gameOverSound.setVolume(volumeWav); // Sets the volume of the gameOverSound
        gameOverSound.play(); // Plays the gameOverSound
    }

    /**
     * Plays the StartGameSound
     * Toca o StartGameSound
     */
    public void playStartGameSound() {
        startGameSound.setVolume(volumeWav); // Sets the volume of the startGameSound
        startGameSound.play(); // Plays the startGameSound
    }

    /**
     * Plays the CoinSound
     * Toca o CoinSound
     */
    public void playCoinSound() {
        coinSound.setVolume(volumeWav); // Sets the volume of the coinSound
        coinSound.play(); // Plays the coinSound
    }

    /**
     * Plays the HealthSound
     * Toca o HealthSound
     */
    public void playHealthSound() {
        healthSound.setVolume(volumeWav); // Sets the volume of the healthSound
        healthSound.play(); // Plays the healthSound
    }

    /**
     * Plays the ExitLevelSound
     * Toca o ExitLevelSound
     */
    public void playExitLevelSound() {
        exitLevelSound.setVolume(volumeWav); // Sets the volume of the exitLevelSound
        exitLevelSound.play(); // Plays the exitLevelSound
    }

    /**
     * Plays the VictorySound
     * Toca o VictorySound
     */
    public void playVictorySound() {
        victorySound.setVolume(volume); // Sets the volume of the victorySound
        victorySound.play(); // Plays the victorySound
    }

    /**
     * Plays the FallingSound
     * Toca o FallingSound
     */
    public void playFallingSound() {
        fallingSound.setVolume(volume); // Sets the volume of the fallingSound
        fallingSound.play(); // Plays the fallingSound
    }
    
    /**
     * Plays the DeathSound
     * Toca o DeathSound
     */
    public void playDeathSound() {
        deathSound.setVolume(volume); // Sets the volume of the deathSound
        deathSound.play(); // Plays the deathSound
    }
    
    /**
     * Plays the ExplosionSound
     * Toca o ExplosionSound
     */
    public void playExplosionSound() {
        explosionSound.setVolume(volume); // Sets the volume of the explosionSound
        explosionSound.play(); // Plays the explosionSound
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
        for (GreenfootImage image : gif.getImages()) {
            int wide = image.getWidth()*percent/100;
            int high = image.getHeight()*percent/100;
            image.scale(wide, high);
        }
        return gif;
    }
}
