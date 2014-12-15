package ats.objects;

import ats.framework.ObjectId;
import ats.framework.GameObject;
import ats.framework.Texture;
import ats.window.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author Hafiz
 */
public class Block extends GameObject 
{
    
    Texture tex = Game.getInstance();
    private int type;
    
    public Block(float x, float y, int type, ObjectId id){
        super(x, y, id);
        this.type = type;
    }
    
    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        if(type == 0) // Grass block
            g.drawImage(tex.block[0], (int)x, (int)y, null);
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    
}
