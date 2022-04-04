package com.jg;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ColorPanel implements ChangeListener {
    private final JPanel rightPanel, leftPanel;
    private Color color1, color2;
    private List<JSlider> sliders;
    private JTextField textField, textFieldForColor1, textFieldForColor2;
    private TopRectangle topRectangle;
    private BottomRectangle bottomRectangle;

    public ColorPanel() {
        rightPanel = new JPanel();
        leftPanel = new JPanel();
        color1 = new Color(100, 100, 100);
        color2 = new Color(100, 100, 100);
        buildWindow();
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    private void buildWindow() {
        this.topRectangle = new TopRectangle();
        JPanel topRectanglePanel = new JPanel();
        topRectanglePanel.add(topRectangle.getPanel());

        this.bottomRectangle = new BottomRectangle();
        JPanel bottomRectanglePanel = new JPanel();
        bottomRectanglePanel.add(bottomRectangle.getRectanglePanel());

        rightPanel.setPreferredSize(new Dimension(200, 400));
        rightPanel.add(topRectanglePanel, BorderLayout.NORTH);
        rightPanel.add(bottomRectanglePanel, BorderLayout.SOUTH);

        JPanel sliderPanel = buildSlidersPanel();
        JPanel colorPanel = buildColorPanel();
        this.textField = buildTextField();

        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(sliderPanel, BorderLayout.NORTH);
        leftPanel.add(colorPanel, BorderLayout.CENTER);
        leftPanel.add(textField, BorderLayout.SOUTH);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        textFieldForColor1.setText("R: " + sliders.get(0).getValue() +
                " G: " + sliders.get(1).getValue() + " B: " + sliders.get(2).getValue());
        textFieldForColor2.setText("R: " + sliders.get(3).getValue() +
                " G: " + sliders.get(4).getValue() + " B: " + sliders.get(5).getValue());

        color1 = new Color(sliders.get(0).getValue(), sliders.get(1).getValue(), sliders.get(2).getValue());
        color2 = new Color(sliders.get(3).getValue(), sliders.get(4).getValue(), sliders.get(5).getValue());

        topRectangle.getPanel().setBackground(color1);
        topRectangle.getInnerPanel().setBackground(color2);

        bottomRectangle.getTopLeftPanel().setBackground(color1);
        bottomRectangle.getTopRightPanel().setBackground(color2);
        bottomRectangle.getBottomLeftPanel().setBackground(color2);
        bottomRectangle.getBottomRightPanel().setBackground(color1);

        textField.setBackground(color1);
        textField.setForeground(color2);
    }

    private JPanel buildSlidersPanel() {
        JPanel sliderPanel = new JPanel();
        this.sliders = new ArrayList<>();
        Stream.generate(JSlider::new)
                .limit(6)
                .forEach(slider -> {
                    slider.setOrientation(JSlider.VERTICAL);
                    slider.setValue(127);
                    slider.setMinimum(0);
                    slider.setMaximum(255);
                    slider.setPreferredSize(new Dimension(50, 300));
                    slider.setPaintTicks(true);
                    slider.setPaintLabels(true);
                    slider.setMajorTickSpacing(85);
                    slider.setMinorTickSpacing(17);
                    slider.addChangeListener(this);
                    sliders.add(slider);
                    sliderPanel.add(slider);
                });
        return sliderPanel;
    }

    private JPanel buildColorPanel() {
        JPanel colorPanel = new JPanel();
        this.textFieldForColor1 = new JTextField("R: " + sliders.get(0).getValue() +
                " G: " + sliders.get(1).getValue() + " B: " + sliders.get(2).getValue());
        textFieldForColor1.setPreferredSize(new Dimension(195, 30));
        textFieldForColor1.setHorizontalAlignment(JTextField.CENTER);
        textFieldForColor1.setEditable(false);
        this.textFieldForColor2 = new JTextField("R: " + sliders.get(3).getValue() +
                " G: " + sliders.get(4).getValue() + " B: " + sliders.get(5).getValue());
        textFieldForColor2.setPreferredSize(new Dimension(195, 30));
        textFieldForColor2.setHorizontalAlignment(JTextField.CENTER);
        textFieldForColor2.setEditable(false);

        colorPanel.add(textFieldForColor1);
        colorPanel.add(textFieldForColor2);
        return colorPanel;
    }

    private JTextField buildTextField() {
        JTextField textField = new JTextField("Lorem ipsum dolor sit amet.");
        textField.setFont(new Font("Calibri", Font.BOLD, 16));
        textField.setBackground(color1);
        textField.setForeground(color2);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setPreferredSize(new Dimension(400, 60));
        return textField;
    }

}
