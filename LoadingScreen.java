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
    Scoreboard sb;
    private int timer = 0;

    /**
     * Constructor for objects of class LoadingScreen.
     * 
     */
    public LoadingScreen() {
        super();
        prepare();
        drawBackground();
    }

    public void act() {
        timer++;
        changeWorld();
    }

    private void drawBackground() {
        // setBackground(resizeImage(bgImage, 1300, 800)); // Scales the image to the desired width and height
        GreenfootImage bgImage = new GreenfootImage(1,1);
        Color color = new Color(244,216,0); // color to match the yellow of the loader | cor amarela para ser igual à do loader
        bgImage.setColor(color); // sets the color | define a cor
        bgImage.drawRect(0,0,1,1); // draws a rectangle | desenha um quadrado
        setBackground(bgImage); // sets the background | define a imagem criada como o fundo
    }

    private void changeWorld() {
        playExitLevelSound(); // Plays the exitLevelSound | Toca o VictorySound

        if (timer > 100) {
            switch(sb.level) {
                case 1:
                    levelOne(); // Teleports the player to the Level One | Teleporta o player para a BarbieLand (O Fim)
                    break;
                case 2:
                    levelTwo(); // Teleports the player to the Level Two | Teleporta o player para a BarbieLand (O Fim)
                    break;
                case 3:
                    levelThree(); // Teleports the player to the Level Three | Teleporta o player para a BarbieLand (O Fim)
                    break;
                case 4:
                    barbieLand(); // Teleports the player to the BarbieLand (the End) | Teleporta o player para a BarbieLand (O Fim)
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
        LegoLoader legoLoader = new LegoLoader();
        addObject(legoLoader,642,414);
    }
}
