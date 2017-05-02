package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * This class makes an object where the game takes place
 * 
 * @author Maria
 * @version 2
 */
public class Pong extends JFrame
{
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private static int pWidth = 700;
    private static int pHeight = 500;
    private static Color bgColour = new Color(0, 0, 0);
    private static Color ballColour = new Color(0, 255, 0);
    private static Color paddleColour = new Color(0, 0, 255);
    
    /**
     * Sets up the game Pong
     * Sets size of JFrame
     * Creates a JPanel
     */
    public Pong()
    {
        setSize(pWidth + 5, pHeight + 25);
        setTitle("Pong");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        PongPanel pPanel = new PongPanel();
        add(pPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    /**
     * Declares a winner and closes the game.
     * 
     * @param   winner  Number of the player who won
     */
    public static void endGame(int winner)
    {
        if (winner == 1)
        {
            System.out.println("Player 1 won!");
        }
        else
        {
            System.out.println("Player 2 won!");
        }
        System.exit(0);
    }

    /**
     * Returns the width of the JFrame
     * 
     * @return pWidth   int
     */
    public static int getPWidth()
    {
        return pWidth;
    }
    
    /**
     * Returns height JFrame
     * 
     * @return pHeight   int
     */
    public static int getPHeight()
    {
        return pHeight;
    }
    
    /**
     * Returns background colour
     * 
     * @return bgColour   Color
     */
    public static Color getBGColour()
    {
        return bgColour;
    }
    
    /**
     * Returns the colour of the ball
     * 
     * @return ballColour   Color
     */
    public static Color getBallColour()
    {
        return ballColour;
    }
    
    /**
     * Returns the colour of the paddles
     * 
     * @return paddleColour   Color
     */
    public static Color getPaddleColour()
    {
        return paddleColour;
    }
}
