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
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/**
 *
 * @author Luis Alfredo
 */
public class PnInicioSesion extends  JPanel implements Patron{
    
    private JPanel pFondo;
    private JPanel pMargenes;
    private JPanel pBotones;
    private JPanel pCentral;
    
    private RoundedPanel pRedondo;
    
    private JLabel jTitulo;
    
    private JTextArea textContenido;
    
    private JScrollPane jScroll;
    
    private Button btnIniciarSesion;
    private Button btnCrearCuenta;
    
    public PnInicioSesion() {
//        super(0, COLOR_VERDE, COLOR_VERDE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        
        pRedondo = new RoundedPanel(RADIO,COLOR_PRINCIPAL, COLOR_GRIS_BORDER);
        pRedondo.setLayout(new BorderLayout(MARGEN_2,MARGEN_2));
        pFondo.add(pRedondo, BorderLayout.CENTER);
        
        pMargenes = new JPanel();
        pMargenes.setLayout(new BorderLayout(MARGEN, MARGEN));
        pMargenes.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pMargenes, BorderLayout.CENTER);
        hacerMargenes();
        
        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout());
        pCentral.setBackground(COLOR_PRINCIPAL);
        pMargenes.add(pCentral, BorderLayout.CENTER);
        
        jTitulo = new JLabel("titulo largo");
        jTitulo.setFont(TITLE_FONT);
        jTitulo.setForeground(COLOR_GRIS_BORDER);
        jTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pCentral.add(jTitulo, BorderLayout.NORTH);
        
        textContenido = new JTextArea();
        pCentral.add(textContenido, BorderLayout.CENTER);
        
        pBotones = new JPanel();
        pBotones.setLayout(new GridLayout(2, 0));
        pCentral.add(pBotones, BorderLayout.SOUTH);
        
        btnIniciarSesion = new Button(new Dimension((int) (ANCHO*0.09), (int) (ALTO*0.05)), "Iniciar Sesion", BLUE_BUTTON);
        pBotones.add(btnIniciarSesion);
        
        btnCrearCuenta = new Button(new Dimension((int) (ANCHO*0.08), (int) (ALTO*0.05)), "Crear Cuenta", GRAY_BUTTON);
        pBotones.add(btnCrearCuenta);
        
        
        this.add(pFondo);
    }
    
    private void hacerMargenes(){
        int i = 0;
        JPanel izq = new JPanel();
        izq.setPreferredSize(new Dimension(i, i));
        pRedondo.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setPreferredSize(new Dimension(i, i));
        pRedondo.add(der, BorderLayout.EAST);

        JPanel nor = new JPanel();
        nor.setPreferredSize(new Dimension(i, i));
        pRedondo.add(nor, BorderLayout.NORTH);

        JPanel sur = new JPanel();
        sur.setPreferredSize(new Dimension(i, i));
        pRedondo.add(sur, BorderLayout.SOUTH);
        
        int f=10;
        JPanel nor1 = new JPanel();
        nor1.setPreferredSize(new Dimension(0, f));
        nor1.setBackground(COLOR_PRINCIPAL);
        pFondo.add(nor1, BorderLayout.NORTH);
        
        JPanel izq2 = new JPanel();
        izq2.setPreferredSize(new Dimension(i, 0));
        pMargenes.add(izq2, BorderLayout.WEST);

        JPanel der2 = new JPanel();
        der2.setPreferredSize(new Dimension(i, 0));
        pMargenes.add(der2, BorderLayout.EAST);

        JPanel nor2 = new JPanel();
        nor2.setPreferredSize(new Dimension(0, i));
        pMargenes.add(nor2, BorderLayout.NORTH);

        JPanel sur2 = new JPanel();
        sur2.setPreferredSize(new Dimension(0, i));
        pMargenes.add(sur2, BorderLayout.SOUTH);
    }
}
