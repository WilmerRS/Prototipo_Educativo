/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.shared;

import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Component;
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Insets;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Luis Alfredo
 */
public class TextField extends JPanel implements Patron {


    public static final int RESTRICCION_NUMEROS = 1;
    public static final int RESTRICCION_LETRAS = 2;
    public static final int RESTRICCION_NO_EDITABLE = 3;

    private static Color BACKGROUND = COLOR_PRINCIPAL;
    private static Color BORDER = COLOR_GRIS;

    private RoundedPanel pnFondo;
    private JTextField txtField;
    private JScrollPane spTxtField;
    private Dimension dimension;
    private String texto;
    private boolean passwordTipe;
    private String aux;

    public TextField(Dimension dimension, String texto) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.aux = texto;
        this.passwordTipe = false;
        initComponents();
    }

    public TextField(Dimension dimension, String texto, boolean passwordTipe) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.aux = texto;
        this.passwordTipe = passwordTipe;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(null);
        this.setOpaque(false);
        this.setPreferredSize(dimension);
        this.setFocusable(false);

        txtField = (!passwordTipe) ? new JTextField(texto) : new JPasswordField(texto);
        txtField.setFont(CIUDATELLA_LIGHT);
        txtField.setBorder(new Border() {
            @Override
            public void paintBorder(Component cmpnt, Graphics grphcs, int i, int i1, int i2, int i3) {
            }

            @Override
            public Insets getBorderInsets(Component cmpnt) {
                return new Insets(2, 10, 2, 10);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
        txtField.setOpaque(false);
        txtField.setCaretColor(COLOR_AZUL_CLARO);
        txtField.setForeground(COLOR_OSCURO_TITULOS);
        txtField.setSelectedTextColor(COLOR_GRIS);
        txtField.setSelectionColor(COLOR_AZUL_CLARO);
        txtField.setMargin(new java.awt.Insets(7, 7, 7, 7));

        spTxtField = new JScrollPane(txtField,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spTxtField.setBorder(null);
        spTxtField.setOpaque(false);
        spTxtField.getViewport().setOpaque(false);
        spTxtField.setViewportView(txtField);

        spTxtField.getHorizontalScrollBar().setPreferredSize(new Dimension(4, 4));
        spTxtField.getHorizontalScrollBar().setBorder(null);

        pnFondo = new RoundedPanel(RADIO, BACKGROUND, BORDER);
        pnFondo.setLayout(new BorderLayout(4, 3));
        pnFondo.setBackground(COLOR_PRINCIPAL);
        pnFondo.add(spTxtField, BorderLayout.CENTER);
        hacerMagenes();

        addEventos();

        this.add(pnFondo);
    }

    private void hacerMagenes() {
        int i = 1;
        JPanel izq = new JPanel();
        izq.setOpaque(false);
        izq.setPreferredSize(new Dimension(i, i));
        pnFondo.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setOpaque(false);
        der.setPreferredSize(new Dimension(i, i));
        pnFondo.add(der, BorderLayout.EAST);

        JPanel nor = new JPanel();
        nor.setOpaque(false);
        nor.setPreferredSize(new Dimension(i, i));
        pnFondo.add(nor, BorderLayout.NORTH);

        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.setPreferredSize(new Dimension(i, i));
        pnFondo.add(sur, BorderLayout.SOUTH);
    }

    private void addEventos() {
        txtField.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                BORDER = COLOR_AZUL_CLARO;
                pnFondo.actualizarPanel(RADIO, COLOR_PRINCIPAL, BORDER);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                BORDER = COLOR_GRIS;
                pnFondo.actualizarPanel(RADIO, BACKGROUND, BORDER);
            }
        });
    }

    public void setTexto(String text0) {
        txtField.setText(texto);
    }

    public JTextField getTxtField() {
        return txtField;
    }

    public String getAux() {
        return aux;
    }

    public JScrollPane getSpTxtField() {
        return spTxtField;
    }

    public void setSpTxtField(JScrollPane spTxtField) {
        this.spTxtField = spTxtField;
    }
}
    
