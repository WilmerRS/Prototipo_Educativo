/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.login;

import com.leonet.app.view.home.PnBotones;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.PnCabecera2;
import com.leonet.app.view.shared.PnInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Luis Alfredo
 */
public class ViewLogin extends JFrame implements Patron {

    private JPanel pFondo;
    private JPanel pAux;
    private JPanel pRelleno;

    private PnCabecera2 pCabecera;
    private PnBotones.ViewPrincipal ViewPrincipal;
    private PnInfo pInformacion;
    private PnLogin pLogin;

    private String titulo = "Login";

    public boolean acceso = false;

    public ViewLogin() {
        initComponent();
        this.setLocationRelativeTo(null);
    }

    private void initComponent() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.35), (int) (ALTO * 0.5)));
        this.setTitle(titulo);
        this.setIconImage(new ImageIcon(resUrlBase + "Iconos/logo1.png").getImage());
        paneles();
    }

    private void paneles() {

        this.setLayout(new BorderLayout());

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN, MARGEN * 2));
        pFondo.setBackground(COLOR_PRINCIPAL);
        pFondo.setPreferredSize(new Dimension((int) (ANCHO * 0.3), (int) (ALTO * 0.85)));

        pCabecera = new PnCabecera2("INICIO");
        pFondo.add(pCabecera, BorderLayout.NORTH);

        pLogin = new PnLogin();
        pFondo.add(pLogin, BorderLayout.CENTER);

        pAux = new JPanel();
        pAux.setLayout(new BorderLayout());

        pInformacion = new PnInfo();
        pAux.add(pInformacion, BorderLayout.CENTER);

        pRelleno = new JPanel();
        pRelleno.setPreferredSize(new Dimension((int) (ANCHO * 0.0), (int) (ALTO * 0.02)));
        pRelleno.setBackground(COLOR_PRINCIPAL);
        pAux.add(pRelleno, BorderLayout.SOUTH);

        pFondo.add(pAux, BorderLayout.SOUTH);
        pCabecera.colorC(COLOR_AZUL_BOTON);
        pCabecera.updateUI();

        this.add(pFondo);
        pack();
    }



    public PnCabecera2 getpCabecera() {
        return pCabecera;
    }

    public PnLogin getpLogin() {
        return pLogin;
    }

}
