package ats.framework;

import java.awt.image.BufferedImage;

/**
 *
 * @author Hafiz
 */
public class SpriteSheet {
    
    private BufferedImage image;
    
    // Pass sprite sheet as parameter
    public SpriteSheet(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = image.getSubimage((col*width)-width, (row*height)-height, width, height);
        return img;
    }
    
}
