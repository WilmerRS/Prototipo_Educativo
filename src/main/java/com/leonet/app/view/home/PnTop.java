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

import com.leonet.app.view.shared.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
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

    private ScrollPane jScroll;

    public PnTop() {
        initComponents();
    }

    private void initComponents() {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(0, (int) (ALTO * 0.35)));

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));
        pFondo.setBackground(COLOR_PRINCIPAL);

        pRedondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_GRIS_BORDER);
        pRedondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));
        pFondo.add(pRedondo, BorderLayout.CENTER);

        pEspacio = new JPanel();
        pEspacio.setLayout(new BorderLayout());
        pEspacio.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pEspacio, BorderLayout.CENTER);

        pCentral = new JPanel(new BorderLayout());
        pCentral.setBackground(COLOR_PRINCIPAL);
        pEspacio.add(pCentral, BorderLayout.CENTER);

        UIComponents.marginAll(pRedondo);
        UIComponents.marginTop(pFondo);
        UIComponents.marginLeft(pFondo);

        pTitulo = new JPanel(new BorderLayout());
        pTitulo.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pTitulo, BorderLayout.NORTH);

        jTitulo = new JLabel("TOP 10");
        jTitulo.setFont(TITLE_FONT);
        jTitulo.setForeground(COLOR_GRIS_OSCURO);
        pTitulo.add(jTitulo, BorderLayout.NORTH);

        JPanel tempLinea = UIComponents.lineSeparator(1, COLOR_GRIS_BORDER);
        pTitulo.add(tempLinea, BorderLayout.SOUTH);

        pContenido = new JPanel();
        pContenido.setBackground(COLOR_PRINCIPAL);
        pContenido.setMaximumSize(new Dimension(0, 300));
        pContenido.setLayout(new BorderLayout());

        TextPane textPane = new TextPane("", COLOR_PRINCIPAL);

        IconMod iconTop = new IconMod(resUrlBase + "Iconos/top.png", 200,200);
        jScroll = new ScrollPane(iconTop,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pContenido.add(jScroll, BorderLayout.CENTER);


        pCentral.add(pContenido, BorderLayout.CENTER);

        this.add(pFondo);
    }
}