/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Luis Alfredo
 */
public class PnLogin extends JPanel implements Patron {

    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pEspacio;
    private JPanel pContenido;
    private JPanel pBotones;

    private JPanel pRedondo;

    private ImageIcon icono;

    private JLabel jIcono;
    private JLabel jUsuario;
    private JLabel jContrasenia;
    private JLabel jOlvido;
    private JLabel jMensajeError;

    private TextField cUsuario;
    private TextField cContrasenia;

    private Boton btnCrearCuenta;
    private Boton btnIniciarSesion;
    private Dimension dimBtns;

    public PnLogin() {
//        super(0, COLOR_VERDE, COLOR_VERDE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        //pFondo.setPreferredSize(new Dimension((int) (ANCHO * 0.0), (int) (ALTO * 0.35)));

        pRedondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_GRIS_BORDE);
        pRedondo.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pFondo.add(pRedondo, BorderLayout.CENTER);

        pEspacio = new JPanel();
        pEspacio.setLayout(new BorderLayout(MARGEN * 3, MARGEN * 2));
        pEspacio.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pEspacio, BorderLayout.CENTER);
        hacerMargenes();

        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout());
        pCentral.setBackground(COLOR_PRINCIPAL);
        pEspacio.add(pCentral, BorderLayout.CENTER);

        //icono = new ImageIcon(resUrlBase + "Iconos/imagenlogin.png");
        //jIcono = new JLabel();
        //jIcono.setPreferredSize(new Dimension((int) (ANCHO * 0.12), (int) (ALTO * 0.24)));
        //Icon icon = new ImageIcon(icono.getImage().getScaledInstance((int) (ANCHO * 0.15), (int) (ALTO * 0.24), Image.SCALE_DEFAULT));
        //jIcono.setIcon(icon);
        //jIcono.setHorizontalAlignment(SwingConstants.CENTER);
        IconMod iconMod = new IconMod(resUrlBase + "Iconos/imagenlogin.png", (int) (ANCHO * 0.15), (int) (ALTO * 0.24));
        pCentral.add(iconMod, BorderLayout.NORTH);

        pContenido = new JPanel();
        pContenido.setLayout(new GridLayout(6, 0));
        pContenido.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pContenido, BorderLayout.CENTER);

        jUsuario = new JLabel("Usuario");
        jUsuario.setFont(CIUDATELLA_LIGHT);
        jUsuario.setForeground(COLOR_OSCURO_TITULOS);
        pContenido.add(jUsuario);

        cUsuario = new TextField(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.07)), "");
        pContenido.add(cUsuario);

        jContrasenia = new JLabel("Contraseña");
        jContrasenia.setFont(CIUDATELLA_LIGHT);
        jContrasenia.setForeground(COLOR_OSCURO_TITULOS);
        pContenido.add(jContrasenia);

        cContrasenia = new TextField(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.07)), "", true);
        pContenido.add(cContrasenia);

        jOlvido = new JLabel("¿Olvidaste la Contraseña?");
        jOlvido.setFont(CIUDATELLA_MEDIUM);
        jOlvido.setForeground(COLOR_GRIS_CLARO);
        pContenido.add(jOlvido);

        jMensajeError = new JLabel("INGRESA TUS CREDENCIALES");
        jMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
        jMensajeError.setFont(CIUDATELLA_MEDIUM);
        jMensajeError.setForeground(COLOR_VERDE_MEDIO);
        pContenido.add(jMensajeError);

        pBotones = new JPanel();
        pBotones.setLayout(new FlowLayout(FlowLayout.CENTER, MARGEN * 5, MARGEN_2));
        pBotones.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pBotones, BorderLayout.SOUTH);
        dimBtns = new Dimension((int) (ANCHO * 0.09), (int) (ALTO * 0.05));

        btnCrearCuenta = new Boton(dimBtns, "Crear Cuenta", BOTON_CREAR_CUENTA);
        pBotones.add(btnCrearCuenta);

        btnIniciarSesion = new Boton(dimBtns, "Iniciar Sesión", BOTON_SIGUIENTE);
        pBotones.add(btnIniciarSesion);

        this.add(pFondo);
    }

    public void colorRojo() {
        jMensajeError.setForeground(COLOR_ROJO);
    }

    private void hacerMargenes() {
        int i = 0;
        JPanel izq = new JPanel();
        izq.setOpaque(false);
        izq.setPreferredSize(new Dimension(i, i));
        pRedondo.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setPreferredSize(new Dimension(i, i));
        pRedondo.add(der, BorderLayout.EAST);

        JPanel nor = new JPanel();
        nor.setPreferredSize(new Dimension(i, i));
        pRedondo.add(nor, BorderLayout.NORTH);

        JPanel sur = new JPanel();
        sur.setPreferredSize(new Dimension(i, i));
        pRedondo.add(sur, BorderLayout.SOUTH);

        JPanel izq1 = new JPanel();
        izq1.setOpaque(false);
        izq1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(izq1, BorderLayout.WEST);

        JPanel der1 = new JPanel();
        der1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(der1, BorderLayout.EAST);

        JPanel nor1 = new JPanel();
        nor1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(nor1, BorderLayout.NORTH);

        JPanel sur1 = new JPanel();
        sur1.setPreferredSize(new Dimension(i, i));
        pEspacio.add(sur1, BorderLayout.SOUTH);

        int f = 10;
//        JPanel sur2 = new JPanel();
//        sur2.setPreferredSize(new Dimension(0, f));
//        sur2.setBackground(COLOR_PRINCIPAL);
//        pFondo.add(sur2, BorderLayout.SOUTH);

        JPanel izq2 = new JPanel();
        izq2.setPreferredSize(new Dimension(f, 0));
        izq2.setBackground(COLOR_PRINCIPAL);
        izq2.setOpaque(false);
        pFondo.add(izq2, BorderLayout.WEST);

        JPanel der2 = new JPanel();
        der2.setPreferredSize(new Dimension(f, 0));
        der2.setBackground(COLOR_PRINCIPAL);
        pFondo.add(der2, BorderLayout.EAST);
    }

    public Boton getBtnInicarSesion() {
        return btnIniciarSesion;
    }

    public Boton getBtnCrearCuenta() {
        return btnCrearCuenta;
    }

    public JLabel gerLabelOlvidoContrasenia() {
        return jOlvido;
    }

    public String getUsuario() {
        return cUsuario.getTxtField().getText();
    }

    public String getContrasenia() {
        return cContrasenia.getTxtField().getText();
    }

    public JLabel getjMensajeError() {
        return jMensajeError;
    }

    public TextField getcUsuario() {
        return cUsuario;
    }
}
