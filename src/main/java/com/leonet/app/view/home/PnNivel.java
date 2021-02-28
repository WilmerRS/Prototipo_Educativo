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

import com.leonet.app.view.shared.LoadingBar;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.RoundedPanel;
import com.leonet.app.view.shared.UIComponents;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Luis Alfredo
 */
public class PnNivel extends JPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pCentralComp;
    private JPanel pTitulo;
    private JPanel pLinea;
    private JPanel pMargenes;
    
    private RoundedPanel pRedondo;

    private LoadingBar loadingBar;
    
    private JLabel lbTitle;
    private JLabel lbGain;
    private JLabel lbChallenge;
    private JLabel lbFreeMode;
    
    public PnNivel() {
        initComponents();
    }
    
    private void initComponents() {

        this.setLayout(new BorderLayout());
        //this.setPreferredSize(new Dimension(0,(int)(ALTO*0.15)));
        //this.setMinimumSize(new Dimension(0,(int)(ALTO*0.15)));

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));
        pFondo.setBackground(COLOR_PRINCIPAL);

        pRedondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_GRIS_BORDER);
        pRedondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));
        pFondo.add(pRedondo, BorderLayout.CENTER);

        pMargenes = new JPanel();
        pMargenes.setLayout(new BorderLayout());
        pMargenes.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pMargenes, BorderLayout.CENTER);

        UIComponents.marginAll(pRedondo);
        UIComponents.marginTop(pFondo);
        UIComponents.marginLeft(pFondo);

        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pCentral.setBackground(COLOR_PRINCIPAL);
        pMargenes.add(pCentral, BorderLayout.CENTER);

        pTitulo = new JPanel();
        pTitulo.setLayout(new BorderLayout());
        pTitulo.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pTitulo, BorderLayout.NORTH);

        lbTitle = new JLabel("NIVEL 1: TEMA 1");
        lbTitle.setFont(TITLE_FONT);
        lbTitle.setForeground(COLOR_GRIS_OSCURO);
        pTitulo.add(lbTitle, BorderLayout.NORTH);

        pLinea = UIComponents.lineSeparator(1, COLOR_GRIS_BORDER);
        pTitulo.add(pLinea, BorderLayout.SOUTH);

        pCentralComp = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pCentralComp.setBackground(COLOR_PRINCIPAL);

        /**loadingBar = new LoadingBar(new Dimension(0, (int) (ALTO * 0.022)),
                "Porcentaje de avance:", 25, 50);*/


        JPanel pnGrid = new JPanel(new GridLayout(0, 1));
        pnGrid.setBackground(COLOR_PRINCIPAL);

        lbGain = new JLabel("Logros >");
        lbGain.setFont(SUBTITlE3_FONT);
        lbGain.setForeground(COLOR_GRIS_OSCURO);

        lbChallenge = new JLabel("Retos >");
        lbChallenge.setFont(SUBTITlE3_FONT);
        lbChallenge.setForeground(COLOR_GRIS_OSCURO);

        lbFreeMode = new JLabel("Cambiar al MODO LIBRE");
        lbFreeMode.setFont(SUBTITlE2_FONT);
        lbFreeMode.setForeground(COLOR_AZUL_BOTON);

        pnGrid.add(lbGain);
        pnGrid.add(lbChallenge);
        pnGrid.add(lbFreeMode);

        pCentralComp.add(pnGrid, BorderLayout.CENTER);

        pCentral.add(pCentralComp, BorderLayout.CENTER);
        
        this.add(pFondo);
    }

    public LoadingBar getLoadingBar() {
        return loadingBar;
    }

    public  void updateLoadingBar(int startingPoint, int finalPoint){
        loadingBar = new LoadingBar(new Dimension(0, (int) (ALTO * 0.022)),
                "Porcentaje de avance:", startingPoint, finalPoint);
        pCentralComp.add(loadingBar, BorderLayout.NORTH);
    }
}
