/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Draws a 10x10 Grid
 * @author tagroebe
 */
public class GridPanel extends JPanel implements MouseListener, MouseMotionListener{
    private int width;
    private int height;
    private int highlightX = -1;
    private int highlightY = -1;
    private int lengthOfCurrentShip = 4;
    
    public GridPanel(int width, int height){
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width,height));
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    
    
    @Override
    public void paint(Graphics g) {        
        super.paint(g); // paint background
        g.setColor(Color.blue);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == highlightX && j == highlightY) {
                    g.setColor(new Color(0,120,200));
                    g.fillRect(i*(width/10)+1, j*(height/10)+1, width/10-2, height/10-2);    
                    g.setColor(Color.blue);
                }
                else{
                    g.fillRect(i*(width/10)+1, j*(height/10)+1, width/10-2, height/10-2);
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    
    //Hightlights the cell over which the mouse is
    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getY() + " / " + e.getX());
        this.highlightX = e.getX();
        this.highlightY = e.getY();
        
        //Conevert numbers of pixels to cell-numbers
        int cellCount = 0;
        while(highlightX > (width/10) -1){
            highlightX = highlightX - (width/10);     
            cellCount++;
        }
        highlightX = cellCount;
        
        cellCount = 0;
        while(highlightY > (height/10) -1){
            highlightY = highlightY - (height/10);     
            cellCount++;
        }
        highlightY = cellCount;        
        repaint();
    }

    
    //Stop highlighting when mouse leaves Board
    @Override
    public void mouseExited(MouseEvent e) {
        highlightX = -1;
        highlightY = -1;
        repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    
    //Not needed
    @Override
    public void mousePressed(MouseEvent e) {       
    }
    @Override
    public void mouseReleased(MouseEvent e) {       
    }
    @Override
    public void mouseEntered(MouseEvent e) {     
    }



}
