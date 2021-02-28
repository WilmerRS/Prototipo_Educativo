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

import com.leonet.app.view.shared.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Luis Alfredo
 */
public class PnLogin extends JPanel implements Patron {

    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pEspacio;
    private JPanel pContenido;
    private JPanel pBotones;
    private JPanel pRedondo;

    private JLabel jUsuario;
    private JLabel jContrasenia;
    private JLabel jOlvido;
    private JLabel jMensajeError;
    private JPanel pnBackground;
    private JLabel titleLogin;

    private TextField cUsuario;
    private TextField cContrasenia;

    private PnFooter pnFooter;

    private Button btnCrearCuenta;
    private Button btnIniciarSesion;


    public PnLogin() {
        initComponent();
    }

    private void initComponent() {
        this.setLayout(new BorderLayout());

        pnBackground = new JPanel();
        pnBackground.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnBackground.setBackground(COLOR_PRINCIPAL);

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN, MARGEN));
        pFondo.setBackground(COLOR_PRINCIPAL);
        pFondo.setPreferredSize(new Dimension((int) (ANCHO * 0.3), (int) (ALTO * 0.65)));

        pRedondo = new RoundedPanel(RADIO,COLOR_PRINCIPAL, COLOR_GRIS_BORDER);
        pRedondo.setLayout(new BorderLayout(MARGEN_2*4, MARGEN_2*4));
        pFondo.add(pRedondo, BorderLayout.CENTER);

        pEspacio = new JPanel();
        pEspacio.setLayout(new BorderLayout());
        pEspacio.setBackground(COLOR_AZUL_BOTON);
        pRedondo.add(pEspacio, BorderLayout.CENTER);

        UIComponents.marginAll(pRedondo);
        UIComponents.marginAll(pFondo);

        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pCentral.setBackground(COLOR_PRINCIPAL);
        pEspacio.add(pCentral, BorderLayout.CENTER);

        JPanel pnIcon = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pnIcon.setBackground(COLOR_PRINCIPAL);

        titleLogin = new JLabel("INICIAR SESIÓN");
        titleLogin.setFont(TITLE_FONT);
        titleLogin.setForeground(COLOR_GRIS_MEDIO);
        titleLogin.setHorizontalAlignment(SwingConstants.CENTER);
        pnIcon.add(titleLogin, BorderLayout.NORTH);

        IconMod iconMod = new IconMod(resUrlBase + "Iconos/login.png", (int) (ANCHO * 0.15),(int) (ALTO * 0.25));
        pnIcon.add(iconMod, BorderLayout.CENTER);

        jMensajeError = new JLabel("INGRESA TUS CREDENCIALES");
        jMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
        jMensajeError.setFont(CONTENT_FONT);
        jMensajeError.setForeground(COLOR_VERDE_MEDIO);
        pnIcon.add(jMensajeError, BorderLayout.SOUTH);

        pCentral.add(pnIcon, BorderLayout.NORTH);

        pContenido = new JPanel();
        pContenido.setLayout(new GridLayout(0, 1, MARGEN, MARGEN));
        pContenido.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pContenido, BorderLayout.CENTER);

        // Panel usuario
        JPanel tempUserContainer = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        tempUserContainer.setBackground(COLOR_PRINCIPAL);

        jUsuario = new JLabel("Usuario o correo electrónico:");
        jUsuario.setFont(SUBTITlE3_FONT);
        jUsuario.setForeground(COLOR_GRIS_OSCURO);

        cUsuario = new TextField(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.07)), "");

        tempUserContainer.add(jUsuario, BorderLayout.NORTH);
        tempUserContainer.add(cUsuario, BorderLayout.CENTER);
        pContenido.add(tempUserContainer);

        //Panel Contraseña
        JPanel tempPassContainer = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        tempPassContainer.setBackground(COLOR_PRINCIPAL);

        jContrasenia = new JLabel("Contraseña:");
        jContrasenia.setFont(SUBTITlE3_FONT);
        jContrasenia.setForeground(COLOR_GRIS_OSCURO);

        cContrasenia = new TextField(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.07)), "", true);

        tempPassContainer.add(jContrasenia, BorderLayout.NORTH);
        tempPassContainer.add(cContrasenia, BorderLayout.CENTER);
        pContenido.add(tempPassContainer);

        // Panel información
        JPanel tempInfoContainer = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        tempInfoContainer.setBackground(COLOR_PRINCIPAL);

        jOlvido = new JLabel("¿Olvidaste la Contrasenia?");
        jOlvido.setFont(SUBTITlE3_FONT);
        jOlvido.setForeground(COLOR_GRIS_MEDIO);

        tempInfoContainer.add(jOlvido, BorderLayout.NORTH);

        // Panel de botones
        pBotones = new JPanel();
        pBotones.setLayout(new FlowLayout(FlowLayout.CENTER, MARGEN * 5, MARGEN_2));
        pBotones.setBackground(COLOR_PRINCIPAL);

        btnCrearCuenta = new Button(new Dimension((int) (ANCHO * 0.08), (int) (ALTO * 0.05)), "Crear Cuenta", GRAY_BUTTON);
        pBotones.add(btnCrearCuenta);

        btnIniciarSesion = new Button(new Dimension((int) (ANCHO * 0.09), (int) (ALTO * 0.05)), "Iniciar Sesion", BLUE_BUTTON);
        pBotones.add(btnIniciarSesion);

        tempInfoContainer.add(pBotones, BorderLayout.CENTER);
        pCentral.add(tempInfoContainer, BorderLayout.SOUTH);

        pnBackground.add(pFondo);

        pnFooter = new PnFooter();

        this.add(pnBackground, BorderLayout.NORTH);
        this.add(pnFooter, BorderLayout.CENTER);
    }

    public void invalidCredentials() {
        jMensajeError.setText("CREDENCIALES INVÁLIDAS");
        jMensajeError.setForeground(COLOR_ROJO);
        System.out.println("* Contraseña errada. * CLASS: PnLogin 178");
    }

    public void resetMessageCredentials() {
        jMensajeError.setText("INGRESA TUS CREDENCIALES");
        jMensajeError.setForeground(COLOR_VERDE_MEDIO);
    }

    public Button getBtnInicarSesion() {
        return btnIniciarSesion;
    }

    public Button getBtnCrearCuenta() {
        return btnCrearCuenta;
    }


    public String getUsuario() {
        return cUsuario.getText();
    }

    public String getContrasenia() {
        return cContrasenia.getText();
    }

    public JLabel getjMensajeError() {
        return jMensajeError;
    }

    public TextField getcUsuario() {
        return cUsuario;
    }
}
