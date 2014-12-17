package ats.window;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hafiz
 */
public class StatusBar extends JPanel {
    
    private int score, speed, alt;
    
    public StatusBar(int score, int speed, int alt){
        this.score = score;
        this.speed = speed;
        this.alt = alt;
    }
    
    public void setScore(int score){
        this.score = score;
    }    
    
    public void setSpeed(int speed){
        this.speed = speed;
    } 
    
    public void setAlt(int alt){
        this.alt = alt;
    }
    
    
}
