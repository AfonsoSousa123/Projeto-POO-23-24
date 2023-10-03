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
        "****.******.***",
        "...............",
        "*.**.*.********",
        "*.*...........*",
        "*.*.*K*.*.*.*.*",
        "*.*.*B*.*.*.*.*",
        "*.*...........*",
        "*.*.**.*.****.*",
        ".......*.......",
        "****.******.***",
    };
    
    
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
                int y = i * 40 + 20; // x position times the size of the Rock 40 plus the offset 20
                int x = j * 40 + 20;
                
                switch (mapChar) {
                    case '*':
                        addObject(new Block(),x,y);
                        break;
                    case '.':
                        // addObject(new Stud(),x,y);
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
