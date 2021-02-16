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
import javax.swing.JScrollPane;

/**
 *
 * @author Luis Alfredo
 */
public class PnTop extends JPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pTitulo;
    private JPanel pLinea;
    private JPanel pEspacio;
    private JPanel pContenido;
    private RoundedPanel pRedondo;
    
    private JLabel jTitulo;
    
    private JScrollPane jScroll;
    
    public PnTop() {
//        super(0, COLOR_VERDE, COLOR_VERDE);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        //pFondo.setPreferredSize(new Dimension((int) (ANCHO*0.0), (int) (ALTO*0.35)));
        
        pRedondo = new RoundedPanel(RADIO,COLOR_PRINCIPAL, COLOR_GRIS_BORDE);
        pRedondo.setLayout(new BorderLayout(MARGEN_2,MARGEN_2));
        pFondo.add(pRedondo, BorderLayout.CENTER);
        
        pEspacio = new JPanel();
        pEspacio.setLayout(new BorderLayout(MARGEN, MARGEN));
        pEspacio.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pEspacio, BorderLayout.CENTER);
        
        
        pCentral = new JPanel(new BorderLayout());
        pCentral.setBackground(COLOR_PRINCIPAL);
        pEspacio.add(pCentral, BorderLayout.CENTER);
        hacerMargenes();
       
        
        
        pTitulo = new JPanel(new BorderLayout());
        pTitulo.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pTitulo, BorderLayout.NORTH);
        
        jTitulo = new JLabel("TOP 10");
        jTitulo.setFont(CIUDATELLA_BOLD);
        jTitulo.setForeground(COLOR_OSCURO_TITULOS);
        pTitulo.add(jTitulo, BorderLayout.NORTH);
        
        pLinea = new JPanel();
        pLinea.setPreferredSize(new Dimension((int) (ANCHO*0.00), (int) (ALTO*0.002)));
        pLinea.setBackground(COLOR_GRIS_CLARO);
        
        pTitulo.add(pLinea, BorderLayout.SOUTH);
        
        pContenido = new JPanel();
        pContenido.setLayout(new BorderLayout());
        
        jScroll = new JScrollPane(pContenido,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScroll.setBorder(null);
        jScroll.setOpaque(false);
        jScroll.getViewport().setOpaque(false);
        jScroll.getVerticalScrollBar().setPreferredSize(new Dimension(4, 4));
        jScroll.getVerticalScrollBar().setBorder(null);
        jScroll.setViewportView(pContenido);
        pCentral.add(jScroll, BorderLayout.CENTER);
        
        JLabel jEjemplo = new JLabel("<html><body>JLabel con <br> varias <br>linea :-) <br> varias <br> <br> varias <br> <br> varias <br><br> varias <br><br> varias <br></body></html>");
        jEjemplo.setFont(CIUDATELLA_LIGHT);
        jEjemplo.setForeground(COLOR_VERDE_OSCURO);
        pContenido.add(jEjemplo, BorderLayout.CENTER);
        
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
        
        JPanel izq1 = new JPanel();
        izq1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(izq1, BorderLayout.WEST);

        JPanel der1 = new JPanel();
        der1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(der1, BorderLayout.EAST);

        JPanel nor1 = new JPanel();
        nor1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(nor1, BorderLayout.NORTH);

        JPanel sur1 = new JPanel();
        sur1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(sur1, BorderLayout.SOUTH);
        
        
        int f=10;
        JPanel nor2 = new JPanel();
        nor2.setPreferredSize(new Dimension(0, f));
        nor2.setBackground(COLOR_PRINCIPAL);
        pFondo.add(nor2, BorderLayout.NORTH);
        
        JPanel izq2 = new JPanel();
        izq2.setPreferredSize(new Dimension(f, 0));
        izq2.setBackground(COLOR_PRINCIPAL);
        pFondo.add(izq2, BorderLayout.WEST);
    }
    
}