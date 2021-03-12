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
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author WILMER
 */
public class Button extends JButton implements Patron {

    public static final int BTN_DIAGONAL = 1;
    public static final int BTN_NO_DIAGONAL = 0;

    private RoundedPanel pnFondo;
    private RoundedPanel pnBackground;
    private Dimension dimension;
    private JLabel lbTexto;

    private String text;

    public Color BACKGROUND;
    public Color BORDER;
    public Color FOREGROUND;
    public Color HOVER;
    public Color CLICK;

    public final int BUTTON_TYPE;
    private boolean activeButton = false;

    public Button(Dimension dimension, String text, int type) {
        this.dimension = dimension;
        this.text = text;
        this.BUTTON_TYPE = type;
        buttonType(type);
        initComponents();
    }

    public Button(Dimension dimension, String text, int type, boolean activeButton) {
        this.dimension = dimension;
        this.text = text;
        this.BUTTON_TYPE = type;
        this.activeButton = activeButton;
        buttonType(type);
        initComponents();
    }

    private void buttonType(int type) {
        switch (type) {
            case ORANGE_BUTTON:
                BACKGROUND = COLOR_NARANJA;
                FOREGROUND = COLOR_PRINCIPAL;
                HOVER = COLOR_NARANJA_HOVER;
                CLICK = COLOR_NARANJA_CLICK;
                BORDER = COLOR_NARANJA_BOTON_BORDER;
                break;
            case BLUE_BUTTON:
                BACKGROUND = COLOR_AZUL_BOTON;
                FOREGROUND = COLOR_PRINCIPAL;
                HOVER = COLOR_AZUL_BOTON_HOVER;
                CLICK = COLOR_AZUL_BOTON_CLICK;
                BORDER = COLOR_AZUL_BOTON_BORDER;
                break;
            case BOTON_CABECERA:
                BACKGROUND = COLOR_PRINCIPAL;
                FOREGROUND = COLOR_GRIS_MEDIO;
                HOVER = COLOR_GRIS_CLARO;
                CLICK = COLOR_GRIS;
                BORDER = COLOR_PRINCIPAL;
                break;
            case WHITE_BUTTON:
                BACKGROUND = COLOR_PRINCIPAL;
                FOREGROUND = COLOR_GRIS_MEDIO;
                HOVER = COLOR_GRIS_CLARO;
                CLICK = COLOR_GRIS;
                BORDER = COLOR_GRIS_CLICK;
                break;
            case GRAY_BUTTON:
                BACKGROUND = COLOR_GRIS;
                FOREGROUND = COLOR_VERDE_OSCURO;
                HOVER = COLOR_GRIS_HOVER;
                CLICK = COLOR_GRIS_CLICK;
                BORDER = COLOR_GRIS_BORDER;
                break;
            case LABEL_BUTTON:
                BACKGROUND = COLOR_PRINCIPAL;
                FOREGROUND = COLOR_GRIS_MEDIO;
                HOVER = COLOR_AZUL_BOTON_HOVER;
                CLICK = COLOR_AZUL_BOTON_CLICK;
                BORDER = COLOR_PRINCIPAL;
                break;
        }
        if (activeButton) {
            FOREGROUND = COLOR_AZUL_CLARO;
        }
    }

    private void initComponents() {
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(null);
        this.setOpaque(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        lbTexto = new JLabel(text);
        lbTexto.setForeground(FOREGROUND);
        lbTexto.setFont(BUTTON_TEXT_FONT);
        lbTexto.setHorizontalAlignment(SwingConstants.CENTER);
        lbTexto.setVerticalAlignment(SwingConstants.CENTER);
        lbTexto.setOpaque(false);

        pnBackground = new RoundedPanel(RADIO_BUTTON, BORDER, BORDER);
        pnBackground.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        UIComponents.marginBottom(pnBackground);

        pnFondo = new RoundedPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
        pnFondo.setLayout(new BorderLayout());
        pnFondo.setPreferredSize(dimension);
        pnFondo.setMinimumSize(dimension);
        pnFondo.add(lbTexto);
        addEvents();

        pnBackground.add(pnFondo, BorderLayout.CENTER);
        this.add(pnBackground);
    }

    private void addEvents() {
        // MOUSE EVENTS
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (BUTTON_TYPE == LABEL_BUTTON) {
                    lbTexto.setForeground(HOVER);
                    pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
                } else {
                    pnFondo.actualizarPanel(RADIO_BUTTON, HOVER, HOVER);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (BUTTON_TYPE == LABEL_BUTTON) {
                    lbTexto.setForeground(FOREGROUND);
                }
                pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (BUTTON_TYPE == LABEL_BUTTON) {
                    lbTexto.setForeground(CLICK);
                    pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
                } else {
                    pnFondo.actualizarPanel(RADIO_BUTTON, CLICK, CLICK);
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (BUTTON_TYPE == LABEL_BUTTON) {
                    lbTexto.setForeground(HOVER);
                    pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
                } else {
                    pnFondo.actualizarPanel(RADIO_BUTTON, HOVER, HOVER);
                }
            }
        });

        // FOCUS EVENTS
        this.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if (BUTTON_TYPE == LABEL_BUTTON) {
                    lbTexto.setForeground(HOVER);
                    pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
                } else {
                    pnFondo.actualizarPanel(RADIO_BUTTON, HOVER, HOVER);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (BUTTON_TYPE == LABEL_BUTTON) {
                    lbTexto.setForeground(FOREGROUND);
                    pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
                } else {
                    pnFondo.actualizarPanel(RADIO_BUTTON, BACKGROUND, BACKGROUND);
                }
            }
        });

    }

    public void updateColor(Color color) {
        FOREGROUND = color;
    }

    public JLabel getLbTexto() {
        return lbTexto;
    }

    public boolean isActiveButton() {
        return activeButton;
    }

    public void setActiveButton(boolean activeButton) {
        this.activeButton = activeButton;
    }

}
