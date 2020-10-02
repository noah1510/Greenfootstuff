import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * constructor needs the type of the powerup
 *  0 = Speed Up
 *  1 = Slow Others
 *  2 = Slow Lobster
 *  3 = Slow Down
 *  4 = Boost others
 *  5 = Boost Lobster
 */


public class PowerUp extends Actor{
    
    static public final int SpeedUp = 0;
    static public final int SlowOthers = 1;  
    static public final int SlowLobster = 2; 
    static public final int SlowDown = 3; 
    static public final int BoostOthers = 4;  
    static public final int BoostLobster = 5; 
    
    private final int type;
    private final GreenfootImage image;
    
    public PowerUp(int kind) throws PowerUpException{
        type = kind;
        switch(type){
            case(0):
            case(4):
                image = new GreenfootImage("apple1.png");
                break;
            case(1):
            case(3):
                image = new GreenfootImage("apple2.png");
                break;
            case(2):
            case(5):
                image = new GreenfootImage("bananas.png");
                break;
            default:
                throw new PowerUpException("Invalid PowerU Type");
        }
        setImage(image);
    }

    public final int type(){
        return type;
    }
    
    public final boolean isSpeedUp(){
        return type == SpeedUp;
    }
    
    public final boolean isSlowOthers(){
        return type == SlowOthers;
    }
    
    public final boolean isSlowLobster(){
        return type == SlowLobster;
    }
    
    public final boolean isSlowDown(){
        return type == SlowDown;
    }
    
    public final boolean isBoostOthers(){
        return type == BoostOthers;
    }
    
    public final boolean isBoostLobster(){
        return type == BoostLobster;
    }
    
     

}
