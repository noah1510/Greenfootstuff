import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * constructor braucht die art des PowerUps
 *  0 = Speed Up
 *  1 = Slow Others
 *  2 = Slow Lobster
 *  3 = Slow Down
 *  4 = Boost others
 *  5 = Boost Lobseter
 */


public class PowerUp extends Actor{
    
    private int type;
    private GreenfootImage image;

    public PowerUp(int kind){
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
                break;
        }
        setImage(image);
    }

    public int type(){
        return type;
    }
    
}
