import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class defines a crab. Crabs live on the beach. They like sand worms 
 * (very yummy, especially the green ones).
 * 
 * Version: 5
 * 
 * In this version, the crab behaves as before, but we add animation of the 
 * image.
 */

public class Crab extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int wormsEaten;   
    private boolean canmove;
    private int player_num;
    private float modifier = 0.75f;
    private boolean killed;
    private int boosts = 0;
    private int slows = 0;
    private int counter;
    /**
     * Create a crab and initialize its two images.
     */
    public Crab(int player)
    {    
        switch(player){
            case(1):
                image1 = new GreenfootImage("crab.png");
                image2 = new GreenfootImage("crab2.png");
                break;
            case(2):
            case(3):
            case(4):
            case(5):
            case(6):
            case(7):
            case(8):
                image1 = new GreenfootImage("crab-" + player + ".png");
                image2 = new GreenfootImage("crab2-" + player + ".png");
                break;
            default:
                break;
        }
        
        killed = false;
        setImage(image1);
        canmove = true;
        wormsEaten = 0;
        player_num = player;
    }
    
    public void kill(){
        killed = true;
        canmove = false;
    }
    
    public boolean getalive(){
        if(killed){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int getworms(){
        return wormsEaten;
    }
    
    public void canmove(boolean canmov){
        //System.out.println("Set canmove to " + canmov);
        if (killed == true){
            canmove = false;
        }
        else{
            canmove = canmov;
        }
    }
    
    public boolean canmove(){
        return canmove;
    }
    
    /** 
     * Act - do whatever the crab wants to do. This method is called whenever
     *  the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        counter++;
        if(Greenfoot.isKeyDown("Escape")){
            ((CrabWorld)getWorld()).pause();
        }
         if(Greenfoot.isKeyDown("space")){
            ((CrabWorld)getWorld()).restart();
        } 
        if(canmove == true){
            checkKeypress();
            if((5 + ((int) (modifier * wormsEaten)) + (boosts * 4) - (slows * 4)) > 0){
                move(5 + ((int) (modifier * wormsEaten)) + (boosts * 4) - (slows * 4) );
            }
            else{
                move(1);
            }
            lookForThings();
            switchImage();
        }  
    }
    
    public int getplayer(){
        return player_num;
    }
    
    public void boost(){
        boosts++;
    }
    
    public void slow(){
        slows++;
    }
    
    /**
     * Alternate the crab's image between image1 and image2.
     */
    public void switchImage()
    {
        if (getImage() == image1) {
            if(counter == 7){
                setImage(image2);
                counter = 0;
            }
        }
        else{
            if(counter == 7){
                setImage(image1);
                counter = 0;
            }
        }
    }
            
    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if(player_num <= CrabWorld.controls_player.length && player_num > 0){
            if (Greenfoot.isKeyDown(CrabWorld.controls_player[player_num-1][0])){
                turn(-4 - (int) (modifier * wormsEaten));
            }else if (Greenfoot.isKeyDown(CrabWorld.controls_player[player_num-1][1])){
                turn(4 + (int) (modifier * wormsEaten));
            }    
        }        
    }
    
    /**
     * Check whether we have stumbled upon a something.
     */
    public void lookForThings()
    {
        PowerUp powerup = (PowerUp) getOneIntersectingObject(PowerUp.class);
        if ( powerup != null) {
            CrabWorld cworld = (CrabWorld) getWorld();
            switch(powerup.type()){
                case(0):
                    boost();
                    break;
                case(1):
                    cworld.slowothers(player_num);
                    break;
                case(2):
                    cworld.lobster.slow();
                    break;
                case(3):
                    slow();
                    break;
                case(4):
                    cworld.boostothers(player_num);
                    break;
                case(5):
                    cworld.lobster.boost();
                    break;
                default:
                    break;
            }  
            removeTouching(PowerUp.class);
        }
        
        if ( isTouching(Worm.class) ) 
        {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
            
            wormsEaten = wormsEaten + 1;
            CrabWorld cworld = (CrabWorld) getWorld();
            
            if(wormsEaten % 5 == 0){
                cworld.spawnpowerup();
            }
            
            cworld.ateworm();
                       
            if(wormsEaten == 20){
                cworld.showText("Player " + player_num + " won!",300,300);
                Greenfoot.delay(20);
                cworld.showText("",300,300);
                cworld.reset();
            }
        }
        
        
    }
}