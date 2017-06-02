/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flapper;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 *
 * @author Maria
 */
public class Renderer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Flapper.flapper.repaint(g);
    }

}
