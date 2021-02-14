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

import com.leonet.app.view.blog.ViewBlog;
import com.leonet.app.view.inicio.ViewPrincipal;
import com.leonet.app.view.paneles_aux.Patron;
import com.leonet.app.view.paneles_aux.PnCabecera2;
import com.leonet.app.view.paneles_aux.PnInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private ViewPrincipal ViewPrincipal;
    private PnInfo pInformacion;
    private ViewBlog ViewBlog;
    private PnLogin pLogin;

    private String titulo = "Login";

    public boolean acceso = false;

    public ViewLogin() {
        iniciarComponentes();
        this.setLocationRelativeTo(null);
    }

    private void iniciarComponentes() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.3), (int) (ALTO * 0.5)));
        this.setTitle(titulo);
        this.setIconImage(new ImageIcon(resUrlBase + "Iconos\\logo1.png").getImage());
        paneles();
        agregarEventos();

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

    private void agregarEventos() {

        ActionListener clickBlog = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBlog = new ViewBlog();
                ViewBlog.setVisible(true);
                ocultarLogin();
            }

        };
        pCabecera.getBtnBlog().addActionListener(clickBlog);

        pLogin.getcUsuario().getTxtField().requestFocus(true);
    }

    private void ocultarLogin() {
        try {
            this.setVisible(false);
        } catch (Exception e) {
        }
    }

    public PnLogin getpLogin() {
        return pLogin;
    }

}
