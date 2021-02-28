/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.home;


import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.UIComponents;

import java.awt.*;
import javax.swing.*;

/**
 * @author Luis Alfredo
 */
public class PnLeonetApp extends JPanel implements Patron {

    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pLateral;
    private JPanel pLayout;

    private PnContexto pContexto;
    private PnNivel pNivel;
    private PnTop pTop;
    private PnProblema pProblema;
    private PnBotones pBotones;

    public PnLeonetApp() {
        initComponents();
    }

    private void initComponents() {
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.5), (int) (ALTO * 0.5)));
        addPanels();
    }

    private void addPanels() {
        this.setLayout(new BorderLayout());
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN * 25, MARGEN));
        pFondo.setBackground(COLOR_PRINCIPAL);

        UIComponents.marginHorizontal(pFondo);
        UIComponents.marginBottom(pFondo);

        pLayout = new JPanel(new BorderLayout());

        pCentral = new JPanel();
        pCentral.setLayout(new BoxLayout(pCentral, BoxLayout.Y_AXIS));
        pCentral.setBackground(COLOR_PRINCIPAL);
        GridBagConstraints gbc = new GridBagConstraints();

        pContexto = new PnContexto();

        pCentral.add(pContexto);

        pProblema = new PnProblema();
        pCentral.add(pProblema);

        pLateral = new JPanel();
        pLateral.setLayout(new BoxLayout(pLateral, BoxLayout.Y_AXIS));
        pLateral.setBackground(COLOR_PRINCIPAL);
        pLateral.setPreferredSize(new Dimension((int) (ANCHO * 0.17), (int) (ALTO * 0.77)));

        pNivel = new PnNivel();
        pTop = new PnTop();
        pBotones = new PnBotones();

        pLateral.add(pNivel);
        pLateral.add(pTop);
        pLateral.add(pBotones);

        JPanel pnContainerLateral = new JPanel();
        pnContainerLateral.setLayout(new BorderLayout());
        pnContainerLateral.setBackground(COLOR_PRINCIPAL);
        pnContainerLateral.add(pLateral, BorderLayout.NORTH);

        JPanel pnPaddingLateral = new JPanel();
        pnPaddingLateral.setBackground(COLOR_PRINCIPAL);
        pnContainerLateral.add(pnPaddingLateral, BorderLayout.CENTER);

        pLayout.add(pCentral, BorderLayout.CENTER);
        pLayout.add(pnContainerLateral, BorderLayout.EAST);

        pFondo.add(pLayout, BorderLayout.CENTER);
        this.add(pFondo);
    }

    public PnContexto getpContexto() {
        return pContexto;
    }

    public PnNivel getpNivel() {
        return pNivel;
    }

    public PnTop getpTop() {
        return pTop;
    }

    public PnProblema getpProblema() {
        return pProblema;
    }

    public PnBotones getpBotones() {
        return pBotones;
    }
}
