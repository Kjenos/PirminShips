/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author tagroebe
 */
public class StartView extends JFrame{
   
    private JLabel titleLabel = new JLabel("PirminShips : The Game",SwingConstants.CENTER);
    private JButton onePlayerButton = new JButton("1 Player");
    private JButton twoPlayersButton = new JButton("2 Players");    
    
    public StartView(){
        super("PirminShips");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 20)); 
        titleLabel.setPreferredSize(new Dimension(320,100));

        add(titleLabel);
        add(onePlayerButton);
        add(twoPlayersButton);
        
        setSize(320,240);
    }
    
    public void addPlayerModeListener(ActionListener actionListener){
        onePlayerButton.addActionListener(actionListener);
        twoPlayersButton.addActionListener(actionListener);
    }
}
