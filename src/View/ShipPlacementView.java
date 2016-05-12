/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author tagroebe
 */
public class ShipPlacementView extends JFrame{    
    private Board board;
    
    private JLabel titleLabel;
    
    private GridPanel gridPanel;
    
    private JPanel instructionsPanel;
    private JLabel instructionsTitle;
    private JTextArea instructionsTextArea;
    private JLabel numberOfShipsSize4;
    private JLabel numberOfShipsSize3;
    private JLabel numberOfShipsSize2;
    private JLabel numberOfShipsSize1;
   
    private JPanel buttonPanel;
    private JButton backButton;
    private JButton continueButton;
    private JButton resetButton;
    private JButton randomizeButton;
    
    public ShipPlacementView()
    {
        super("PirminShips");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024,768);
        setLayout(new FlowLayout());
        setResizable(false);

        
        //Lightweight Komponenten erstellen
        
        //Create Title
        titleLabel = new JLabel("Place your ships!",SwingConstants.LEFT);
        titleLabel.setPreferredSize(new Dimension(1024,120));
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 15));
        
        
        //Create Grid to place ships
        gridPanel = new GridPanel(480,480);
        
        //Create Area with instructions
        instructionsPanel = new JPanel();
        instructionsPanel.setPreferredSize(new Dimension(480,480));
        
        instructionsTitle = new JLabel("Instructions");
        instructionsTitle.setFont(new Font("Verdana", Font.BOLD, 16));
        
        instructionsTextArea = new JTextArea("Click once to set the position of your ship." +
            System.lineSeparator() + "Click a second time to set the direction your ship is facing." + System.lineSeparator() + System.lineSeparator() +
            "You can place the the following ships in the order they are listed:");
        instructionsTextArea.setMargin(new Insets(10,10,10,10));
        instructionsTextArea.setPreferredSize(new Dimension(480,100));        
        instructionsTextArea.setEditable(false);
        
        numberOfShipsSize4 = new JLabel("1x Big Fucking Ship (4 fields long)");
        numberOfShipsSize4.setPreferredSize(new Dimension(480,30));
        numberOfShipsSize4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        numberOfShipsSize4.setForeground(new Color(0, 160, 80));
        
        numberOfShipsSize3 = new JLabel("2x Still Pretty Big Ship (3 fields long)");
        numberOfShipsSize3.setPreferredSize(new Dimension(480,30));
        numberOfShipsSize3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        numberOfShipsSize2 = new JLabel("3x Small Ship (2 fields long)");
        numberOfShipsSize2.setPreferredSize(new Dimension(480,30));
        numberOfShipsSize2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        numberOfShipsSize1 = new JLabel("2x Ship Small AF (1 field long)");
        numberOfShipsSize1.setPreferredSize(new Dimension(480,30));
        numberOfShipsSize1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        instructionsPanel.add(instructionsTitle);
        instructionsPanel.add(instructionsTextArea);
        instructionsPanel.add(numberOfShipsSize4);
        instructionsPanel.add(numberOfShipsSize3);
        instructionsPanel.add(numberOfShipsSize2);
        instructionsPanel.add(numberOfShipsSize1);
        
        //Creates Buttons 
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setPreferredSize(new Dimension(480,200));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(165,0,0,0));
        backButton = new JButton("Cancel Match");
        resetButton = new JButton("Reset");
        randomizeButton = new JButton ("Randomize");
        continueButton = new JButton("Ready!");
        
        
        buttonPanel.add(backButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(randomizeButton);
        buttonPanel.add(continueButton);
        instructionsPanel.add(buttonPanel);
        
        
        add(titleLabel);
        add(gridPanel);
        add(instructionsPanel);

    }
    
    
    public void addBackToMenuListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }
    
}
