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
import javax.swing.JTextArea;

/**
 *
 * @author Luis Alfredo
 */
public class PnContexto extends RoundedPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pContenido;
    private JPanel pContexto;
    private JPanel pEjemplo;
    
    private RoundedPanel pRedondo;
    
    private JLabel jTituloContexto;
    private JLabel jTituloEjemplo;
    private JLabel jContexto;
    private JLabel jEjemplo;
    
    private JScrollPane jScroll;
    
    private JTextArea textContexto;
    private JTextArea textEjemplo;
    
    public PnContexto() {
        super(0, COLOR_VERDE, COLOR_VERDE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        //pFondo.setPreferredSize(new Dimension((int) (ANCHO*0.50), (int) (ALTO*0.0)));
        
        pRedondo = new RoundedPanel(RADIO, COLOR_VERDE, COLOR_VERDE);
        pRedondo.setLayout(new BorderLayout(MARGEN,MARGEN));
        hacerMargenes();
        
        pFondo.add(pRedondo, BorderLayout.CENTER);
        
        pContenido = new JPanel();
        pContenido.setLayout(new BorderLayout(MARGEN,MARGEN));
        pContenido.setBackground(COLOR_VERDE);
        
        pContexto = new JPanel(new BorderLayout(MARGEN,MARGEN));
        pContenido.add(pContexto, BorderLayout.NORTH);
        pContexto.setBackground(COLOR_VERDE);
        
        pEjemplo = new JPanel(new BorderLayout(MARGEN,MARGEN));
        pEjemplo.setBackground(COLOR_VERDE);
        pContenido.add(pEjemplo, BorderLayout.SOUTH);
        
        
        jTituloContexto = new JLabel("CONTEXTO");
        jTituloContexto.setFont(CIUDATELLA_BOLD);
        jTituloContexto.setForeground(COLOR_VERDE_OSCURO);
        pContexto.add(jTituloContexto, BorderLayout.NORTH);
        
        textContexto = new JTextArea("kuiffffffffffffffffffffffffffffffffffffs", 3, 1);
        textContexto.setPreferredSize( new Dimension(0, 12));
        textContexto.setBorder(null);
        textContexto.setOpaque(false);
        textContexto.setFont(CIUDATELLA_LIGHT);
        textContexto.setForeground(COLOR_VERDE_OSCURO);
        textContexto.setCaretColor(COLOR_VERDE_OSCURO);
        textContexto.setSelectedTextColor(COLOR_PRINCIPAL);
        textContexto.setSelectionColor(COLOR_VERDE_OSCURO);
        pContexto.add(textContexto, BorderLayout.CENTER);
        
        jTituloEjemplo = new JLabel("Ejemplo");
        jTituloEjemplo.setFont(CIUDATELLA_BOLD);
        jTituloEjemplo.setForeground(COLOR_VERDE_OSCURO);
        pEjemplo.add(jTituloEjemplo, BorderLayout.NORTH);
        
        
        textEjemplo = new JTextArea("kuiffffffffffffffffffffffffffffffffffffs", 3, 1);
        textEjemplo.setPreferredSize( new Dimension(0, 12));
        textEjemplo.setBorder(null);
        textEjemplo.setOpaque(false);
        textEjemplo.setFont(CIUDATELLA_LIGHT);
        textEjemplo.setForeground(COLOR_VERDE_OSCURO);
        
        pEjemplo.add(textEjemplo, BorderLayout.CENTER);
        
        jScroll = new JScrollPane(pContenido,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScroll.setBorder(null);
        jScroll.setOpaque(false);
        jScroll.getViewport().setOpaque(false);
        jScroll.getVerticalScrollBar().setPreferredSize(new Dimension(4, 4));
        jScroll.getVerticalScrollBar().setBorder(null);
        jScroll.setViewportView(pContenido);
        
        pRedondo.add(jScroll, BorderLayout.CENTER);
        
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
    }
}
