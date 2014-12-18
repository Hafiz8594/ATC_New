package ats.window;

import ats.framework.GameObject;
import ats.framework.ObjectId;
import ats.objects.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Hafiz
 */
public class Handler {
    
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    
    private GameObject tempObject;
    
    public ScoreKeeper keeper;
    
    Plane plane;
    
    private Camera cam;
    
    private BufferedImage level2 = null;
    
    public Handler(Camera cam){
        this.cam = cam;
        
        BufferedImageLoader loader = new BufferedImageLoader();
        level2 = loader.loadImage("/level2.png"); // loading the level
    }
    
    public void tick()
    {
        for(int i = 0; i < objects.size(); i++)
        {
            tempObject = objects.get(i);
            tempObject.tick(objects);
        }
    }
    
    public void render(Graphics g)
    {
        for(int i = 0; i < objects.size(); i++)
        {
            tempObject = objects.get(i);
            tempObject.render(g);
        }
    }
    
    public void loadImageLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        
        System.out.println("width, height: " + w + " " + h);
        
        for(int xx = 0; xx < h; xx++){
            for(int yy = 0; yy < w; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red == 255 & green == 255 && blue == 255) // Checks for blocks
                    addObject(new Block(xx*32, (yy)*32, 0, ObjectId.Block));
                if(red == 0 & green == 38 && blue == 255){ // Checks for plane
                    plane = new Plane(xx*32, yy*32, this, cam, ObjectId.Plane);
                    addObject(plane);
                    this.keeper = new ScoreKeeper(plane);
                }
                if(red == 255 & green == 0 && blue == 110) // Checks for Flyer
                    addObject(new Flyer(xx*32, yy*32, this, cam, ObjectId.Flyer));
                if(red == 255 & green == 106 && blue == 0) // Checks for Storm
                    addObject(new Storm(xx*32, yy*32, this, cam, ObjectId.Storm));
                if(red == 255 & green == 216 && blue == 0) // Checks for Flag
                    addObject(new Flag(xx*32, yy*32, ObjectId.Flag));
            }
        }
    }
       
    public void switchLevel(){
        clearLevel();
        cam.setX(0);
        
        switch(Game.LEVEL)
        {
            case 1:
                System.exit(0);

                //break;
        }
        
        Game.LEVEL++;
    }
    
    private void clearLevel(){
        objects.clear();
    }
    
    public void addObject(GameObject object){
        this.objects.add(object);
    }
    
    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
    
    /**
     * This is where the blocks and other objects for the given level are laid out
     * Currently, the dimensions of each game block are 32x32
     */
//    public void createLevel()
//    {
//        // left
//        for(int yy = 0; yy < Game.HEIGHT+32; yy+=32)
//            addObject(new Block(0, yy, ObjectId.Block));
//        
//        // bottom
//        for(int xx = 0; xx < Game.WIDTH*2; xx+=32)
//            addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
//        
//        // This code creates the blocks towards the center of the screen
//        for(int i = Game.WIDTH/4; i < (Game.WIDTH/1.5)+32; i+=32){
//            addObject(new Block(i, Game.HEIGHT-192, ObjectId.Block));
//        }
//        
//    }
    
}
