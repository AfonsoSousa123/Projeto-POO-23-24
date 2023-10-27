import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // Local variables | variaveis locais
    private int SPEED = 2; // velocidade
    private int VSPEED = 0; // velocidade vertical
    private int acceleration = 2; // aceleração
    private int jumpStrenght = 45; // força do salto
    private int length; // largura
    private int imageSize = 30; // tamanho das imagens

    // World variables | Variaveis World
    MainWorld mainWorld;

    public Player() {
        int playerSize = imageSize;
    }

    public void addedToWorld(World w) {
        mainWorld = (MainWorld)w;
    }

    public void act() {
        
    }

    // BEGIN Player Movement -------------------------------------------------------

    /**
     * Moves the Player
     * Move o Player
     */
    public void movePlayer(
        String up, 
        String down, 
        String left, 
        String right, 
        int x, 
        int y, 
        GifImage imageLeft,
        GifImage imageRight,
        GreenfootImage imageFront
    ) {
        if(getWorld() instanceof MarioStyleWorld) {
            movePlayerMarioWorld(up, left, right, x, y, imageLeft, imageRight, imageFront);
        } else if (getWorld() instanceof PacmanWorld) {
            movePlayerPacmanWorld(up, down, left, right, x, y, imageLeft, imageRight, imageFront);
        }
        else if (getWorld() instanceof PlanetaTerra) {
            SPEED = 4;
            movePlayerPlanetaTerra(left, right, x, y, imageLeft, imageRight, imageFront);
        }
    }
    
    /**
     * Moves the Player in the MarioStyleWorld
     * Move o Player no MarioStyleWorld
     */
    private void movePlayerPlanetaTerra( 
        String left, 
        String right, 
        int x, 
        int y, 
        GifImage imageLeft,
        GifImage imageRight,
        GreenfootImage imageFront
    ) {
        if(Greenfoot.isKeyDown(left)) {
            setImage(imageLeft.getCurrentImage());
            moveLeft(x,y);
        } else if(Greenfoot.isKeyDown(right)) {
            setImage(imageRight.getCurrentImage());
            moveRight(x,y);
        } else {
            setImage(imageFront);
        }
    }
    
    /**
     * Moves the Player in the MarioStyleWorld
     * Move o Player no MarioStyleWorld
     */
    private void movePlayerMarioWorld(
        String up,  
        String left, 
        String right, 
        int x, 
        int y, 
        GifImage imageLeft,
        GifImage imageRight,
        GreenfootImage imageFront
    ) {
        if(Greenfoot.isKeyDown(up) && onGround(this)) {
            jump(x,y);
            mainWorld.playJumpSound();
        } else if(Greenfoot.isKeyDown(left)) {
            setImage(imageLeft.getCurrentImage());
            moveLeft(x,y);
        } else if(Greenfoot.isKeyDown(right)) {
            setImage(imageRight.getCurrentImage());
            moveRight(x,y);
        } else {
            setImage(imageFront);
        }
    }

    /**
     * Moves the Player in the PacmanWorld 
     * Move o Player no PacmanWorld
     */
    private void movePlayerPacmanWorld(
        String up,
        String down,
        String left,
        String right,
        int x,
        int y,
        GifImage imageLeft,
        GifImage imageRight,
        GreenfootImage imageFront
    ) {
        if(Greenfoot.isKeyDown(up) && canMoveUp()) {
            moveUp(x,y);
        } else if(Greenfoot.isKeyDown(down) && canMoveDown()) {
            moveDown(x,y);
        } else if(Greenfoot.isKeyDown(left) && canMoveLeft()) {
            setImage(imageLeft.getCurrentImage());
            moveLeft(x,y);
        } else if(Greenfoot.isKeyDown(right) && canMoveRight()) {
            setImage(imageRight.getCurrentImage());
            moveRight(x,y);
        } else {
            setImage(imageFront);
        }
    }

    /**
     * Checks if the Player is out of the boundaries of the MarioStyleWorld and if so removes one live
     * Verifica se o Player está fora das bordas do MarioStyleWorld e assim sendo remove uma vida
     */
    public void checkBounds(Player player) {
        if(getWorld() instanceof MarioStyleWorld) {
            if (player.getY() > getWorld().getHeight() + 120) {
                mainWorld.playFallingSound();

                if (player.getClass() == Barbie.class) {
                    mainWorld.removeBarbieLives(1);
                } else if (player.getClass() == Ken.class) {
                    mainWorld.removeKenLives(1);
                }

                player.setLocation(300,300); // Spawns the player into the coordinates
            }
        }
    }
    
    /**
     * Teleports the Player through the passages in the boundaries of the PacmanWorld
     * Teleporta o Player através das passagens nas bordas do PacmanWorld
     */
    public void teleportPlayer(Player player) {
        if (getWorld() instanceof PacmanWorld) {
            // Vertical Lines
            if (player.getY() > 800) {
                // the upper left to the lower left passage | da passagem do canto superior esquerdo para a do inferior esquerdo
                if (player.getX() > 345 && player.getX() < 433) {
                    player.setLocation(388, 0); // teleports the player directly above its position
                } else if (player.getX() > 954 && player.getX() < 1042) {
                    player.setLocation(997, 0); // teleports the player directly above its position
                }
            } else if (player.getY() < 0) {
                // the upper left to the lower left passage | da passagem do canto inferior esquerdo para a do superior esquerdo
                if (player.getX() > 345 && player.getX() < 433) {
                    player.setLocation(388, 800); // teleports the player directly below its position
                } else if (player.getX() > 954 && player.getX() < 1042) {
                    player.setLocation(997, 800); // teleports the player directly below its position
                }
            }
            
            // Horizontal Lines
            if (player.getX() > 1300) {
                // the upper left to the upper right passage | da passagem do canto superior esquerdo para a do superior direito
                if (player.getY() > 74 && player.getY() < 162) { 
                    player.setLocation(0, 97); // teleports the player directly to its right position
                } else if (player.getY() > 663 && player.getY() < 751) {
                    player.setLocation(0, 706); // teleports the player directly to its right position
                }
            } else if (player.getX() < 0) {
                // the upper right to the upper left passage | da passagem do canto superior direito para a do superior esquerdo
                if (player.getY() > 74 && player.getY() < 162) { // the upper right to the upper left passage
                    player.setLocation(1300, 97); // teleports the player directly to its left position
                } else if (player.getY() > 663 && player.getY() < 751) {
                    player.setLocation(1300, 706); // teleports the player directly to its left position
                }
            }
        }
    }

    // END Player Movement -------------------------------------------------------

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

    /**
     * Simulates the gravity of the Player
     * Simula a gravidade do Player
     */
    public void fall(int x,int y) {
        setLocation(x, y + VSPEED);
        VSPEED += acceleration;
    }

    /**
     * Simulates the jump of the Player
     * Simula o salto do Player
     */
    public void jump(int x,int y) {
        VSPEED = -jumpStrenght;
        fall(x,y);
    }

    /**
     *  Checks if the Player is falling
     *  Verifica se o Player está a cair
     */
    public void checkFall(Player player, int x,int y) {
        if(getWorld() instanceof  MarioStyleWorld){
            if(!onGround(player)) {
                fall(x,y);
            } else if (onGround(player)) {
                VSPEED = 0;
            }
        }
    }

    /**
     *  Checks if the Player is on the Ground
     */    
    public boolean onGround(Player player) { // verifica se o player está a tocar no chão
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/3, Ground.class);
        return ground != null;
    }

    /**
     * Checks if the Player is touching the above platform
     */
    public boolean platformAbove(Actor player) { // palataforma em cima
        int spriteHeight = getImage().getHeight();
        int yDistance = spriteHeight/-4;
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Ground.class);

        if(ceiling != null) {
            VSPEED = 0;
            bopHead(ceiling);
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Adds an offset to the height of the Player
     */
    public void bopHead(Actor ceiling) {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/3;
        setLocation(getX(), newY);
    }

    /**
     * PacmanWorld code begin
     */

    /**
     * Checks if the player can move left
     * Verifica se o jogador consegue se mover para a esquerda
     */
    public boolean canMoveLeft() {
        boolean canMoveLeft = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/-2-4, imageHeight/-2, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/-2-4, imageHeight/2-1, Block2x2.class) != null) {
            canMoveLeft = false;
        }

        return canMoveLeft;
    }

    /**
     * Checks if the player can move right
     * Verifica se o jogador consegue se mover para a direita
     */
    public boolean canMoveRight() {
        boolean canMoveLeft = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/2+4, imageHeight/-2, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/2+4, imageHeight/2-1, Block2x2.class) != null) {
            canMoveLeft = false;
        }

        return canMoveLeft;
    }

    /**
     * Checks if the player can move up
     * Verifica se o jogador consegue se mover para cima
     */
    public boolean canMoveUp() {
        boolean canMoveUp = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/-2, imageHeight/-2-4, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/2-1, imageHeight/-2-4, Block2x2.class) != null) {
            canMoveUp = false;
        }

        return canMoveUp;
    }

    /**
     * Checks if the player can move down
     * Verifica se o jogador consegue se mover para baixo
     */
    public boolean canMoveDown() {
        boolean canMoveDown = true;

        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();

        if(getOneObjectAtOffset(imageWidth/-2, imageHeight/2+4, Block2x2.class) != null || 
        getOneObjectAtOffset(imageWidth/2-1, imageHeight/2+4, Block2x2.class) != null) {
            canMoveDown = false;
        }

        return canMoveDown;
    }
    
    /**
     * PacmanWorld code end
     */

    // BEGIN Player Movement -------------------------------------------------------

    /**
     * Moves the Player to the right
     * Move o Player para a direita
     */
    private void moveRight(int x,int y) {
        setLocation(x + SPEED, y);
    }

    /**
     * Moves the Player to the left
     * Move o Player para a esquerda
     */
    private void moveLeft(int x,int y) {
        setLocation(x - SPEED, y);
    }

    /**
     * Moves the Player Down
     * Move o Player para baixo
     */
    private void moveDown(int x, int y) {
        setLocation(x, y + SPEED);
    }

    /**
     * Moves the Player Up
     * Move o Player para cima
     */
    private void moveUp(int x, int y) {
        setLocation(x, y - SPEED);
    }

    // END Player Movement -------------------------------------------------------

    /**
     * Sets an adjusted offset with the given value
     * Calcula um offset com o valor fornecido
     */
    private int adjustOffset(int offset) {
        int signOfOffset = (int)Math.signum(offset); // casting the offset to be int instead of double
        int distanceToFront = length/2;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
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
                mainWorld.addBarbieLives(1); // Adds one live to the livesCounter for Barbie
            } else if (player.getClass() == Ken.class) {
                mainWorld.addKenLives(1); // Adds one live to the livesCounter for Kem
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
            mainWorld.playOneUpSound(); // Plays the oneUpSound | Toca o oneUpSound
            mainWorld.addStars(1); // Counts the collected stars | Conta as estrelas apanhadas
            mainWorld.removeObject(star); // Removes the Star object | Remove o objeto Star
        }
    }

    /**
     * Removes lives of the Player if it touches the Enemy
     * Remove as vidas do Player se ele toca no Enemy
     */
    public void touchEnemy(Actor player) {
        Actor enemy = getOneIntersectingObject(Enemy.class);

        if(enemy != null) {
            if (player.getClass() == Barbie.class) {
                mainWorld.removeBarbieLives(1); // Removes one live for Barbie
                if(getWorld() instanceof PacmanWorld) 
                    barbieSpawnLocation();
                else
                    marioWorldSpawnLocation();
            } else if (player.getClass() == Ken.class) {
                mainWorld.removeKenLives(1); // Removes one live for Ken
                if(getWorld() instanceof PacmanWorld) 
                    kenSpawnLocation();
                else
                    marioWorldSpawnLocation();
            }
            mainWorld.playDeathSound(); // Plays the healthSound
        }
    }

    public void barbieSpawnLocation() {
        setLocation(475, 358);
    }

    public void kenSpawnLocation() {
        setLocation(997, 358);
    }
    
    public void marioWorldSpawnLocation() {
        setLocation(300,300); // Spawns the player into the coordinates
    }
}
