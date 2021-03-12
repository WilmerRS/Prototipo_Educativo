package com.leonet.app.view.shared;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserIcon extends JPanel implements Patron {
    private final int circleSmall = 13;
    private Color colorBackground;
    private Color colorBorder;
    private String username;
    private int level;

    private String pathImage = resUrlBase + "Iconos/lion.png";

    public UserIcon(String username, int level, Color colorBackground) {
        this.username = username.toUpperCase();
        this.level = level;
        this.colorBackground = colorBackground;
        this.colorBorder = UIComponents.getShadowColor(colorBackground);
        initComponents();
    }

    public UserIcon(String username, int level) {
        this.username = username.toUpperCase();
        this.level = level;
        this.colorBackground = COLOR_ROJO_SUAVE;
        this.colorBorder = UIComponents.getShadowColor(colorBackground);
        initComponents();
    }

    private void initComponents() {
        this.setBackground(COLOR_PRINCIPAL);
        this.setPreferredSize(new Dimension((int) (circleSmall * 14.4762), (int) (circleSmall * 4.3809)));
    }

    public void updateUser(String username, int level){
        this.username = username.toUpperCase();
        this.level = level;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintBackground(graphics, true, username, level, colorBorder);
        paintBackground(graphics, false, username, level, colorBackground);
        paintCircle(graphics);
        paintImageUser(graphics, pathImage);
    }

    private void paintBackground(Graphics2D g, boolean border, String username, int level, Color colorBackground) {
        g.setColor(colorBackground);

        int borderHeight = 0;
        if (border) {
            borderHeight = (int) (circleSmall * 0.2857);
        }

        // Circulo 1
        int x = 0, y = (int) (((circleSmall * 4.3809) / 2) - (circleSmall / 2));
        g.fillOval(x, y + borderHeight, circleSmall-1, circleSmall-1);

        // Circulo 2
        x = (int) (circleSmall * 0.90476);
        y = (int) (circleSmall * 1.0476);
        g.fillOval(x, y + borderHeight, circleSmall, circleSmall);

        // Circulo 3
        x = (int) (circleSmall * 0.90476);
        y = (int) (circleSmall * 2.2857);
        g.fillOval(x, y + borderHeight, circleSmall, circleSmall);

        // Poligono
        int xPoint[] = {
                (int) (circleSmall * 0.20857),
                (int) (circleSmall * 1.17048),
                (int) (circleSmall * 2.1228),
                (int) (circleSmall * 1.17048),
                (int) (circleSmall * 0.20857),
        };
        int yPoint[] = {
                (int) (circleSmall * 1.780047) + borderHeight,
                (int) (circleSmall * 1.058) + borderHeight,
                (int) (circleSmall * 2.1666) + borderHeight,
                (int) (circleSmall * 3.2095) + borderHeight,
                (int) (circleSmall * 2.5476) + borderHeight,
        };
        g.fillPolygon(xPoint, yPoint, xPoint.length);

        // Rectangulo
        x = (int) (circleSmall * 1.40476);
        y = (int) (circleSmall * 1.0476);
        int w = (int) (circleSmall * 2.2381), h = (int) (circleSmall * 9.4762);
        g.fillRect(x, y + borderHeight, h, w);

        // Nombre de usuario
        g.setFont(SUBTITlE1_5_FONT);
        g.setColor(COLOR_PRINCIPAL);
        w = UIComponents.getTextWidth(username, SUBTITlE1_5_FONT);
        h = UIComponents.getTextHeight(username, SUBTITlE1_5_FONT);
        x = (int) ((circleSmall * 7.76476) - w);
        y = (int) (circleSmall * 2.1976);
        g.drawString(username, x, y);

        // Nivel
        g.setFont(SUBTEXT_FONT);
        w = UIComponents.getTextWidth("Nivel " + level, SUBTEXT_FONT);
        h = UIComponents.getTextHeight("Nivel " + level, SUBTEXT_FONT);
        x = (int) ((circleSmall * 7.96476) - w);
        y = (int) (circleSmall * 3.0476);
        g.drawString("Nivel " + level, x, y);
    }

    private void paintCircle(Graphics2D g) {
        g.setColor(colorBorder);
        // Circulo 4
        int x = (int) (circleSmall * 8.5714);
        int y = 0;
        int circleBig = (int) (circleSmall * 4.3809);
        g.fillOval(x, y, circleBig, circleBig);
    }

    private void paintImageUser(Graphics2D g, String pathImage) {
        // Foto
        int x = (int) (circleSmall * 9.2014);
        int y = (int) (circleSmall * 0.5814);

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(pathImage));
        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen." + pathImage + " : CLASS: IconMod 37");
        }
        int w = (int) (circleSmall * 3.0809);
        int h = (int) (circleSmall * 3.4809);

        g.drawImage(image, x, y, w, h, null);
    }
}
