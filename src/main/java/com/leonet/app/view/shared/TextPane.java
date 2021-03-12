package com.leonet.app.view.shared;

import javax.swing.*;
import java.awt.*;

public class TextPane extends JTextPane implements Patron {
    private String text;
    private Color backgroung;

    public TextPane(String text, Color background) {
        this.text = text;
        this.backgroung = background;
        initSettings();
    }

    private void initSettings() {
        this.setFont(SUBTITlE1_5_FONT);
        this.setForeground(COLOR_VERDE_OSCURO);
        this.setCaretColor(COLOR_VERDE_OSCURO);
        this.setSelectedTextColor(COLOR_PRINCIPAL);
        this.setSelectionColor(COLOR_VERDE_OSCURO);
        this.setBackground(backgroung);
        this.setEditable(false);
        /**
         String text = "<h4 style=\"text-align: center;\"><span style=\"color: #333300;\">&ldquo;Algoritmos 1&rdquo; (Algoritmos - Que son).</span></h4>\n" +
         "<p><span style=\"color: #333300;\">Un algoritmo es una secuencia l&oacute;gica y finita de pasos que permite solucionar un problema o cumplir con un objetivo.<em> <a style=\"color: #333300;\" href=\"http://aprende.colombiaaprende.edu.co/sites/default/files/naspublic/curriculos_ex/n1g10_fproy/nivel1/programacion/unidad1/leccion1.html\">Aprende TIC</a>.</em></span></p>";
         */
        this.setText(text);
    }

    public void setTextContent(String text) {
        this.setText(text);
    }
}
