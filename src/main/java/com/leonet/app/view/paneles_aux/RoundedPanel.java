/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.paneles_aux;

/**
 *
 * @author Wilmer RS
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel{

    private Color backgroundColor;
    private Color foregroundColor;

    private String toolTipText;
    private int cornerRadius;

    // Primer constructor
    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }

    // Segundo constructor
    public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    // Tercer constructor
    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    // Cuarto constructor
    public RoundedPanel(int radius, Color bgColor, Color fgColor, String toolTipText) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
        foregroundColor = fgColor;
        this.toolTipText =toolTipText;
        this.setOpaque(false);
    }

    public RoundedPanel(int radius, Color bgColor, Color fgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
        foregroundColor = fgColor;
        this.setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        //this.setOpaque(false);
        super.paintComponent(g);
        update(g);
    }

    public void update(Graphics g){
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();

        //Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }

        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background

        if (foregroundColor != null) {
            graphics.setColor(foregroundColor);
        } else {
            graphics.setColor(getForeground());
        }
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint border
    }

    public void actualizarPanel (int radius, Color bgColor, Color fgColor){
        cornerRadius = radius;
        backgroundColor = bgColor;
        foregroundColor = fgColor;
        //this.paintComponent(this.getGraphics());
        //this.updateUI();
        this.repaint();
    }
}
