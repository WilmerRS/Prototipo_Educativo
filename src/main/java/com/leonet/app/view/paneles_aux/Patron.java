/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonet.app.view.paneles_aux;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Luis Alfredo
 */
public interface Patron {

    public static final int ANCHO = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int ALTO = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final int BOTON_ANTERIOR = 0;
    public static final int BOTON_SIGUIENTE = 1;
    public static final int BOTON_CABECERA = 2;
    public static final int BOTON_CREAR_CUENTA = 3;
    public static final int BOTON_OLVIDO_CONTRASENIA = 4;

    public static final Color COLOR_PRINCIPAL = new Color(255, 255, 255);
    public static final Color COLOR_GRIS = new Color(232, 232, 232);
    public static final Color COLOR_GRIS_HOVER = new Color(245, 245, 245);
    public static final Color COLOR_GRIS_CLICK = new Color(232, 232, 232);
    public static final Color COLOR_VERDE = new Color(205, 227, 49);
    public static final Color COLOR_VERDE_MEDIO = new Color(141, 161, 0);
    public static final Color COLOR_VERDE_OSCURO = new Color(76, 86, 4);
    public static final Color COLOR_AZUL_CLARO = new Color(64, 218, 250);
    public static final Color COLOR_GRIS_CLARO = new Color(162, 162, 162);
    public static final Color COLOR_GRIS_BORDE = new Color(205, 205, 205);
    public static final Color COLOR_OSCURO_TITULOS = new Color(67, 67, 67);
    public static final Color COLOR_ROJO = new Color(217, 84, 7);

    public static final Color COLOR_NARANJA_BOTON = new Color(245, 158, 51);
    public static final Color COLOR_AZUL_BOTON = new Color(57, 217, 250);
    public static final Color COLOR_AZUL_BOTON_HOVER = new Color(117, 223, 245);
    public static final Color COLOR_AZUL_BOTON_CLICK = new Color(33, 216, 253);
    public static final Color COLOR_AZUL_BOTON_BORDER = new Color(30, 180, 212);

    public static int MARGEN = (int) (ANCHO * 0.007); // ~5
    public static int MARGEN_2 = (int) (ANCHO * 0.00291); // ~5
    public static int RADIO = (int) (ANCHO * 0.011);  // ~10

    public static Font CIUDATELLA_BOLD = cambiarFuente("Ciutadella Rounded Bold", 18);
    public static Font CIUDATELLA_LIGHT_ITALIC = cambiarFuente("Ciutadella Rounded Light Italic", 16);
    public static Font CIUDATELLA_LIGHT = cambiarFuente("Ciutadella Rounded Light", 16);

    public static Font CIUDATELLA_MEDIUM_ITALIC = cambiarFuente("Ciutadella Rounded Medium Italic", 18);
    public static Font CIUDATELLA_MEDIUM = cambiarFuente("Ciutadella Rounded Medium", 16);
    public static Font CIUDATELLA_REGULAR_ITALIC = cambiarFuente("Ciutadella Rounded Regular Italic", 12);
    public static Font CIUDATELLA_REGULAR = cambiarFuente("Ciutadella Rounded Regular.ttf", 12);


    public static String resUrlBase = "src/main/resources/";

    /**
     * NO USAR FUERA PATRON
     *
     * @param font
     * @param px
     * @return
     */
    public static Font cambiarFuente(String font, int px) {
        Font fuente = null;
        InputStream myStream;
        try {
            myStream = new BufferedInputStream(new FileInputStream(resUrlBase + "fonts/" + font + ".ttf"));
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, px);
        } catch (FontFormatException | IOException ex) {
        }
        return fuente;
    }

}
