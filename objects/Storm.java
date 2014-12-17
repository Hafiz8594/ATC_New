package ats.objects;

import ats.framework.GameObject;
import ats.framework.ObjectId;
import ats.framework.Texture;
import ats.window.Camera;
import ats.window.Game;
import ats.window.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Hafiz
 */
public class Storm extends GameObject {
    
    private float width = 250, height = 255;
    
    private float gravity = 0f;
    private final float MAX_SPEED = 50;
    private boolean isMovingForward = false;
    
    private Handler handler;
    private Camera cam;
    
    Texture tex = Game.getInstance();
    
    public Storm(float x, float y, Handler handler, Camera cam, ObjectId id){
        super(x, y, id);
        this.handler = handler;
        this.cam = cam;
    }
    
    public void setMotion(boolean b){
        this.isMovingForward = b;
    }
    
    @Override
    public void tick(LinkedList<GameObject> object) {
        Collision(object);
    }
       
    private void Collision(LinkedList<GameObject> object){
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);
            
            if(tempObject.getId() == ObjectId.Block)
            {
                // This code deals with top collision
                if(getBoundsTop().intersects(tempObject.getBounds())){
                    y = tempObject.getY() + 32;
                    velY = 0;
                }
                
                // This code deals with bottom collision
                if(getBounds().intersects(tempObject.getBounds())){
                    y = tempObject.getY() - height;
                    velY = 0;
                    falling = false;
                    jumping = false;
                } else 
                    falling = true;
                
                if(getBoundsRight().intersects(tempObject.getBounds())){
                    x = tempObject.getX() - width;
                }
                
                if(getBoundsLeft().intersects(tempObject.getBounds())){
                    x = tempObject.getX() + 35;
                }
            } else if(tempObject.getId() == ObjectId.Flag){
                // Switch level (Or in our case, level has endeed)
                if(getBounds().intersects(tempObject.getBounds())){

                }
            }
        }
    }
    
    // Where the plane is actually drawn onto the window
    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        
        // Draws a big blue rectangle in case we need it
//        g.fillRect((int)x, (int)y, (int)width, (int)height);
        
        g.drawImage(tex.storm[0], (int)x, (int)y, 250, 255, null);
        
//        // This shows our collision bounds
//        Graphics2D g2d = (Graphics2D)g;
//        g.setColor(Color.red);
//        g2d.draw(getBounds());
//        g2d.draw(getBoundsTop());
//        g2d.draw(getBoundsRight());
//        g2d.draw(getBoundsLeft());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
    }
    
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
    }
    
}
