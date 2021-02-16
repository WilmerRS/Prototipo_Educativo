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
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author WILMER
 */
public class Boton extends JButton implements Patron {

    public static final int BTN_DIAGONAL = 1;
    public static final int BTN_NO_DIAGONAL = 0;
    
    private RoundedPanel pnFondo;
    private Dimension dimension;
    private JLabel lbTexto;

    private String texto;

    public Color BACKGROUND;
    public Color BORDER;
    public Color FOREGROUND;
    public Color HOVER;
    public Color CLICK;
    public int TIPO;
    private boolean activo = false;
    
    public Boton(Dimension dimension, String texto, int tipo) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.TIPO = tipo;
        tipoBoton(tipo);
        inicarComponentes();
    }
    
    public Boton(Dimension dimension, String texto, int tipo, boolean activo) {
        super();
        this.dimension = dimension;
        this.texto = texto;
        this.TIPO = tipo;
        this.activo = activo    ;
        tipoBoton(tipo);
        inicarComponentes();
    }

    private void tipoBoton(int i) {
        if (i == BOTON_ANTERIOR) {
            BACKGROUND = COLOR_NARANJA_BOTON;
            FOREGROUND = COLOR_PRINCIPAL;
            HOVER = COLOR_NARANJA_BOTON;
            CLICK = COLOR_NARANJA_BOTON;
            BORDER = COLOR_NARANJA_BOTON;
        } 
        if(i == BOTON_SIGUIENTE){
            BACKGROUND = COLOR_AZUL_BOTON;
            FOREGROUND = COLOR_PRINCIPAL;
            HOVER = COLOR_AZUL_BOTON_HOVER;
            CLICK = COLOR_AZUL_BOTON_CLICK;
            BORDER = COLOR_AZUL_BOTON;
        }
        if(i == BOTON_CABECERA){
            BACKGROUND = COLOR_PRINCIPAL;
            FOREGROUND = COLOR_GRIS_CLARO;
            HOVER = COLOR_GRIS_HOVER;
            CLICK = COLOR_GRIS_CLICK;
            BORDER = COLOR_PRINCIPAL;
        }
        
        if(i == BOTON_CREAR_CUENTA){
            BACKGROUND = COLOR_PRINCIPAL;
            FOREGROUND = COLOR_VERDE_OSCURO;
            HOVER = COLOR_GRIS_HOVER;
            CLICK = COLOR_GRIS_CLICK;
            BORDER = COLOR_PRINCIPAL;
        }
        if(i == BOTON_OLVIDO_CONTRASENIA){
            BACKGROUND = COLOR_PRINCIPAL;
            FOREGROUND = COLOR_GRIS_CLARO;
            HOVER = COLOR_GRIS_HOVER;
            CLICK = COLOR_GRIS_CLICK;
            BORDER = COLOR_PRINCIPAL;
        }
        if(activo){
            FOREGROUND = COLOR_AZUL_CLARO;
        }
    }

    private void inicarComponentes() {
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(null);
        this.setOpaque(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        lbTexto = new JLabel(texto);
        lbTexto.setForeground(FOREGROUND);
        lbTexto.setFont(CIUDATELLA_BOLD);
        lbTexto.setHorizontalAlignment(SwingConstants.CENTER);
        lbTexto.setVerticalAlignment(SwingConstants.CENTER);
        lbTexto.setOpaque(false);

        pnFondo = new RoundedPanel(RADIO, BACKGROUND, BORDER);
        pnFondo.setLayout(new BorderLayout());
        pnFondo.setPreferredSize(dimension);
        pnFondo.setMinimumSize(dimension);
        pnFondo.add(lbTexto);
        addEventos();

        this.add(pnFondo);
    }

    private void addEventos() {
        // EVENTOS DEL MOUSE
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, HOVER, BORDER);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, BACKGROUND, BORDER);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, CLICK, BORDER);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnFondo.actualizarPanel(RADIO, HOVER, BORDER);
            }
        });

        // EVENTOS DEL FOCO
        this.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                pnFondo.actualizarPanel(RADIO, HOVER, BORDER);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                pnFondo.actualizarPanel(RADIO, BACKGROUND, BORDER);
            }
        });
        
    }
    
    public void actualizarColor(Color c){
        FOREGROUND=c;
    }

    public JLabel getLbTexto() {
        return lbTexto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
