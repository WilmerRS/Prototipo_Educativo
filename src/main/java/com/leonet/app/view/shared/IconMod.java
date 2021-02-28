package com.leonet.app.view.shared;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IconMod extends JPanel implements Patron {
    private String pathImage;
    private int width;
    private int height;

    private BufferedImage image = null;

    public IconMod(String pathImage, int width, int height) {
        this.pathImage = pathImage;
        this.width = width;
        this.height = height;
        initComponent();
    }

    private void initComponent() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(COLOR_PRINCIPAL);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        try {
            image = ImageIO.read(new File(pathImage));
        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen." + pathImage + " : CLASS: IconMod 37");
        }
        int w = this.getWidth();
        int h = this.getHeight();

        g2d.drawImage(image, (w - width) / 2, (h - height) / 2, width, height, null);
    }
}
