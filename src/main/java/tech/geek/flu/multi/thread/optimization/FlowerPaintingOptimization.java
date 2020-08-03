package tech.geek.flu.multi.thread.optimization;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FlowerPaintingOptimization {
    public static void main(String[] args) throws IOException {
       try {
           BufferedImage originalImage = ImageIO.read(new File(Utility.SOURCE_FILE));
           BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

           Utility.recolorSingleThreaded(originalImage, resultImage);
           File outFile = new File(Utility.DESTINATION_FILE);
           ImageIO.write(resultImage, "jpg", outFile);
       }catch (Exception e) {
           e.printStackTrace();
       }
    }
}
