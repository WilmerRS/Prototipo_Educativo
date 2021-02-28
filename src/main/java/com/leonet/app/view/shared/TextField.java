/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
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


    private static Color BACKGROUND = COLOR_PRINCIPAL;
    private static Color BORDER = COLOR_GRIS_BORDER;

    private RoundedPanel pnFondo;
    private JTextField txtField;
    private ScrollPane spTxtField;
    private Dimension dimension;
    private String text;
    private boolean passwordTipe;
    private String aux;

    private Color colorBorder;
    private Color colorBorderHover;

    public TextField(Dimension dimension, String text) {
        super();
        this.dimension = dimension;
        this.text = text;
        this.aux = text;
        this.passwordTipe = false;
        this.colorBorder = COLOR_GRIS_BORDER;
        this.colorBorderHover = COLOR_AZUL_CLARO;
        initComponents();
    }

    public TextField(Dimension dimension, String text, boolean passwordTipe) {
        super();
        this.dimension = dimension;
        this.text = text;
        this.aux = text;
        this.passwordTipe = passwordTipe;
        this.colorBorder = COLOR_GRIS_BORDER;
        this.colorBorderHover = COLOR_AZUL_CLARO;
        initComponents();
    }

    public TextField(Dimension dimension, String text, Color colorBorder) {
        super();
        this.dimension = dimension;
        this.text = text;
        this.aux = text;
        this.BORDER = colorBorder;
        this.colorBorder = colorBorder;
        this.colorBorderHover = colorBorder;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(null);
        this.setOpaque(false);
        this.setPreferredSize(dimension);
        this.setFocusable(false);

        txtField = (!passwordTipe) ? new JTextField(text) : new JPasswordField(text);
        txtField.setFont(CONTENT_FONT);
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
        txtField.setCaretColor(colorBorderHover);
        txtField.setForeground(COLOR_GRIS_OSCURO);
        txtField.setSelectedTextColor(COLOR_PRINCIPAL);
        txtField.setSelectionColor(colorBorderHover);
        txtField.setMargin(new java.awt.Insets(7, 7, 7, 7));

        spTxtField = new ScrollPane(txtField,
                ScrollPane.VERTICAL_SCROLLBAR_NEVER,
                ScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        pnFondo = new RoundedPanel(RADIO_BUTTON, BACKGROUND, BORDER);
        pnFondo.setLayout(new BorderLayout(4, 3));
        pnFondo.setBackground(COLOR_PRINCIPAL);
        pnFondo.add(spTxtField, BorderLayout.CENTER);
        UIComponents.marginAll(pnFondo);

        addEvents();

        this.add(pnFondo);
    }

    private void addEvents() {
        txtField.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                BORDER = colorBorderHover;
                pnFondo.actualizarPanel(RADIO_BUTTON, COLOR_PRINCIPAL, BORDER);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                BORDER = colorBorder;
                pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BORDER);
            }
        });
    }

    public void setText(String text) {
        txtField.setText(text);
    }

    public String getText() {
        return txtField.getText();
    }

    public JTextField getTxtField() {
        return txtField;
    }

}
    
