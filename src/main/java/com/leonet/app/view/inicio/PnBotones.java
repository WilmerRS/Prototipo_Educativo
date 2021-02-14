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

import com.leonet.app.view.paneles_aux.Boton;
import com.leonet.app.view.paneles_aux.Patron;
import com.leonet.app.view.paneles_aux.PnInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author Luis Alfredo
 */
public class PnBotones extends JPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pBotones;
    private JPanel pInfo;
    
    private Boton btnAnt;
    private Boton btnSig;
    
    private PnInfo pInformacion;
    
    public PnBotones() {
        super();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        
        hacerMargenes();
        
        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout());
        pFondo.add(pCentral, BorderLayout.CENTER);
        
        pBotones = new JPanel();
        pBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        pBotones.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pBotones, BorderLayout.NORTH);
        
        btnAnt = new Boton(new Dimension((int) (ANCHO*0.07), (int) (ALTO*0.06)), "ANTERIOR", BOTON_ANTERIOR);
        pBotones.add(btnAnt);
        
        btnSig = new Boton(new Dimension((int) (ANCHO*0.07), (int) (ALTO*0.06)), "SIGUIENTE", BOTON_SIGUIENTE);
        pBotones.add(btnSig);
        
        pInformacion = new PnInfo();
        pCentral.add(pInformacion, BorderLayout.CENTER);
        
        this.add(pFondo);
        
    }
    
     private void hacerMargenes(){
        int f=10;
        JPanel nor1 = new JPanel();
        nor1.setPreferredSize(new Dimension(0, f));
        nor1.setBackground(COLOR_PRINCIPAL);
        pFondo.add(nor1, BorderLayout.NORTH);
        
        JPanel izq1 = new JPanel();
        izq1.setPreferredSize(new Dimension(f, 0));
        izq1.setBackground(COLOR_PRINCIPAL);
        pFondo.add(izq1, BorderLayout.WEST);
    }
    
}
