import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Vehicle extends Actor
{
    // Local variables | variaveis locais
    private int SPEED = 2; // velocidade
    private int VSPEED = 0; // velocidade vertical
    private int acceleration = 2; // aceleração
    private int jumpStrenght = 50; // força do salto
    private int length; // largura
    private int volume = 20; // volume geral
    private int oneUpVolume = 70; // volume geral
    private int imageSize = 30; // tamanho das imagens
    
    // Initializes the sounds | Inicializa os sons
    GreenfootSound fallingSound = new GreenfootSound("Falling-object.mp3");
    GreenfootSound coinSound = new GreenfootSound("8bit-coin-sound-effect.mp3");
    GreenfootSound oneUpSound = new GreenfootSound("1-up.wav");

    // World variables | Variaveis World
    MainWorld mainWorld;
    
    public Vehicle() {
        
    }
    
    public void addedToWorld(World w) {
        mainWorld = (MainWorld)w;
    }
    
    public void act() {
        
    }
    
    public GreenfootImage redimencionaImg(GreenfootImage image, int percent) {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        return image;
    }
    
    /**
     * Moves the Car
     * Move o Car
     */
    public void moveVehicle(
        String up,
        String down,
        String left, 
        String right, 
        int x, 
        int y 
    ) {
        if(getWorld() instanceof RaceWorld) {
            if(Greenfoot.isKeyDown(up)) {
                moveUp(x, y);
            } else if(Greenfoot.isKeyDown(down)) {
                moveDown(x, y);
            } else if(Greenfoot.isKeyDown(right)) {
                moveRight(x, y);
            } else if(Greenfoot.isKeyDown(left)) {
                moveLeft(x, y);
            } 
        } 
    }
    
    /**
     * Moves the Vehicle to the right
     * Move o Vehicle para a direita
     */
    private void moveRight(int x,int y) {
        setLocation(x + SPEED, y);
    }
    
    /**
     * Moves the Vehicle to the left
     * Move o Vehicle para a esquerda
     */
    private void moveLeft(int x,int y) {
        setLocation(x - SPEED, y);
    }
    
    /**
     * Moves the Vehicle Down
     * Move o Vehicle para a baixo
     */
    private void moveDown(int x, int y) {
        setLocation(x, y + SPEED);
    }
    
    /**
     * Moves the Vehicle Up
     * Move o Vehicle para a cima
     */
    private void moveUp(int x, int y) {
        setLocation(x, y - SPEED);
    }
    
    /**
     * Collects the studs and adds points to the Scoreboard
     * Apanha as studs e adiciona os respetivos pontos ao Scoreboard
     */
    public void collectStuds(Actor player) {
        Actor studBlue = getOneIntersectingObject(StudBlue.class);
        Actor studPurple = getOneIntersectingObject(StudPurple.class);
        
        if(studBlue != null && player.getClass() == Ken.class) {
            mainWorld.addScore(20); // Adds 20 score to the main score
            mainWorld.playCoinSound(); // Plays the coinSound
            mainWorld.removeObject(studBlue); // Removes the studBlue object
        } else if (studPurple != null && player.getClass() == Barbie.class) {
            mainWorld.addScore(20); // Adds 20 score to the main score
            mainWorld.playCoinSound(); // Plays the coinSound
            mainWorld.removeObject(studPurple); // Removes the studPurple object
        }
    }
    
    /**
     * Collects the Hearts and adds lives to the Player
     * Apanha os Hearts e adiciona as vidas do Player
     */
    public void collectHearts(Actor player) {
        Actor heart = getOneIntersectingObject(Heart.class);
        
        if(heart != null) {
            if (player.getClass() == Barbie.class) {
                mainWorld.addBarbieLives(1); // Adds one live to the livesCounter
            } else if (player.getClass() == Ken.class) {
                mainWorld.addKenLives(1);
            }
            
            mainWorld.playHealthSound(); // Plays the healthSound
            mainWorld.removeObject(heart); // Removes the heart object
        }
    }
    
    /**
     * Collects the star
     * Apanha a estrela
     */
    public void collectStars(Actor player) {
        Actor star = getOneIntersectingObject(Star.class);
        
        if(star != null) {
            if (player.getClass() == Barbie.class) {
                mainWorld.addBarbieLives(1); // Adds one live to the livesCounter
            } else if (player.getClass() == Ken.class) {
                mainWorld.addKenLives(1);
            }
            
            mainWorld.playOneUpSound();
            mainWorld.removeObject(star); // Removes the Star object
        }
    }
}
