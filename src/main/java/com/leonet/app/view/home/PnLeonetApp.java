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


import com.leonet.app.view.home.*;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.PnRelleno;
import com.leonet.app.view.shared.PnRellenoSur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Luis Alfredo
 */
public class PnLeonetApp extends JPanel implements Patron {

    private JPanel pFondo;
    private JPanel pCentral;

    private PnContexto pContexto;
    private PnNivel pNivel;
    private PnTop pTop;
    private PnProblema pProblema;
    private PnBotones pBotones;

    private PnRelleno pRellenoDer;
    private PnRelleno pRellenoIzq;
    private PnRellenoSur pRellenoSur;

    private String titulo = "App Educativa";

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
        pFondo.setLayout(new BorderLayout(MARGEN * 5, MARGEN));
        pFondo.setBackground(COLOR_PRINCIPAL);
        pFondo.setPreferredSize(new Dimension((int) (ANCHO * 0.8), (int) (ALTO * 0.8)));

        pRellenoIzq = new PnRelleno();
        pFondo.add(pRellenoIzq, BorderLayout.WEST);

        pRellenoDer = new PnRelleno();
        pFondo.add(pRellenoDer, BorderLayout.EAST);

        pRellenoSur = new PnRellenoSur();
        pFondo.add(pRellenoSur, BorderLayout.SOUTH);

        pCentral = new JPanel();
        pCentral.setLayout(new GridBagLayout());
        pCentral.setBackground(COLOR_PRINCIPAL);
        GridBagConstraints gbc = new GridBagConstraints();

        pFondo.add(pCentral, BorderLayout.CENTER);
        pContexto = new PnContexto();
        gbc.gridx = 0; // El área de texto empieza en la columna cero.
        gbc.gridy = 0; // El área de texto empieza en la fila cero
        gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
        gbc.gridheight = 3; // El área de texto ocupa 2 filas.
        gbc.weighty = 2.0;
        gbc.weightx = 2.0;
        gbc.fill = gbc.BOTH;
        pCentral.add(pContexto, gbc);

        pProblema = new PnProblema();
        gbc.gridx = 0; // El área de texto empieza en la columna cero.
        gbc.gridy = 3; // El área de texto empieza en la fila cero
        gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
        gbc.gridheight = 6; // El área de texto ocupa 2 filas.
        gbc.weighty = 2.0;
        gbc.weightx = 2.0;
        gbc.fill = gbc.BOTH;
        pCentral.add(pProblema, gbc);

        gbc.weighty = 0.0;
        gbc.weightx = 0.3;

        pNivel = new PnNivel();
        gbc.gridx = 6; // El área de texto empieza en la columna cero.
        gbc.gridy = 0; // El área de texto empieza en la fila cero
        gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
        gbc.gridheight = 2; // El área de texto ocupa 2 filas.
        gbc.fill = gbc.BOTH;
        pCentral.add(pNivel, gbc);

        pTop = new PnTop();
        gbc.gridx = 6; // El área de texto empieza en la columna cero.
        gbc.gridy = 2; // El área de texto empieza en la fila cero
        gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
        gbc.gridheight = 2; // El área de texto ocupa 2 filas.
        gbc.fill = gbc.BOTH;
        pCentral.add(pTop, gbc);

        pBotones = new PnBotones();
        gbc.gridx = 6; // El área de texto empieza en la columna cero.
        gbc.gridy = 5; // El área de texto empieza en la fila cero
        gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
        gbc.gridheight = 4; // El área de texto ocupa 2 filas.
        gbc.fill = gbc.BOTH;
        pCentral.add(pBotones, gbc);

        this.add(pFondo);
    }

}
