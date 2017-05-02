package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Lager paddle til Ã¥ treffe ballen med
 * 
 * @author Maria
 * @version 2
 */
public class Paddle extends GameObject
{
    // instance variables
    private int playerNum;
    
    /**
     * Constructor
     * Setter bredden og hÃ¸yden pÃ¥ objektet
     * Setter ySpeed til 0
     * AvgjÃ¸r om objektet skal vÃ¦re til hÃ¸yre
     * eller venstre.
     * 
     * @param   playerNum   Nummeret pÃ¥ spilleren
     */
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
     * Tegner paddles
     * 
     * @param   g   Grafikkvariabel
     */
    public void paintPaddle(Graphics g)
    {
        g.setColor(Pong.getPaddleColour());
        g.fillRect(x, y, gWidth, gHeight);
    }
    
    /**
     * Stopper objektet fra Ã¥ forsvinne helt
     */
    public void move()
    {
        if (y < 0 || y > Pong.getPHeight() - gHeight)
        {
            xSpeed = 0;
        }
        super.move();
    }
}
