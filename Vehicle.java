import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Vehicle extends Actor
{
    // Local variables
    private int SPEED = 2;
    private int VSPEED = 0;
    private int acceleration = 2;
    private int jumpStrenght = 50;
    private int length;
    private int volume = 20;
    private int oneUpVolume = 70;
    private int imageSize = 30;
    
    public Vehicle() {
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public GreenfootImage redimencionaImg(GreenfootImage image, int percent) {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        return image;
    }
}
