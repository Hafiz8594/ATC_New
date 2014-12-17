package ats.framework;

import ats.window.BufferedImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hafiz
 */
public class Texture {
    
    SpriteSheet bs, ps, as, fs, ss;
    private BufferedImage block_sheet = null;
    private BufferedImage player_sheet = null;
    private BufferedImage plane_sheet = null;
    private BufferedImage flyer_sheet = null;
    private BufferedImage storm_sheet = null;
    
    public BufferedImage[] block = new BufferedImage[2];
    public BufferedImage[] player = new BufferedImage[1];
    public BufferedImage[] plane = new BufferedImage[1];
    public BufferedImage[] flyer = new BufferedImage[1];
    public BufferedImage[] storm = new BufferedImage[1];
    
    public Texture(){
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            block_sheet = loader.loadImage("/runway.png");
            player_sheet = loader.loadImage("/player_sheet.png");
            plane_sheet = loader.loadImage("/plane.png");
            flyer_sheet = loader.loadImage("/flyer.png");
            storm_sheet = loader.loadImage("/storm.png");
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        bs = new SpriteSheet(block_sheet);
        ps = new SpriteSheet(player_sheet);
        as = new SpriteSheet(plane_sheet);
        fs = new SpriteSheet(flyer_sheet);
        ss = new SpriteSheet(storm_sheet);
        getTextures();
    }
    
    private void getTextures(){
        block[0] = bs.grabImage(1, 1, 32, 32); // grass block
        player[0] = ps.grabImage(1, 1, 32, 64); // idle frame
        /**
         * The other two images are being generated using sheets,
         * but I don't know if you can straight-up load an image
         * for this one.
         */
        plane[0] = as.grabImage(1, 1, 251, 106);
        flyer[0] = fs.grabImage(1, 1, 154, 106);
        storm[0] = ss.grabImage(1, 1, 250, 255);
    }
}
