package com.company;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Canva extends JPanel {
    private final JTextField pathFile = new JTextField();
    private final JButton readButton = new JButton();
    private final JButton countPercentage = new JButton();
    private BufferedImage imageJPG;
    private final JPGService jpgService;
    private final ImageAnalyzer imageAnalyzer;


    Canva()
    {
        setButtons();
        jpgService = new JPGService();
        imageAnalyzer = new ImageAnalyzer();
    }

    private void setButtons() {
        readButton.addActionListener(e -> readFile(pathFile.getText()));
        readButton.setText("Read");
        readButton.setBounds(30, 730, 100, 25);
        pathFile.setBounds(30, 700, 100, 25);

        countPercentage.setBounds(150, 730, 100, 25);
        countPercentage.setText("Count");
        countPercentage.addActionListener(e->countPercentageOfColor());

        this.setLayout(null);

        this.add(countPercentage);
        this.add(pathFile);
        this.add(readButton);
    }

    private void countPercentageOfColor() {
        double result = imageAnalyzer.countPercentage(imageJPG);
        System.out.println(result);
    }

    private void readFile(String text) {
        imageJPG = jpgService.readJPG(text);

        NewWindow window = new NewWindow(imageJPG);
    }

}
