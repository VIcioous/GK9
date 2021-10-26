package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageAnalyzer {
    private final Color[] colors = new Color[]{
            new Color(247, 251, 252),
            new Color(249, 230, 198),
            new Color(121, 119, 122),
            new Color(67, 43, 43),
            new Color(244, 201, 34),
            new Color(236, 103, 8),
            new Color(226, 8, 22),
            new Color(107, 21, 56),
            new Color(77, 127, 74),
            new Color(0, 133, 98),
            new Color(1, 151, 124),
            new Color(33, 59, 60),
            new Color(0, 137, 192),
            new Color(0, 85, 126),
            new Color(214, 222, 225),
            new Color(214, 222, 225),
            new Color(12, 14, 11),

    };


    public double countPercentage(BufferedImage image, int value) {

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
                if(pixel.equals(colors[value])) greenPixels++;
            }
        }
        double total = ((double) greenPixels*100/totalPixels) ;

        NewWindow window = new NewWindow(image);

        return total;
    }
}
