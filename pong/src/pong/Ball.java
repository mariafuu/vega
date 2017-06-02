package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Makes the ball
 * 
 * @author Maria
 * @version 2
 */
public class Ball extends GameObject
{
    public Ball()
    {
        x = Pong.getPWidth() / 2;
        y = Pong.getPHeight() / 2;
        gWidth = 10;
        gHeight = 10;
        xSpeed = 5;
        ySpeed = 5;
        collision = 0;
    }

    /**
     * Creates a ball
     * 
     * @param   g   grafikk-variabel
     */
    public void paintBall(Graphics g)
    {
        g.setColor(Pong.getBallColour());
        g.fillOval(x, y, gWidth, gHeight);
    }
}
