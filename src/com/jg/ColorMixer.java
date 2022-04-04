package com.jg;

import javax.swing.*;
import java.awt.*;

public class ColorMixer extends JFrame {
    public ColorMixer() {
        this.setTitle("Color Mixer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(650, 440);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        this.setLayout(new FlowLayout());

        ColorPanel colorPanel = new ColorPanel();

        this.add(colorPanel.getRightPanel());
        this.add(colorPanel.getLeftPanel());
        this.pack();
    }
}
