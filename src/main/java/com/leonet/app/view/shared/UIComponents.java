package com.leonet.app.view.shared;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 * Static methods to create UI components with common behaviours, layouts
 * or colors
 */
public class UIComponents implements Patron {
    public static void marginBottom(JPanel panel) {
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setPreferredSize(new Dimension(0, 0));
        panel.add(temp, BorderLayout.SOUTH);
    }

    public static void marginTop(JPanel panel) {
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setPreferredSize(new Dimension(0, 0));
        panel.add(temp, BorderLayout.NORTH);
    }

    public static void marginLeft(JPanel panel) {
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setPreferredSize(new Dimension(0, 0));
        panel.add(temp, BorderLayout.WEST);
    }

    public static void marginRight(JPanel panel) {
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setPreferredSize(new Dimension(0, 0));
        panel.add(temp, BorderLayout.EAST);
    }

    public static void marginAll(JPanel panel) {
        marginTop(panel);
        marginBottom(panel);
        marginLeft(panel);
        marginRight(panel);
    }

    public static void marginHorizontal(JPanel panel) {
        marginLeft(panel);
        marginRight(panel);
    }

    public static void marginVertical(JPanel panel) {
        marginTop(panel);
        marginBottom(panel);
    }

    public static JPanel lineSeparator(int pxHeight, Color lineColor) {
        JPanel tempLinea = new JPanel((new BorderLayout(MARGEN_2, MARGEN_2)));
        tempLinea.setBackground(COLOR_PRINCIPAL);
        JPanel pLinea = new JPanel();
        pLinea.setBackground(lineColor);
        pLinea.setPreferredSize(new Dimension(0, pxHeight));
        tempLinea.add(pLinea);
        marginVertical(tempLinea);
        return tempLinea;
    }

    public static int getTextWidth(String text, Font font) {
        text = text.replace(" ", "::");
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        return (int) (font.getStringBounds(text, frc).getWidth());
    }

    public static int getTextHeight(String text, Font font) {
        text = text.replace(" ", "::");
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        return (int) (font.getStringBounds(text, frc).getHeight());
    }

    public static Color getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(220);
        int green = random.nextInt(240);
        int blue = random.nextInt(220);
        return new Color(red, green, blue);
    }

    public static Color getShadowColor(Color color) {
        int delta = 20;
        int red = ((color.getRed() - delta) >= 0) ? color.getRed() - delta : 0;
        int green = ((color.getGreen() - delta) >= 0) ? color.getGreen() - delta : 0;
        int blue = ((color.getBlue() - delta) >= 0) ? color.getBlue() - delta : 0;
        return new Color(red, green, blue);
    }

    private UIComponents() {
    }


}
