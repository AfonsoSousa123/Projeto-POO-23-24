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
    
    private MainWorld main;
    
    public Vehicle() {
        
    }
    
    public void addedToWorld(World w) {
        main = (MainWorld)w;
    }
    
    public void act()
    {
        
    }
    
    public GreenfootImage redimencionaImg(GreenfootImage image, int percent) {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        return image;
    }
    
    /**
     * Moves the Car
     */
    public void moveVehicle(
        String up, 
        String down,
        String left, 
        String right, 
        int x, 
        int y 
    ) {
        if(getWorld() instanceof RaceWorld) {
            if(Greenfoot.isKeyDown(up)) {
                moveUp(x, y);
            } else if(Greenfoot.isKeyDown(down)) {
                moveDown(x, y);
            } else if(Greenfoot.isKeyDown(right)) {
                moveRight(x, y);
            } else if(Greenfoot.isKeyDown(left)) {
                moveLeft(x, y);
            } 
        } 
    }
    
    /**
     * Moves the Vehicle to the right
     */
    private void moveRight(int x,int y) {
        setLocation(x + SPEED, y);
    }
    
    /**
     * Moves the Vehicle to the left
     */
    private void moveLeft(int x,int y) {
        setLocation(x - SPEED, y);
    }
    
    /**
     * Moves the Vehicle Down
     */
    private void moveDown(int x, int y) {
        setLocation(x, y + SPEED);
    }
    
    /**
     * Moves the Vehicle Up
     */
    private void moveUp(int x, int y) {
        setLocation(x, y - SPEED);
    }
    
    // private void playOneUpSound() {
        // coinSound.setVolume(volume); // Sets the volume of the coinSound
        // coinSound.play(); // Plays the coinSound
    // }
    
    // /**
     // * Collects the studs and adds points to the Scoreboard
     // */
    // public void collectStuds(Actor player) {
        // Actor studBlue = getOneIntersectingObject(StudBlue.class);
        // Actor studPurple = getOneIntersectingObject(StudPurple.class);
        
        // if(studBlue != null && player.getClass() == Ken.class) {
            // playOneUpSound();
            // mainWorld.addScore(20); // Adds 20 score to the main score
            // mainWorld.removeObject(studBlue); // Removes the studBlue object
        // } else if (studPurple != null && player.getClass() == Barbie.class) {
            // playOneUpSound();
            // mainWorld.addScore(20); // Adds 20 score to the main score
            // mainWorld.removeObject(studPurple); // Removes the studPurple object
        // }
    // }
    
    // /**
     // * Collects the studs and adds points to the Scoreboard
     // */
    // public void collectHearts(Actor player) {
        // Actor heart = getOneIntersectingObject(Heart.class);
        
        // if(heart!= null) {
            // oneUpSound.setVolume(oneUpVolume); // Sets the volume of the oneUpSound
            // oneUpSound.play(); // Plays the oneUpSound
            
            // if (player.getClass() == Barbie.class) {
                // mainWorld.addBarbieLives(1); // Adds one live to the livesCounter
            // } else if (player.getClass() == Ken.class) {
                // mainWorld.addKenLives(1);
            // }
            
            // mainWorld.removeObject(heart); // Removes the heart object
        // }
    // }
}
