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

/**
 *
 * @author Hafiz
 */
public class Player extends GameObject {

    private float width = 48, height = 96;
    
    private float gravity = 0.5f;
    private final float MAX_SPEED = 10;
    
    private Handler handler;
    private Camera cam;
    
    Texture tex = Game.getInstance();
    
    public Player(float x, float y, Handler handler, Camera cam, ObjectId id){
        super(x, y, id);
        this.handler = handler;
        this.cam = cam;
    }
    
    @Override
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;
        
        if(falling || jumping)
        {
            velY += gravity;
            if(velY > MAX_SPEED)
                velY = MAX_SPEED;
        }
        Collision(object);
    }
    
    private void Collision(LinkedList<GameObject> object){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
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
                    handler.switchLevel();
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {      
        g.setColor(Color.blue);
        g.drawImage(tex.player[0], (int)x, (int)y, 48, 96, null);
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
