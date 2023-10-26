import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Actor
{
    private int SPEED = 8; // speed for the MarioStyleWorld
    private int speedRaceWorld = 1; // speed for the RaceWorld

    public Ken ken;
    public Barbie barbie;
    
    MainWorld mainworld;

    /**
     * Constructor for the Target class.
     * Contrutor da classe Target.
     */
    public Target() {
        
    }

    public void act() {
        // Add your action code here.
    }

    /**
     * Main method for movement
     * Método geral para o movimento
     */
    public void moveTarget(int x, int y) {
        if (getWorld() instanceof  MarioStyleWorld) {
            moveTargetMW();
        } else if (getWorld() instanceof RaceWorld) {
            moveTargetRW(x, y);
        }
    }

    /**
     * Movement for the Targets in the MarioStyleWorld
     * Movimento para os Targets no MarioStyleWorld
     */
    private void moveTargetMW() {
        if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")) {
            move(SPEED);
        } else if(Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right")) {
            move(-SPEED);
        }
    }
    
    /**
     * Generates random speed number
     * Geraa um numero aleatório para a velocidade
     */
    public int getRandomSpeed() {
        int max = 5;
        int min = 1;
        return Greenfoot.getRandomNumber(max) + min;
    }

    /**
     * Movement for the Targets in the RaceWorld
     * Movimento para os Targets no RaceWorld
     */
    private void moveTargetRW(int x, int y) {
        setLocation(x, y + speedRaceWorld);
    }

    /**
     * Resizes the given image to the widht and height specified
     * Redimensiona a imagem dada para um comprimento e uma altura fornecidos
     */
    public GreenfootImage resizeImage(GreenfootImage image, int width, int height) {
        image.scale(width, height);
        setImage(image);
        return image;
    }
}
