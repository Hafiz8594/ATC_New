package ats.window;

import ats.framework.GameObject;
import ats.framework.KeyInput;
import ats.framework.ObjectId;
import ats.framework.Texture;
import ats.objects.Block;
import ats.objects.Flag;
import ats.objects.Player;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Hafiz
 */
public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Thread thread;
    
    public static int WIDTH, HEIGHT;
    
    public BufferedImage level = null, clouds = null;
    
    // Object
    Handler handler;
    Camera cam;
    static Texture tex;
    
    Random rand = new Random();
    
    public static int LEVEL = 1;
    
    private void init() 
    {
        WIDTH = getWidth();
        HEIGHT = getHeight();
        
        tex = new Texture();
        
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/level.png"); // loading the level
        clouds = loader.loadImage("/bkg_clouds.png"); // Loading Background
        
        cam = new Camera(0, 0);
        handler = new Handler(cam);
        
        handler.loadImageLevel(level);
        
        /**
         * This is where objects are added to the game the the
         * createLevel() method is called to populate the level
         */
        //handler.addObject(new Player(100, 100, handler, ObjectId.Player));
        
        //handler.createLevel();
        
        this.addKeyListener(new KeyInput(handler));
        
        requestFocus();
    }
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >= 1){
                        tick();
                        updates++;
                        delta--;
                }
                render();
                frames++;

                if(System.currentTimeMillis() - timer > 1000){
                        timer += 1000;
                        System.out.println("FPS: " + frames + " TICKS: " + updates);
                        frames = 0;
                        updates = 0;
                }
        }
    }
    
    private void tick() {
        handler.tick();
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ObjectId.Player)
              cam.tick(handler.object.get(i));  
        }
    }
    private void render() 
    {        
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        
        // We want to start drawing everything in our game here
        
        g.setColor(new Color(148, 220, 227));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //g.drawImage(clouds, 0, 0, this); // Static Clouds
        
        g2d.translate(cam.getX(), cam.getY()); // begin of cam
        for(int xx = 0; xx < clouds.getWidth() * 3; xx += clouds.getWidth()){ // Moving clouds
            g.drawImage(clouds, xx, 0, this);
        }
        handler.render(g);
        
        g2d.translate(-cam.getX(), -cam.getY()); // end of cam
        
        
        // We want to stop drawing everything in our game here
        g.dispose();
        bs.show();
    }
    

    
    public static Texture getInstance(){
        return tex;
    }
    
    public static void main(String[] args) {
        new Window(800, 600, "ATS Prototype", new Game());
    }
    
}
