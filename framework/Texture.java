package ats.framework;

import ats.window.BufferedImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hafiz
 */
public class Texture {
    
    SpriteSheet bs, ps, as;
    private BufferedImage block_sheet = null;
    private BufferedImage player_sheet = null;
    private BufferedImage plane_sheet = null;
    
    public BufferedImage[] block = new BufferedImage[2];
    public BufferedImage[] player = new BufferedImage[1];
    public BufferedImage[] plane = new BufferedImage[1];
    
    public Texture(){
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            block_sheet = loader.loadImage("/block_sheet.png");
            player_sheet = loader.loadImage("/player_sheet.png");
            plane_sheet = loader.loadImage("/plane.png");
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        bs = new SpriteSheet(block_sheet);
        ps = new SpriteSheet(player_sheet);
        as = new SpriteSheet(plane_sheet);
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
    }
}
