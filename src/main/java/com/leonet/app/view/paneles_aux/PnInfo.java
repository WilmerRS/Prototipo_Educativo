/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.paneles_aux;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Luis Alfredo
 */
public class PnInfo extends JPanel implements Patron{
    
    private JPanel pFondo;
    private JPanel pContenido;
    
    private JLabel jTitulo;
    private JLabel jTitulo1;
    private JLabel jTitulo2;
    
    public PnInfo() {
        super();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        
        jTitulo = new JLabel("Acerca de * Aplicaciones");
        jTitulo.setAlignmentX(CENTER_ALIGNMENT);
        jTitulo.setFont(CIUDATELLA_BOLD);
        jTitulo.setForeground(COLOR_GRIS_BORDE);
        
        jTitulo1 = new JLabel("Terminos * Condiciones");
        jTitulo1.setAlignmentX(CENTER_ALIGNMENT);
        jTitulo1.setFont(CIUDATELLA_BOLD);
        jTitulo1.setForeground(COLOR_GRIS_BORDE);
        
        jTitulo2 = new JLabel("¡Unete y Apoya!");
        jTitulo2.setAlignmentX(CENTER_ALIGNMENT);
        jTitulo2.setFont(CIUDATELLA_BOLD);
        jTitulo2.setForeground(COLOR_GRIS_BORDE);
        
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
