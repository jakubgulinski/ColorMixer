package com.jg;

import javax.swing.*;
import java.awt.*;

public class TopRectangle {
    private final JPanel panel, InnerPanel;
    private final Color color;

    public TopRectangle() {
        this.color = new Color(100, 100, 100);
        this.panel = new JPanel();
        this.InnerPanel = new JPanel();
        buildPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getInnerPanel() {
        return InnerPanel;
    }

    private void buildPanel() {
        panel.setPreferredSize(new Dimension(180, 180));
        panel.setBackground(color);
        panel.setBorder(BorderFactory.createEmptyBorder(35, 40, 45, 40));

        InnerPanel.setPreferredSize(new Dimension(100, 100));
        InnerPanel.setBackground(color);
        panel.add(InnerPanel);

    }

}
