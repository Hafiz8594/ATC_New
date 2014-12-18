package ats.window;

import ats.objects.Plane;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hafiz
 */
public class ScoreKeeper extends JPanel {
    
    private Plane plane;
    private int score, speed, alt;
    
    public ScoreKeeper(Plane plane){
        this.plane = plane;
        this.score = 100;
    }
    
    public int getScore(){
        return this.score;
    }    
    
    public float getSpeed(){
        return plane.getVelX();
    } 
    
    public float getAlt(){
        return plane.getY();
    }
    
    
}
