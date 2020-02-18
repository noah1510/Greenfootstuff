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
    /**
     * Create a crab and initialize its two images.
     */
    public Crab()
    {    
        image1 = new GreenfootImage("crab.png");
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);
        canmove = true;
        wormsEaten = 0;
    }
        
    public void canmove(boolean canmov){
        System.out.println("Set canmove to " + canmov);
        canmove = canmov;
    }
    /** 
     * Act - do whatever the crab wants to do. This method is called whenever
     *  the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(canmove == true){
            checkKeypress();
            move(5);
            lookForWorm();
            switchImage();
        }  
        if(Greenfoot.isKeyDown("space")){
            ((CrabWorld)getWorld()).start();
        }
    }
    
    /**
     * Alternate the crab's image between image1 and image2.
     */
    public void switchImage()
    {
        if (getImage() == image1) 
        {
            setImage(image2);
        }
        else
        {
            setImage(image1);
        }
    }
            
    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")) 
        {
            turn(-4);
        }
        if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")) 
        {
            turn(4);
        }
        if (Greenfoot.isKeyDown("escape")) 
        {
            ((CrabWorld)getWorld()).stop();
        }
        
    }
    
    /**
     * Check whether we have stumbled upon a worm.
     * If we have, eat it. If not, do nothing. If we have
     * eaten eight worms, we win.
     */
    public void lookForWorm()
    {
        if ( isTouching(Worm.class) ) 
        {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
            
            wormsEaten = wormsEaten + 1;
            CrabWorld cworld = (CrabWorld) getWorld();
            
            switch(cworld.level){
                case(1):
                    if(wormsEaten == 5){
                        System.out.println("ate 5 worms");
                        cworld.level++;
                        cworld.prepare();
                    }
                    break;
                case(2): 
                case(3):
                    if(wormsEaten == 7){
                        System.out.println("ate 7 worms");
                        cworld.level++;
                        cworld.prepare();
                    }
                    break;
                case(4):
                case(5):
                    if(wormsEaten == 10){
                        System.out.println("ate 10 worms");
                        cworld.level++;
                        cworld.prepare();
                    }
                    break;
            }
        }
    }
}