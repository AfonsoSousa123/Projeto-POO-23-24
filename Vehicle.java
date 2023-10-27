import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Vehicle extends Actor {
    // Local variables | variaveis locais
    private int SPEED = 2; // velocidade
    private int VSPEED = 0; // velocidade vertical
    private int acceleration = 2; // aceleração
    private int colide = 120; // variavel para o offset do caro

    // World variables | Variaveis World
    private MainWorld mainWorld;
    
    public void addedToWorld(World w) {
        mainWorld = (MainWorld)w;
    }
    
    public GreenfootImage redimencionaImg(GreenfootImage image, int percent) {
        int wide = image.getWidth()*percent/100;
        int high = image.getHeight()*percent/100;
        image.scale(wide, high);
        return image;
    }
    
    /**
     * Moves the Car
     * Move o Car
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
            } 
            if(Greenfoot.isKeyDown(down)) {
                moveDown(x, y);
            } 
            if(Greenfoot.isKeyDown(right)) {
                if(getX() < 932)
                    moveRight(x, y);
            } 
            if(Greenfoot.isKeyDown(left)) {
                if(getX() > 300)
                    moveLeft(x, y);
            } 

            if(Greenfoot.isKeyDown(right) && Greenfoot.isKeyDown(up)) {
                if(getX() < 932 && getX() > 300)
                    moveUpAndRight(x, y);
            } 
            if(Greenfoot.isKeyDown(left) && Greenfoot.isKeyDown(up)) {
                if(getX() < 932 && getX() > 300)
                    moveUpAndLeft(x, y);
            } 
            if(Greenfoot.isKeyDown(right) && Greenfoot.isKeyDown(down)) {
                if(getX() < 932 && getX() > 300)
                    moveDownAndRight(x, y);
            } 
            if(Greenfoot.isKeyDown(left) && Greenfoot.isKeyDown(down)) {
                if(getX() < 932 && getX() > 300)
                    moveDownAndLeft(x, y);
            }
        }
    }
    
    /**
     * Moves the Vehicle to the right
     * Move o Vehicle para a direita
     */
    private void moveRight(int x,int y) {
        setLocation(x + SPEED, y);
    }
    
    /**
     * Moves the Vehicle to the left
     * Move o Vehicle para a esquerda
     */
    private void moveLeft(int x,int y) {
        setLocation(x - SPEED, y);
    }
    
    /**
     * Moves the Vehicle Down
     * Move o Vehicle para a baixo
     */
    private void moveDown(int x, int y) {
        setLocation(x, y + SPEED);
    }
    
    /**
     * Moves the Vehicle Up
     * Move o Vehicle para a cima
     */
    private void moveUp(int x, int y) {
        setLocation(x, y - SPEED);
    }
    
    /**
     * Moves the Vehicle Up and Right
     * Move o Vehicle para a cima e para a direita
     */
    private void moveUpAndRight(int x, int y) {
        setLocation(x + SPEED, y - SPEED);
    }
    
    /**
     * Moves the Vehicle Up and Left
     * Move o Vehicle para a cima e para a esquerda
     */
    private void moveUpAndLeft(int x, int y) {
        setLocation(x - SPEED, y - SPEED);
    }
    
    /**
     * Moves the Vehicle Down and Right
     * Move o Vehicle para a baixo e para a direita
     */
    private void moveDownAndRight(int x, int y) {
        setLocation(x + SPEED, y + SPEED);
    }
    
    /**
     * Moves the Vehicle Down and Left
     * Move o Vehicle para a baixo e para a esquerda
     */
    private void moveDownAndLeft(int x, int y) {
        setLocation(x - SPEED, y + SPEED);
    }
    
    /**
     * Collects the studs and adds points to the Scoreboard
     * Apanha as studs e adiciona os respetivos pontos ao Scoreboard
     */
    public void collectStuds(Actor vehicle) {
        Actor studBlue = getOneIntersectingObject(StudBlue.class);
        Actor studPurple = getOneIntersectingObject(StudPurple.class);
        
        if(studBlue != null && vehicle.getClass() == KenCar.class) {
            mainWorld.addScore(20); // Adds 20 score to the main score
            mainWorld.playCoinSound(); // Plays the coinSound
            mainWorld.removeObject(studBlue); // Removes the studBlue object
        } else if (studPurple != null && vehicle.getClass() == BarbieCar.class) {
            mainWorld.addScore(20); // Adds 20 score to the main score
            mainWorld.playCoinSound(); // Plays the coinSound
            mainWorld.removeObject(studPurple); // Removes the studPurple object
        }
    }
    
    /**
     * Collects the Hearts and adds lives to the Vehicle
     * Apanha os Hearts e adiciona as vidas do Vehicle
     */
    public void collectHearts(Actor vehicle) {
        Actor heart = getOneIntersectingObject(Heart.class);
        
        if(heart != null) {
            if (vehicle.getClass() == BarbieCar.class) {
                mainWorld.addBarbieLives(1); // Adds one live to the livesCounter for Barbie
            } else if (vehicle.getClass() == KenCar.class) {
                mainWorld.addKenLives(1); // Adds one live to the livesCounter for Ken
            }
            
            mainWorld.playHealthSound(); // Plays the healthSound
            mainWorld.removeObject(heart); // Removes the heart object
        }
    }
    
    /**
     * Collects the star
     * Apanha a estrela
     */
    public void collectStars(Actor vehicle) {
        Actor star = getOneIntersectingObject(Star.class);
        
        if(star != null) {
            mainWorld.playOneUpSound(); // Plays the oneUpSound | Toca o oneUpSound
            mainWorld.addStars(1); // Counts the collected stars | Conta as estrelas apanhadas
            mainWorld.removeObject(star); // Removes the Star object | Remove o objeto Star
        }
    }
    
    public void isTouchingVehicle(Vehicle vehicle,int x, int y) {
        Actor BarbieCar = getOneIntersectingObject(BarbieCar.class);
        Actor KenCar = getOneIntersectingObject(KenCar.class);
        
        if(BarbieCar != null){
            int newX = x - colide;
            int newY = BarbieCar.getY();
            BarbieCar.setLocation(newX,newY);
        }
        if(KenCar!= null){
            int newX = x + colide;
            int newY = KenCar.getY();
            KenCar.setLocation(newX,newY);
        }
    }
    
    public void isTouchingObject(Vehicle vehicle,int x, int y) {
        Actor ground = getOneIntersectingObject(Ground.class);
        Actor block2x2 = getOneIntersectingObject(Block2x2.class);
        
        if(ground != null || block2x2!= null){
            int newBarbieX = 432;
            int newKenX = 802;
            int newY = 631;
            
            if (vehicle.getClass() == BarbieCar.class) {
                mainWorld.removeBarbieLives(1);
                vehicle.setLocation(newBarbieX, newY); // Spawns the vehicle to the given x and y
            } else if (vehicle.getClass() == KenCar.class) {
                mainWorld.removeKenLives(1);
                vehicle.setLocation(newKenX, newY); // Spawns the vehicle to the given x and y
            }
            
            mainWorld.playExplosionSound(); // Plays the ExplosionSound
        }
    }
    
    /**
     * Checks if the Vheicle is at the Edge of the World
     * Verifica se o Vheicle está nas bordas do World
     */
    public void isAtEdge(Vehicle vehicle,int x, int y){
        if(vehicle.isAtEdge()){
            vehicle.setLocation(x,y);
            vehicle.setLocation(vehicle.getX(), vehicle.getY() - 2);
            vehicle.setLocation(vehicle.getX(), vehicle.getY() + 2);
        }
    }
}
