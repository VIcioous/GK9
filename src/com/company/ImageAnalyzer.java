package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageAnalyzer {
    QuantizationService quantizationService = new QuantizationService();

    public BufferedImage countPercentage(BufferedImage image) {

        int totalPixels = image.getHeight()* image.getWidth();
        int greenPixels=0;



        for (int y =0; y< image.getHeight();y++)
        {
            for (int x=0;x< image.getWidth();x++)
            {
                Color pixel = new Color(image.getRGB(x,y));
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

                if(r==0) r=1;
                if(b==0) b=1;

                if(g>50) {
                    double GRRatio = (double) g/r;
                    double GBRatio = (double) g/b;

                    if(GRRatio>1.1&&GBRatio>1.10) greenPixels++;
                }
            }
        }

        double result = ((double) greenPixels/totalPixels)*100;

        return quantizationService.quantizeImage(image);
    }
}
