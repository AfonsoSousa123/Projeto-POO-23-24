import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacmanWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends MainWorld {
    String[] textMap = {
        "****b******p***",
        "phpbppbpbEbpbpb",
        "*p**p*p******p*",
        "*b*pbpbEpbpbpb*",
        "*p*b*B*b*p*K*p*",
        "*b*p*p*p*b*b*p*",
        "*p*bpbpEpbpbpb*",
        "*b*b**b*b****h*",
        "bpEpbpb*ppbEbpb",
        "****p******b***",
    };
    
    private int BlockSize = 87; // Size of the block
    private int BlockOffsetY = 10; // Y Offset of the block
    private int BlockOffsetX = 40; // X Offset of the block
    private int mobSize = 13; // Size of the mob 
    private int playerSize = 24; // Size of the player
    private boolean StopSpawn = false; // Stops the Spawning of the Stars

    /**
     * Constructor for objects of class PacmanWorld.
     * Contrutor da classe PacmanWorld
     */
    public PacmanWorld()
    {
        drawMap();
        setPaintOrder(Scoreboard.class, Mob.class, Player.class, Target.class);
    }
    
    public void act() {
        checkStarCount();
        spawnStarsPW();
    }
    
    /**
     * Spawns the Stars when the Score is 1000
     * Adiciona as Stars quando o Score for igual a 1000
     */
    public void spawnStarsPW() {
        if (getScore() == 1000 && !StopSpawn) { // Spawns the Stars when the score is equals to 1000
            addObject(new Star(), 823, 97);
            addObject(new Star(), 214, 706);
            StopSpawn = true;
        }
    }
    
    /**
     * Draws world map for the program using the textMap String Array.
     * Desenha o mundo usando uma matriz de Strings
     */
    public void drawMap() {
        for(int i=0; i<textMap.length; i++) {
            String mapLine = textMap[i]; // Linha da matriz
            
            for(int j=0; j<mapLine.length(); j++) {
                char mapChar = mapLine.charAt(j); // character na linha
                int y = i * BlockSize + BlockOffsetY; // x position times the size of the Block plus the offset
                int x = j * BlockSize + BlockOffsetX; // y position times the size of the Block plus the offset
                
                switch (mapChar) {
                    case '*':
                        addObject(new Block2x2(),x,y);
                        break;
                    case 'p':
                        addObject(new StudPurple(),x,y);
                        break;
                    case 'b':
                        addObject(new StudBlue(),x,y);
                        break;
                    case 's':
                        addObject(new Star(),x,y);
                        break;
                    case 'B':
                        addObject(new Barbie(playerSize),x,y);
                        break;
                    case 'K':
                        addObject(new Ken(playerSize),x,y);
                        break;
                    case 'E':
                        addObject(new Enemy(mobSize),x,y);
                        break;
                    case 'h':
                        addObject(new Heart(),x,y);
                        break;
                    default:
                        // just leaves an empty space
                        break;
                }
            }
        }
    }
}
