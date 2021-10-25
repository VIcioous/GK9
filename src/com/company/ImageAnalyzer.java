package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageAnalyzer {
    private final Color[] colors = new Color[]{
            new Color(110, 111, 115),
            new Color(69, 88, 69),
            new Color(82, 148, 245),
            Color.orange,
            new Color(190, 144, 120),
            Color.pink,
            Color.BLACK,
            Color.WHITE,
    };


    public double countPercentage(BufferedImage image) {

        int totalPixels = image.getHeight()* image.getWidth();
        int greenPixels = 0;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color pixel = new Color(image.getRGB(x, y));
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();
                Color newColor = null;
                double lowestDistance = 255;
                for (Color color : colors) {
                    double distance = Math.sqrt(
                            Math.pow(r - color.getRed(), 2) +
                                    Math.pow(g - color.getGreen(), 2) +
                                    Math.pow(b - color.getBlue(), 2)
                    );
                    if (distance < lowestDistance) {
                        lowestDistance = distance;
                        newColor = color;
                    }
                }
                assert newColor != null;
                int c =(newColor.getRed() << 16) | (newColor.getGreen() << 8) |newColor.getBlue();
                image.setRGB(x,y,c);
            }
        }

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color pixel = new Color(image.getRGB(x, y));
                if(pixel.equals(colors[1])) greenPixels++;
            }
        }
        double total = ((double) greenPixels*100/totalPixels) ;

        NewWindow window = new NewWindow(image);

        return total;
    }
}
