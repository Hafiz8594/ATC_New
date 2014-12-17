/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ats.framework;

import ats.objects.Plane;
import ats.window.Handler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Hafiz
 */
public class KeyInput extends KeyAdapter {
    
    Handler handler;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);
            
            // Checks if certain objects is a player
            if(tempObject.getId() == ObjectId.Plane)
            {
                if(key == KeyEvent.VK_RIGHT){ // plane is moving forward
                    //tempObject.setVelX(5);
                    ((Plane)tempObject).increaseSpeed();
                }
                if(key == KeyEvent.VK_LEFT){                    
                    //tempObject.setVelX(-5);
                    if(((Plane)tempObject).getVelX() > 8f){
                        ((Plane)tempObject).decreaseSpeed();
                    }
                }
                if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                if(key == KeyEvent.VK_SPACE && !tempObject.isJumping())
                {
                    tempObject.setJumping(true);
                    tempObject.setVelY(-10);
                }
            }
        }
        
        if(key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);
            
            // Checks if certain objects is a player
            if(tempObject.getId() == ObjectId.Plane){
                if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
            }
        }
    }
}
