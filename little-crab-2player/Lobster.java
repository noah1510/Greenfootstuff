import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;
/**
 * A lobster. Lobsters live on the beach. They like to eat crabs. (Well, in our game
 * they do...)
 * 
 * Version: 2
 * 
 * The lobster walks around randomly. If it runs into a crab it eats it.
 * In this version, we have added a sound effect, and the game stops when
 * a lobster eats the crab.
 */

public class Lobster extends Actor
{
    private boolean canmove;
    private int kills = 0;
    private Vector playerscore;
    private Vector playernumbers;
    private int playeramount;
    private int boosts = 0;
    private int slows = 0;
    
    public Lobster(int players){
        canmove = true;
        playeramount = players;
        playerscore = new Vector();
        playernumbers = new Vector();
    }
    
    /**
     * Do whatever lobsters do.
     */
    public void act()
    {
        if(canmove == true){
            turnAtEdge();
            randomTurn();
            if((5 - (4 * slows) + (4 * boosts)) > 0){
                move(5 - (4 * slows) + (4 * boosts) );
            }
            else{
                move(1);
            }
        }
        lookForCrab();
    }
    
    public void canmove(boolean canmov){
        //System.out.println("Set canmove to " + canmov);
        canmove = canmov;
        
    }

    public void boost(){
        boosts++;
    }
    
    public void slow(){
        slows++;
    }
    
    /**
     * Check whether we are at the edge of the world. If we are, turn a bit.
     * If not, do nothing.
     */
    public void turnAtEdge()
    {
        if ( isAtEdge() ) 
        {
            turn(17);
        }
    }

    /**
     * Randomly decide to turn from the current direction, or not. If we turn
     * turn a bit left or right by a random degree.
     */
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) 
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }

    /**
     * Try to pinch a crab. That is: check whether we have stumbled upon a crab.
     * If we have, remove the crab from the game, and stop the program running.
     */
    public void lookForCrab()
    {
        Crab crab = (Crab) getOneIntersectingObject(Crab.class);
        if ( crab != null) {
            if(crab.getalive()){  
                crab.kill();
                Greenfoot.playSound("au.wav");
                kills++;
            }
            if(kills==playeramount){((CrabWorld)getWorld()).gameover();};
        }
    }
}