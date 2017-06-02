package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Abstract class with variables and methods common for all moveable objects in the game
 * 
 * @author Maria
 * @version 2
 */
public abstract class GameObject
{
    // instance variables
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;
    protected int gWidth;
    protected int gHeight;
    protected int collision;
    
    /**
     * Decides the movements of objects of the class GameObject
     */
    public void move()
    {
        x += xSpeed;
        if (x < 0)
        {
            xSpeed *= -1;
            PongPanel.setScore1();
            System.out.println("Player 2 - " + PongPanel.getScore2()
            + " : " + PongPanel.getScore1() + " - Player 1");
        }
        else if (x > Pong.getPWidth() - gWidth)
        {
            xSpeed *= -1;
            PongPanel.setScore2();
            System.out.println("Player 2 - " + PongPanel.getScore2()
            + " : " + PongPanel.getScore1() + " - Player 1");
        }
       
        y += ySpeed;
        if (y < 0 || y > Pong.getPHeight() - gHeight)
        {
            ySpeed *= -1;
        }
    }
    
    /**
     * Changes ySpeed
     * 
     * @param   ySpeed  new ySpeed
     */
    public void setYSpeed(int ySpeed)
    {
        this.ySpeed = ySpeed;
    }
    
    /**
     * Changes xSpeed
     * 
     * @param   xSpeed  new xSpeed
     */
    public void setXSpeed(int xSpeed)
    {
        this.xSpeed = xSpeed;
    }
    
    /**
     * Checks if an object hits another and changes the speed and direction
     * 
     * @param   paddle  Object that can be hit
     */
    public void checkCollision(GameObject paddle)
    {
        if (this.x > paddle.x && this.x <= paddle.x + paddle.gWidth)
        {
            if (this.y > paddle.y && this.y < paddle.y + paddle.gHeight)
            {
                System.out.println("collision!");
                xSpeed *= -1;
            }
        }
        else if (this.x + this.gWidth > paddle.x && this.x <= paddle.x + paddle.gWidth)
        {
            if (this.y > paddle.y && this.y < paddle.y + paddle.gHeight)
            {
                System.out.println("collision!");
                xSpeed *= -1;
            }
        }
    }
}
