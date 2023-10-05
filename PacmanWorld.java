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
        "bbbbbpbbbbbbbbb",
        "*b**b*b********",
        "*b*bbbbbpbbbpb*",
        "*b*b*K*b*.*B*.*",
        "*b*b*.*b*.*.*.*",
        "*p*...........*",
        "*b*.**.*.****.*",
        "bpbbbbb*bbbpbbb",
        "****p******p***",
    };
    
    private int BlockSize = 87; // Size of the block
    private int BlockOffsetY = 10; // Y Offset of the block
    private int BlockOffsetX = 40; // X Offset of the block

    /**
     * Constructor for objects of class PacmanWorld.
     * 
     */
    public PacmanWorld()
    {
        drawMap();
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
                        addObject(new Barbie(),x,y);
                        break;
                    case 'K':
                        addObject(new Ken(),x,y);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
