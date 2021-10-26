package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canva extends JPanel {
    private final JTextField pathFile = new JTextField();
    private final JButton readButton = new JButton();
    private final JButton countPercentage = new JButton();
    private BufferedImage imageJPG;
    private final JPGService jpgService;
    private final ImageAnalyzer imageAnalyzer;
    private final JSlider slider = new JSlider(0,15);
    private final JTextField numberOfColor = new JTextField();




    Canva()
    {
        setButtons();
        jpgService = new JPGService();
        imageAnalyzer = new ImageAnalyzer();
    }

    private void setButtons() {
        readButton.addActionListener(e -> readFile(pathFile.getText()));
        readButton.setText("Read");
        readButton.setBounds(30, 530, 100, 25);
        pathFile.setBounds(30, 500, 100, 25);

        slider.setBounds(200, 500, 200, 25);
        numberOfColor.setBounds(420, 500, 100, 25);
        slider.addChangeListener(e-> numberOfColor.setText(String.valueOf(slider.getValue())));
        countPercentage.setBounds(150, 530, 100, 25);
        countPercentage.setText("Count");
        countPercentage.addActionListener(e->countPercentageOfColor());

        this.setLayout(null);

        this.add(slider);
        this.add(numberOfColor);
        this.add(countPercentage);
        this.add(pathFile);
        this.add(readButton);
    }

    private void countPercentageOfColor() {
        double result = imageAnalyzer.countPercentage(imageJPG,slider.getValue());
        System.out.println(result);
    }

    private void readFile(String text) {
        imageJPG = jpgService.readJPG(text);

        NewWindow window = new NewWindow(imageJPG);
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        BufferedImage img =jpgService.readJPG("pb");
        g.drawImage(img, 0, 0, this);
        this.repaint();
    }

}
