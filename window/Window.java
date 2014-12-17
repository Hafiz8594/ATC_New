package ats.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hafiz
 */
public class Window {
    
    
    public Window(String title, Game game){
        
//        game.setPreferredSize(new Dimension(w, h));
//        game.setMaximumSize(new Dimension(w, h));
//        game.setMinimumSize(new Dimension(w, h));
        
        JFrame frame = new JFrame(title);
        
        // Deals with status bar found at bottom of screen
                
        JPanel statusBar = new JPanel(); // score, speed, etc
        JLabel score = new JLabel("Score: 100");
        JLabel speed = new JLabel("Speed: 100km/h");
        JLabel alt = new JLabel("Altitude: 100ft");
        //score.setForeground(Color.white);
        statusBar.add(score);
        statusBar.add(speed);
        statusBar.add(alt);
        //panel.add(game);
        //frame.add(game);

        frame.getContentPane().add(game);
        frame.getContentPane().add(statusBar, BorderLayout.PAGE_END);
        
        JButton button = new JButton("Long-Named Button 4 (PAGE_END)");
        JButton button2 = new JButton("Long-Named Button 4 (PAGE_END)");
        //frame.getContentPane().add(button, BorderLayout.PAGE_END);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        
        game.start();
    }
    
}
