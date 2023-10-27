import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadingScreen extends MainWorld
{
    private GreenfootImage bgImage = new GreenfootImage(getBackground());
    Scoreboard sb; // Scoreboard variable
    private int timer = 0; // timer for the LoadingScreen

    /**
     * Constructor for the LoadingScreen Class.
     * Contrutor para a Classe LoadingScreen.
     */
    public LoadingScreen() {
        super();
        prepare();
        drawBackground(); // draws the Background
    }

    public void act() {
        timer++; // Increments the timer
        changeWorld(); // calls the changeWorld mehtod
    }

    private void drawBackground() {
        GreenfootImage bgImage = new GreenfootImage(1,1); // creates a new Image | cria uma nova imagem
        Color color = new Color(244,216,0); // color to match the yellow of the loader | cor amarela para ser igual à do loader
        bgImage.setColor(color); // sets the color | define a cor
        bgImage.drawRect(0,0,1,1); // draws a rectangle | desenha um quadrado
        setBackground(bgImage); // sets the background | define a imagem criada como o fundo
    }

    private void changeWorld() {
        playExitLevelSound(); // Plays the exitLevelSound | Toca o VictorySound

        if (timer > 100) {
            switch(sb.level) {
                case 0:
                    planetaTerra(); // Teleports the player to the Level Zero | Teleporta o player para o Planeta Terra
                    sb.level++; // Increments one Level
                    break;
                case 1:
                    levelOne(); // Teleports the player to the Level One | Teleporta o player para o nível um 
                    break;
                case 2:
                    levelTwo(); // Teleports the player to the Level Two | Teleporta o player para o nível dois 
                    break;
                case 3:
                    levelThree(); // Teleports the player to the Level Three | Teleporta o player para o nível três
                    break;
                case 4:
                    planetaTerra(); // Teleports the player to Planeta Terra | Teleporta o player para o Planeta Terra (O Fim)
                    break;
                default:
                    gameOver(); // Its Game Over for the player || Fim do jogo para o player
                    break;
            }
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        LegoLoader legoLoader = new LegoLoader(); // Creates a new instance of LegoLoader()
        addObject(legoLoader,642,414); // Spawns the LegoLoader into the LoadingScreen
    }
}
