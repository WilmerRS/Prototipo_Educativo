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
import javax.swing.JPanel;

/**
 *
 * @author Luis Alfredo
 */
public class PnRelleno extends JPanel implements Patron{
    
    private JPanel pFondo;

    
    public PnRelleno(){
        super();
        iniciarComponentes();
    }
    
   public void iniciarComponentes(){
        paneles();
    }
    
    private void paneles(){
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setPreferredSize(new Dimension((int) (ANCHO*0.15),0));
        pFondo.setBackground(COLOR_PRINCIPAL);
        this.add(pFondo);
    }
}
