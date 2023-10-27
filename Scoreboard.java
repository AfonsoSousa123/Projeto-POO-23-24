import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    // World variables | variaveis world
    MainWorld mainWorld;

    // Constant variables: they will always be the setted value | Variaveis constantes: vao sempre ser o valor definido
    private final int LIVES = 2;

    // Static variables: they will keep the values | Variaveis estaticas: mantem os valores
    public static int score = 0;
    public static int starCount = 0;
    public static int level = 0;
    public static int barbieLives = 2;
    public static int kenLives = 2;

    public int width;
    private int height = 60;
    private int drawHeight = 40;
    private int transparency = 120;

    // Image variables | variaveis de imagem
    GreenfootImage boardImage;

    public Scoreboard() {

    }

    public void addedToWorld(World w) {
        mainWorld = (MainWorld)w;
        width = mainWorld.getWidth();
        boardImage = new GreenfootImage(width, height);
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setTransparency(transparency);
        setImage(boardImage);
    }

    public void act() {
        drawScore();
        manualReset();
    }

    /**
     * Retrns the Score
     * Retorna o Score
     */
    public int getScore() {
        return score;
    }

    /**
     * Retrns the final Score
     * Retorna o Score final
     */
    public void drawFinalScore() {
        getScore();
    }

    /**
     * Draws the score onto the World
     * Mostra o Score no World
     */
    public void drawScore() {
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        boardImage.setColor(Color.WHITE);
        boardImage.setFont(new Font("Arial", 30));
        boardImage.drawString("Level: "+ level, 15, drawHeight);
        boardImage.drawString("Score: "+ score, 140, drawHeight);
        boardImage.drawString("Stars: "+ starCount, 845, drawHeight);
        boardImage.drawString("Lives: ", 965, drawHeight);
        boardImage.drawString("Barbie: "+ barbieLives, 1065, drawHeight);
        boardImage.drawString("Ken: "+ kenLives, 1200, drawHeight);
    }

    /**
     * Increments the score with the given amount
     * Incrementa o amount dado, ao Score
     */
    public void addScore(int amount) {
        score += amount;
    }

    /**
     * Adds the stars
     * Adiciona as estrelas    
     */
    public void addStars(int amount) {
        starCount += amount;
    }

    /**
     * Adds Barbie lives
     * Adiciona vidas do Barbie    
     */
    public void addBarbieLives(int amount) {
        if(barbieLives > 0) {
            barbieLives += amount; // increments the lives to the barbieLives
        }
    }

    /**
     * Removes Barbie lives
     * Remove vidas do Barbie    
     */
    public void removeBarbieLives(int amount) {
        if(barbieLives > 0) {
            barbieLives -= amount; // decrements the lives to the barbieLives
        } else if(barbieLives == 0) {
            mainWorld.gameOver();
        }
    }

    /**
     * Adds Ken lives
     * Adiciona vidas do Ken    
     */
    public void addKenLives(int amount) {
        if(kenLives > 0) {
            kenLives += amount; // increments the lives to the kenLives
        }
    }

    /**
     * Removes Ken lives
     * Remove vidas do Ken    
     */
    public void removeKenLives(int amount) {
        if(kenLives > 0) {
            kenLives -= amount; // decrements the lives to the kenLives
        } else if(kenLives == 0) {
            mainWorld.gameOver();
        }
    }

    /**
     * Manualy resets the Score by clicking shift + R 
     * Reseta manualmente o Score ao clicar shift + R   
     */
    public void manualReset() {
        if (Greenfoot.isKeyDown("shift") && Greenfoot.isKeyDown("R")) 
            resetVariables();
    }

    public static void resetVariables() {
        score = 0; // resets the score to its original value
        starCount = 0; // resets the starSount to its original value
        level = 0; // resets the level to its original value
        barbieLives = 2; // resets the counter to its original value
        kenLives = 2; // resets the counter to its original value
    }
}
