package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Handles most of the game logic
 * 
 * @author Maria
 * @version 2
 */
public class PongPanel extends JPanel implements ActionListener, KeyListener
{
    // instance variables
    private Ball ball;
    private Timer timer;
    private Paddle player1;
    private Paddle player2;
    private static int score1;
    private static int score2;
    private boolean up = false;
    private boolean down = false;
    private boolean w = false;
    private boolean s = false;
    private int upSpeed = -10;
    private int downSpeed = 10;

    /**
     * Constructor for objects of class PongPanel
     */
    public PongPanel()
    {
        // initialise instance variables
        setBackground(Pong.getBGColour());
        setFocusable(true);
        setSize(Pong.getPWidth(), Pong.getPHeight());
        requestFocusInWindow();
        setOpaque(true);
        score1 = 0;
        score2 = 0;
        addKeyListener(this);
        
        ball = new Ball();
        player1 = new Paddle(1);
        player2 = new Paddle(2);
        
        start();
        timer = new Timer(1000 / 60, this);
        timer.start();
    }

    /**
     * Makes to paddles, one for player 1 and one for player 2
     */
    public void start()
    {
        
    }
    
    /**
     * Updates the game and decide whether the paddles should move and runs
     * check collision to check it the ball hits a paddle
     */
    public void update()
    {
        ball.move();
        if (up)
        {
            player1.setYSpeed(upSpeed);
        }
        else if (down)
        {
            player1.setYSpeed(downSpeed);
        }
        else
        {
            player1.setYSpeed(0);
        }
        
        if (w)
        {
            player2.setYSpeed(upSpeed);
        }
        else if (s)
        {
            player2.setYSpeed(downSpeed);
        }
        else
        {
            player2.setYSpeed(0);
        }
        player1.move();
        player2.move();
        
        ball.checkCollision(player1);
        ball.checkCollision(player2);
        
        checkScore();
    }
    
    /**
     * Register if relevant buttons are pressed
     * 
     * @param   e   event variable
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            w = true;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            s = true;
        }
    }

    /**
     * Registers when the relevant buttons are released
     * 
     * @param   e   eventvariable
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            w = false;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            s = false;
        }
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) { }
    
    /**
     * Checks what the score is and calls endGame if a player has won
     */
    public void checkScore()
    {
        if (score1 == 10)
        {
            Pong.endGame(1);
        }
        else if (score2 == 10)
        {
            Pong.endGame(2);
        }
    }
    
    /**
     * Increases the score of Player 1
     */
    public static void setScore1()
    {
        score1++;
    }
    
    /**
     * Increases the score of Player 2
     */
    public static void setScore2()
    {
        score2++;
    }
    
    /**
     * Returns the score of Player 1
     * 
     * @return  score1  int
     */
    public static int getScore1()
    {
        return score1;
    }
    
    /**
     * Returns the score of Player 2
     * 
     * @return  score2  int
     */
    public static int getScore2()
    {
        return score2;
    }
    
    /**
     * Runs update and repaint every time the timer runs
     * 
     * @param   e   event variable
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        update();
        repaint();
    }
    
    /**
     * Paints the ball and the paddles
     * 
     * @param   g   graphics variable
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ball.paintBall(g);
        player1.paintPaddle(g);
        player2.paintPaddle(g);
    }
}
