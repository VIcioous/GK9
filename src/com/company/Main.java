package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Green Percentage");
        f.setSize(600, 600);
        f.setLocation(300, 300);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new Canva();

        f.add(panel);
        f.setVisible(true);
    }
}
