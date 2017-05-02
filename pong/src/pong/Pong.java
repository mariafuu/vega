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
     * Deklarerer vinner og lukker spillet.
     * 
     * @param   winner  Nummeret pÃ¥ spilleren som vant
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
     * Returnerer bredden pÃ¥ JFrame
     * 
     * @return pWidth   int
     */
    public static int getPWidth()
    {
        return pWidth;
    }
    
    /**
     * Returnerer hÃ¸yden pÃ¥ JFrame
     * 
     * @return pHeight   int
     */
    public static int getPHeight()
    {
        return pHeight;
    }
    
    /**
     * Returnerer bakgrunnsfargen
     * 
     * @return bgColour   Color
     */
    public static Color getBGColour()
    {
        return bgColour;
    }
    
    /**
     * Returnerer fargen for ballen
     * 
     * @return ballColour   Color
     */
    public static Color getBallColour()
    {
        return ballColour;
    }
    
    /**
     * Returnerer fargen for paddles
     * 
     * @return paddleColour   Color
     */
    public static Color getPaddleColour()
    {
        return paddleColour;
    }
}
