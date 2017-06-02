package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Makes a paddle to hit the ball with
 * 
 * @author Maria
 * @version 2
 */
public class Paddle extends GameObject
{
    // instance variables
    private int playerNum;
    
    public Paddle(int playerNum)
    {
        gWidth = 20;
        gHeight = 100;
        ySpeed = 0;
        this.playerNum = playerNum;
        
        if (playerNum == 1)
        {
            x = Pong.getPWidth() - gWidth;
        }
        else if (playerNum == 2)
        {
            x = 0;
        }
        y = Pong.getPHeight() / 2 - this.gHeight / 2;
    }
    
    /**
     * Paints the paddles
     * 
     * @param   g   Grafikkvariabel
     */
    public void paintPaddle(Graphics g)
    {
        g.setColor(Pong.getPaddleColour());
        g.fillRect(x, y, gWidth, gHeight);
    }
    
    /**
     * Stops the object from leaving the window
     */
    @Override
    public void move()
    {
        if (y < 0 || y > Pong.getPHeight() - gHeight)
        {
            xSpeed = 0;
        }
        super.move();
    }
}
