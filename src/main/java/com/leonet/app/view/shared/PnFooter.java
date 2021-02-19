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
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Luis Alfredo
 */
public class PnFooter extends JPanel implements Patron{
    
    private JPanel pFondo;
    private JPanel pContenido;
    
    private JLabel jTitulo;
    private JLabel jTitulo1;
    private JLabel jTitulo2;
    
    public PnFooter() {
        super();
        initComponents();
    }
    
    private void initComponents(){
        
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        
        jTitulo = new JLabel("Acerca de * Aplicaciones");
        jTitulo.setAlignmentX(CENTER_ALIGNMENT);
        jTitulo.setFont(TITLE_FONT);
        jTitulo.setForeground(COLOR_GRIS_BORDER);
        
        jTitulo1 = new JLabel("Terminos * Condiciones");
        jTitulo1.setAlignmentX(CENTER_ALIGNMENT);
        jTitulo1.setFont(TITLE_FONT);
        jTitulo1.setForeground(COLOR_GRIS_BORDER);
        
        jTitulo2 = new JLabel("¡Unete y Apoya!");
        jTitulo2.setAlignmentX(CENTER_ALIGNMENT);
        jTitulo2.setFont(TITLE_FONT);
        jTitulo2.setForeground(COLOR_GRIS_BORDER);
        
        pContenido = new JPanel();
        pContenido.setLayout(new BoxLayout(pContenido, BoxLayout.Y_AXIS));
        pContenido.setBackground(COLOR_PRINCIPAL);
        pFondo.add(pContenido, BorderLayout.CENTER);
        
        pContenido.add(jTitulo);
        pContenido.add(jTitulo1);
        pContenido.add(jTitulo2);
        
        this.add(pFondo);
        
        
    }
    
}
