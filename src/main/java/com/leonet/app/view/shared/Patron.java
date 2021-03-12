/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonet.app.view.shared;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * "Interface" que permite centralizar el diseño de la app
 *
 * @author Wilmer RS
 * @author Luis Alfredo
 */
public interface Patron {
    public static final String resUrlBase = "src/main/resources/";

    public static final int ANCHO = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int ALTO = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final int FONT_SIZE = (ALTO >= 800) ? 2 : 0;

    public static final int ORANGE_BUTTON = 0;
    public static final int BLUE_BUTTON = 1;
    public static final int BOTON_CABECERA = 2;
    public static final int GRAY_BUTTON = 3;
    public static final int LABEL_BUTTON = 4;
    public static final int WHITE_BUTTON = 5;

    public static final String ERROR_TYPE_MODAL = resUrlBase + "Iconos/error.png";
    public static final String DONE_TYPE_MODAL = resUrlBase + "Iconos/done.png";

    public static int ITEM_HEIGHT = (int) (ALTO * 0.05);

    public static int MARGEN = (int) (ANCHO * 0.0070);
    public static int MARGEN_2 = (int) (ANCHO * 0.00365);

    public static int RADIO = (int) (ANCHO * 0.023);
    public static int RADIO_BUTTON = (int) (ANCHO * 0.016);

    public static final Color COLOR_PRINCIPAL = new Color(255, 255, 255);
    public static final Color COLOR_GRIS_CLARO = new Color(245, 245, 245);
    public static final Color COLOR_GRIS = new Color(232, 232, 232);
    public static final Color COLOR_GRIS_HOVER = new Color(220, 220, 220);
    public static final Color COLOR_GRIS_CLICK = new Color(210, 210, 210);

    public static final Color COLOR_GRIS_BORDER = new Color(205, 205, 205);
    public static final Color COLOR_GRIS_MEDIO = new Color(162, 162, 162);
    public static final Color COLOR_GRIS_OSCURO = new Color(67, 67, 67);

    public static final Color COLOR_VERDE = new Color(205, 227, 49);
    public static final Color COLOR_VERDE_CLARO = new Color(229, 248, 93);
    public static final Color COLOR_VERDE_MEDIO = new Color(141, 161, 0);
    public static final Color COLOR_VERDE_OSCURO = new Color(76, 86, 4);


    public static final Color COLOR_ROJO = new Color(217, 84, 7);
    public static final Color COLOR_ROJO_SUAVE = new Color(252, 123, 91);
    public static final Color COLOR_ROJO_MEDIO = new Color(252, 92, 60);

    public static final Color COLOR_NARANJA_CLARO = new Color(245, 164, 65);
    public static final Color COLOR_NARANJA = new Color(245, 158, 51);
    public static final Color COLOR_NARANJA_HOVER = new Color(241, 168, 76);
    public static final Color COLOR_NARANJA_CLICK = new Color(241, 147, 31);
    public static final Color COLOR_NARANJA_BOTON_BORDER = new Color(212, 120, 7);

    public static final Color COLOR_AZUL_CLARO = new Color(64, 218, 250);
    public static final Color COLOR_AZUL_BOTON = new Color(57, 217, 250);
    public static final Color COLOR_AZUL_BOTON_HOVER = new Color(82, 222, 250);
    public static final Color COLOR_AZUL_BOTON_CLICK = new Color(33, 216, 253);
    public static final Color COLOR_AZUL_BOTON_BORDER = new Color(30, 180, 212);


    public static Font TITLE_BIG_FONT = addFonts("Ciutadella Rounded Bold", 20 + FONT_SIZE);
    public static Font TITLE_FONT = addFonts("Ciutadella Rounded Bold", 16 + FONT_SIZE);
    public static Font BUTTON_TEXT_FONT = addFonts("Ciutadella Rounded Bold", 16 + FONT_SIZE);
    public static Font SUBTITlE1_FONT = addFonts("Ciutadella Rounded Bold", 14 + FONT_SIZE);
    public static Font SUBTITlE1_5_FONT = addFonts("Ciutadella Rounded Bold", 13 + FONT_SIZE);
    public static Font SUBTITlE2_FONT = addFonts("Ciutadella Rounded Medium", 14 + FONT_SIZE);
    public static Font SUBTITlE3_FONT = addFonts("Ciutadella Rounded Light", 14 + FONT_SIZE);
    public static Font CONTENT_FONT = addFonts("Ciutadella Rounded Regular", 12 + FONT_SIZE);
    public static Font CONTENT_ITALIC_FONT = addFonts("Ciutadella Rounded Regular Italic", 12 + FONT_SIZE);
    public static Font SUBTEXT_FONT = addFonts("Ciutadella Rounded Light", 10 + FONT_SIZE);


    /**
     * NO USAR FUERA PATRON
     *
     * @param fontName
     * @param pxFontSize
     * @return
     */
    public static Font addFonts(String fontName, int pxFontSize) {
        Font fuente = null;
        InputStream myStream;
        try {
            myStream = new BufferedInputStream(new FileInputStream(resUrlBase + "fonts/" + fontName + ".ttf"));
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, pxFontSize);
        } catch (FontFormatException | IOException ex) {
        }
        return fuente;
    }
}
