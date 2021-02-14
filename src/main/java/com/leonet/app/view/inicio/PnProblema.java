/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.inicio;

import com.leonet.app.view.paneles_aux.IconMod;
import com.leonet.app.view.paneles_aux.Patron;
import com.leonet.app.view.paneles_aux.RoundedPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Luis Alfredo
 */
public class PnProblema extends JPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pTitulo;
    private JPanel pEspacio;
    private JPanel pContenido;
    private JPanel pLinea;
    
    private RoundedPanel pRedondo;
    
    private JLabel jTitulo;
    private JLabel jIcono;
    
    private ImageIcon icono;
    
    private JScrollPane jScroll;
    
    private JTextArea textProblema;
    private JTextArea textPro;
    
    public PnProblema() {
//        super(0, COLOR_VERDE, COLOR_VERDE);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        //pFondo.setPreferredSize(new Dimension((int) (ANCHO * 0.0), (int) (ALTO * 0.35)));

        pRedondo = new RoundedPanel(RADIO,COLOR_PRINCIPAL, COLOR_GRIS_BORDE);
        pRedondo.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pFondo.add(pRedondo, BorderLayout.CENTER);

        pEspacio = new JPanel();
        pEspacio.setLayout(new BorderLayout(MARGEN, MARGEN));
        pEspacio.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pEspacio, BorderLayout.CENTER);
        hacerMargenes();

        pCentral = new JPanel(new BorderLayout());
        pCentral.setBackground(COLOR_PRINCIPAL);
        
        jScroll = new JScrollPane(pCentral,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScroll.setBorder(null);
        jScroll.setOpaque(false);
        jScroll.getViewport().setOpaque(false);
        jScroll.getVerticalScrollBar().setPreferredSize(new Dimension(4, 4));
        jScroll.getVerticalScrollBar().setBorder(null);
        jScroll.setViewportView(pCentral);
        
        pEspacio.add(jScroll, BorderLayout.CENTER);

        pTitulo = new JPanel(new BorderLayout());
        pTitulo.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pTitulo, BorderLayout.NORTH);

        jTitulo = new JLabel("PROBLEMA");
        jTitulo.setFont(CIUDATELLA_BOLD);
        jTitulo.setForeground(COLOR_OSCURO_TITULOS);
        pTitulo.add(jTitulo, BorderLayout.WEST);
        
        
        //icono = new ImageIcon(resUrlBase + "Iconos\\icon2.png");
        //jIcono = new JLabel();
        //jIcono.setPreferredSize(new Dimension((int) (ANCHO * 0.10), (int) (ALTO * 0.05)));
        //Icon icon = new ImageIcon(icono.getImage().getScaledInstance((int) (ANCHO * 0.10), (int) (ALTO * 0.05), Image.SCALE_DEFAULT));
        //jIcono.setIcon(icon);

        IconMod iconMod = new IconMod(resUrlBase + "Iconos\\icon2.png", (int) (ANCHO * 0.10), (int) (ALTO * 0.05));
        pTitulo.add(iconMod, BorderLayout.EAST);
        
        pContenido = new JPanel();
        pContenido.setLayout(new BorderLayout());
        pContenido.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pContenido, BorderLayout.CENTER);
        
        pLinea = new JPanel();
        pLinea.setPreferredSize(new Dimension((int) (ANCHO*0.00), (int) (ALTO*0.002)));
        pLinea.setBackground(COLOR_GRIS_CLARO);
        
        pContenido.add(pLinea, BorderLayout.SOUTH);
        
        textProblema = new JTextArea("kuiffffffffffffffffffffffffffffffffffffs");
        //textProblema.setPreferredSize( new Dimension(0, 12));
        textProblema.setBorder(null);
        textProblema.setOpaque(false);
        textProblema.setFont(CIUDATELLA_LIGHT);
        textProblema.setForeground(COLOR_VERDE_OSCURO);
        
        pContenido.add(textProblema, BorderLayout.NORTH);
        
        
        textPro = new JTextArea("kuiffffffffffffffffffffffffffffffffffffs", 10, 1);
        textPro.setPreferredSize( new Dimension(0, 12));
        textPro.setBorder(null);
        textPro.setOpaque(false);
        textPro.setFont(CIUDATELLA_LIGHT);
        textPro.setForeground(COLOR_VERDE_OSCURO);
        
        pCentral.add(textPro, BorderLayout.SOUTH);
       
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
        
//        JPanel izq1 = new JPanel();
//        izq1.setPreferredSize(new Dimension(f, 0));
//        pFondo.add(izq1, BorderLayout.WEST);
    }
    
}
