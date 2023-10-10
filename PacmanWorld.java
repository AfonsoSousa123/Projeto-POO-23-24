import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacmanWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends MainWorld
{
    String[] textMap = {
        "****b******p***",
        "phpbbpbpbpbbpbb",
        "*p**p*p******p*",
        "*b*pbpbbpbpbpb*",
        "*p*b*K*b*p*B*p*",
        "*b*p*p*p*b*b*p*",
        "*p*bpbpbpbpbpb*",
        "*b*b**b*b****h*",
        "bpbpbpb*ppbpbpb",
        "****p******b***",
    };
    
    private int BlockSize = 87; // Size of the block
    private int BlockOffsetY = 10; // Y Offset of the block
    private int BlockOffsetX = 40; // X Offset of the block
    private int mobSize = 30; // Size of the mob 
    private int playerSize = 30; // Size of the player

    /**
     * Constructor for objects of class PacmanWorld.
     * 
     */
    public PacmanWorld()
    {
        drawMap();
        setPaintOrder(Scoreboard.class, Player.class, Target.class);
    }
    
    /**
     * Draws world map for the program using the textMap String Array.
     */
    public void drawMap() {
        for(int i=0; i<textMap.length; i++) {
            String mapLine = textMap[i];
            for(int j=0; j<mapLine.length(); j++) {
                char mapChar = mapLine.charAt(j);
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
                    case 'B':
                        addObject(new Barbie(playerSize),x,y);
                        break;
                    case 'K':
                        addObject(new Ken(playerSize),x,y);
                        break;
                    case 'h':
                        addObject(new Heart(),x,y);
                        break;
                    case 'E':
                        addObject(new Enemy(mobSize),x,y);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
