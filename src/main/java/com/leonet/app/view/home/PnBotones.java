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

import com.leonet.app.view.shared.*;
import com.leonet.app.view.shared.Button;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Luis Alfredo
 */
public class PnBotones extends JPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pBotones;
    
    private Button btnAnt;
    private Button btnSig;
    
    private PnFooter pnFooter;
    
    public PnBotones() {
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_PRINCIPAL);
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN, MARGEN));
        pFondo.setBackground(COLOR_PRINCIPAL);

        UIComponents.marginVertical(pFondo);
        UIComponents.marginLeft(pFondo);
        
        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout());
        pFondo.add(pCentral, BorderLayout.CENTER);
        
        pBotones = new JPanel();
        pBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        pBotones.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pBotones, BorderLayout.NORTH);
        
        btnAnt = new Button(new Dimension((int) (ANCHO*0.07), (int) (ALTO*0.05)), "ANTERIOR", ORANGE_BUTTON);
        pBotones.add(btnAnt);
        
        btnSig = new Button(new Dimension((int) (ANCHO*0.07), (int) (ALTO*0.05)), "SIGUIENTE", BLUE_BUTTON);
        pBotones.add(btnSig);

        pnFooter = new PnFooter();
        pCentral.add(pnFooter, BorderLayout.CENTER);

        this.add(pFondo);
    }

    public Button getBtnAnt() {
        return btnAnt;
    }

    public Button getBtnSig() {
        return btnSig;
    }
}
