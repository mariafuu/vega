package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Abstrakt klasse med felles variabler og metoder for alle
 * bevegelige objekter i spillet.
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
     * Bestemmer bevegelsen for objekter av GameObject
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
     * Endrer ySpeed
     * 
     * @param   ySpeed  ny ySpeed
     */
    public void setYSpeed(int ySpeed)
    {
        this.ySpeed = ySpeed;
    }
    
    /**
     * Endrer xSpeed
     * 
     * @param   xSpeed  ny xSpeed
     */
    public void setXSpeed(int xSpeed)
    {
        this.xSpeed = xSpeed;
    }
    
    /**
     * Sjekker om et objekt(this) treffer et annet(paddle)
     * og endrer xSpeed
     * 
     * @param   paddle  Objektet som kan bli truffet
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
