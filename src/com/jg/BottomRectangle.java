package com.jg;

import javax.swing.*;
import java.awt.*;

public class BottomRectangle {
    private final JPanel rectanglePanel, topLeftPanel, topRightPanel, bottomLeftPanel, bottomRightPanel;
    private final JPanel[] panels;
    private final Color color;

    public BottomRectangle() {
        this.color = new Color(100, 100, 100);
        this.rectanglePanel = new JPanel();
        this.topLeftPanel = new JPanel();
        this.topRightPanel = new JPanel();
        this.bottomLeftPanel = new JPanel();
        this.bottomRightPanel = new JPanel();
        panels = new JPanel[]{topLeftPanel, topRightPanel, bottomLeftPanel, bottomRightPanel};

        buildPanel();
    }

    public JPanel getRectanglePanel() {
        return rectanglePanel;
    }

    public JPanel getTopLeftPanel() {
        return topLeftPanel;
    }

    public JPanel getTopRightPanel() {
        return topRightPanel;
    }

    public JPanel getBottomLeftPanel() {
        return bottomLeftPanel;
    }

    public JPanel getBottomRightPanel() {
        return bottomRightPanel;
    }

    private void buildPanel() {
        this.rectanglePanel.setPreferredSize(new Dimension(180, 180));
        this.rectanglePanel.setLayout(new GridLayout(2, 2));

        for (JPanel panel : panels) {
            panel.setPreferredSize(new Dimension(45, 45));
            panel.setBackground(color);
            this.rectanglePanel.add(panel);
        }

    }
}
