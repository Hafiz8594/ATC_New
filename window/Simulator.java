package ats.window;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Hafiz
 */
public class Simulator {
    
   
    public static void main(String[] args) {
        
        Game game = new Game();
        
        new Window("ATS Prototype", game);

    }
    
}
