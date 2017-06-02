/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flapper;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Simple clone of Flappy Bird.
 * Inspiration and some code taken from https://www.youtube.com/watch?v=I1qTZaUcFX0
 *
 * @author Maria
 */
public class Flapper implements ActionListener, MouseListener, KeyListener {

    /**
     * @param args the command line arguments
     */
    public static Flapper flapper;
    public final int frameWidth = 1200, frameHeight = 800;
    public Renderer renderer;
    public Rectangle bird;
    public boolean gameOver, gameStarted;
    public ArrayList<Rectangle> columns;
    public Random rand;
    public int ticks, yMotion, score;

    public Flapper() {
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);

        renderer = new Renderer();
        rand = new Random();

        jframe.add(renderer);
        jframe.setTitle("Flapper");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(frameWidth, frameHeight);
        jframe.addMouseListener(this);
        jframe.addKeyListener(this);
        jframe.setResizable(false);
        jframe.setVisible(true);

        bird = new Rectangle(frameWidth / 2 - 10, frameHeight / 2 - 10, 20, 20);
        columns = new ArrayList<Rectangle>();

        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);

        timer.start();
    }

    //adds randomly generated columns to the ArrayList columns
    public void addColumn(boolean start) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        if (start) {
            columns.add(new Rectangle(frameWidth + width + columns.size() * 300, frameHeight - height - 120, width, height));
            columns.add(new Rectangle(frameWidth + width + (columns.size() - 1) * 300, 0, width, frameHeight - height - space));
        } else {
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, frameHeight - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, frameHeight - height - space));
        }
    }

    public void paintColumn(Graphics g, Rectangle column) {
        g.setColor(Color.decode("#006600"));
        g.fillRect(column.x, column.y, column.width, column.height);
    }

    public void repaint(Graphics g) {
        //background colour
        g.setColor(Color.black);
        g.fillRect(0, 0, frameWidth, frameHeight);

        //ground colour
        g.setColor(Color.decode("#b33c00"));
        g.fillRect(0, frameHeight - 120, frameWidth, 120);

        //grass colour
        g.setColor(Color.green);
        g.fillRect(0, frameHeight - 120, frameWidth, 20);

        //bird colour
        g.setColor(Color.yellow);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        //column colour
        for (Rectangle column : columns) {
            paintColumn(g, column);
        }

        //sets font colour and font type
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma", 1, 100));

        //Selects which string to print based on the status of the game
        if (!gameStarted) {
            g.drawString("Click to start", 250, frameHeight / 2 - 50);
        }

        if (gameOver) {
            g.drawString("Game Over", 300, frameHeight / 2 - 50);
            
            g.setFont(new Font("Tahoma", 1, 50));
            g.drawString("Score = " + score, 450, frameHeight /2 + 20);
            g.drawString("Click to try again", 375, frameHeight /2 + 70);
        }
        if (!gameOver && gameStarted)
        {
            g.drawString(String.valueOf(score), frameWidth / 2 - 25, 100);
        }
    }

    public static void main(String[] args) {
        flapper = new Flapper();
    }

    public void jump() {
        //Changes the game to the game over scenario if actionPerformed changes gameOver to true
        if (gameOver) {
            bird = new Rectangle(frameWidth / 2 - 10, frameHeight / 2 - 10, 20, 20);
            columns.clear();
            yMotion = 0;
            score = 0;

            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);

            gameOver = false;
        }
        //Starts the game if gameStarted is false
        if (!gameStarted) {
            gameStarted = true;
        } else if (!gameOver) {
            if (yMotion > 0) {
                yMotion = 0;
            }
        //Makes bird move as intended by changing yMotion
        yMotion -= 10;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 10;

        ticks++;
        
        if (gameStarted) {
            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                column.x -= speed;
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }

            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);

                if (column.x + column.width < 0) {
                    columns.remove(column);

                    if (column.y == 0) {
                        addColumn(false);
                    }
                }
            }

            bird.y += yMotion;

            //checks for collision and sets gameOver to true if collision
            for (Rectangle column : columns) {
                //adds to the score when the bird is between top and bottom column
                if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - speed
                        && bird.x + bird.width / 2 < column.x + column.width / 2 + speed) {
                    score++;
                }
                
                // Handles what happens if the bird hits the columns
                if (column.intersects(bird)) {
                    gameOver = true;

                    if (bird.x <= column.x)
                    {
                        bird.x = column.x - bird.width;
                    }
                    else if (column.y != 0)
                    {
                        bird.y = column.y - bird.height;
                    }
                    else if (bird.y < column.height)
                    {
                        bird.y = column.height;
                    }
                    
                }
            }
            if (bird.y > frameHeight - 120 || bird.y < 0) {
                gameOver = true;
            }
            if (bird.y + yMotion >= frameHeight - 120) {
                bird.y = frameHeight - 120 - bird.height;
            }
        }
        renderer.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            jump();
        }
    }

}
