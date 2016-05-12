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
public class SearchOpponentView extends JFrame {
    private JLabel titleLabel;
    private JTextField ipTextField;
    private JButton searchButton;
    private JButton backButton;
    
    public SearchOpponentView(){
        super("PirminShips");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        titleLabel = new JLabel("Enter the IP Address of your opponent:");
        ipTextField = new JTextField();
        ipTextField.setPreferredSize(new Dimension(280,20));
        searchButton = new JButton("Search");
        backButton = new JButton("Back");
        
        add(titleLabel);
        add(ipTextField);
        add(backButton);        
        add(searchButton);
        
        setSize(320,130);
    }
    
    public void addBackToMenuListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }
}
