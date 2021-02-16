/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.home;

import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.RoundedPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luis Alfredo
 */
public class PnNivel extends JPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pTitulo;
    private JPanel pLinea;
    private JPanel pMargenes;
    
    private RoundedPanel pRedondo;
    
    private JLabel jTitulo;
    
    public PnNivel() {
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN_2,MARGEN_2));
        pFondo.setBackground(COLOR_PRINCIPAL);
        //pFondo.setPreferredSize(new Dimension((int) (ANCHO*0.0), (int) (ALTO*0.35)));
        
        pRedondo = new RoundedPanel(RADIO,COLOR_PRINCIPAL, COLOR_GRIS_BORDE);
        pRedondo.setLayout(new BorderLayout(MARGEN_2,MARGEN_2));
        pFondo.add(pRedondo, BorderLayout.CENTER);
        
        
        pMargenes = new JPanel();
        pMargenes.setLayout(new BorderLayout(MARGEN, MARGEN));
        pMargenes.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pMargenes, BorderLayout.CENTER);
        
        hacerMargenes();
        
        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout(MARGEN_2,MARGEN_2));
        pCentral.setBackground(COLOR_PRINCIPAL);
        pMargenes.add(pCentral, BorderLayout.CENTER);
        
        pTitulo = new JPanel();
        pTitulo.setLayout(new BorderLayout(MARGEN_2,MARGEN_2));
        pTitulo.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pTitulo, BorderLayout.NORTH);
        
        jTitulo = new JLabel("NIVEL 1: TEMA 1");
        jTitulo.setFont(CIUDATELLA_BOLD);
        jTitulo.setForeground(COLOR_OSCURO_TITULOS);
        pTitulo.add(jTitulo, BorderLayout.NORTH);
        
        pLinea = new JPanel();
        pLinea.setPreferredSize(new Dimension((int) (ANCHO*0.00), (int) (ALTO*0.002)));
        pLinea.setBackground(COLOR_GRIS_CLARO);
        
        pTitulo.add(pLinea, BorderLayout.SOUTH);
        
        JLabel jEjemplo = new JLabel("<html><body>JLabel con <br> varias <br>linea :-) </body></html>");
        jEjemplo.setFont(CIUDATELLA_LIGHT);
        jEjemplo.setForeground(COLOR_VERDE_OSCURO);
        pCentral.add(jEjemplo, BorderLayout.CENTER);
        
        this.add(pFondo);
        
    }
    
     private void hacerMargenes(){
        int i = 0;
        JPanel izq = new JPanel();
        izq.setPreferredSize(new Dimension(i, 0));
        pRedondo.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setPreferredSize(new Dimension(i, 0));
        pRedondo.add(der, BorderLayout.EAST);

        JPanel nor = new JPanel();
        nor.setPreferredSize(new Dimension(0, i));
        pRedondo.add(nor, BorderLayout.NORTH);

        JPanel sur = new JPanel();
        sur.setPreferredSize(new Dimension(0, i));
        pRedondo.add(sur, BorderLayout.SOUTH);
        
        int f=10;
        JPanel nor1 = new JPanel();
        nor1.setPreferredSize(new Dimension(0, f));
        nor1.setBackground(COLOR_PRINCIPAL);
        pFondo.add(nor1, BorderLayout.NORTH);
        
        JPanel izq1 = new JPanel();
        izq1.setPreferredSize(new Dimension(f, 0));
        izq1.setBackground(COLOR_PRINCIPAL);
        pFondo.add(izq1, BorderLayout.WEST);
        
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
