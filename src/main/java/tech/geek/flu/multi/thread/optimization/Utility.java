package tech.geek.flu.multi.thread.optimization;

import java.awt.image.BufferedImage;

public class Utility {

    public static final String SOURCE_FILE = "/Users/vn04q89/Documents/MultiThread/src/main/resources/many-flowers.jpg";
    public static final String DESTINATION_FILE = "/Users/vn04q89/Documents/MultiThread/src/main/resources/out/many-flowers-altered.jpg";

    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb) {
        return (rgb & 0x000000FF);
    }

    public static int createRGBFromColors(int red, int green, int blue) {
        int rgb = 0;
        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        rgb |= 0XFF000000;

        return rgb;
    }

    public static boolean isShadeGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static void recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y) {
        int rgb = originalImage.getRGB(x, y);
        int red = Utility.getRed(rgb);
        int green = Utility.getGreen(rgb);
        int blue = Utility.getBlue(rgb);

        int nRed, nGreen, nBlue;

        if(Utility.isShadeGray(red, green, blue)) {
            nRed = Math.min(255, red + 10);
            nGreen = Math.max(0, green - 80);
            nBlue = Math.max(0, blue - 20);
        } else {
            nRed = red;
            nGreen = green;
            nBlue = blue;
        }
        int nRGB = createRGBFromColors(nRed, nGreen, nBlue);
        setRGB(resultImage, x, y, nRGB);

    }

    public static void recolorSingleThreaded(BufferedImage original, BufferedImage destination) {
        recolorImage(original, destination, 0, 0, original.getWidth(), original.getHeight());
    }

    public static void setRGB(BufferedImage bufferedImage, int x, int y, int rgb) {
        bufferedImage.getRaster().setDataElements(x, y, bufferedImage.getColorModel().getDataElements(rgb, null));
    }

    public static void recolorImage(BufferedImage originalImage, BufferedImage destinationImage, int leftCorner, int topCorner, int width, int height) {
        for (int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++) {
            for (int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y++) {
                recolorPixel(originalImage, destinationImage, x, y);
            }
        }
    }
}
