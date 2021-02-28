/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.shared;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Luis Alfredo
 */
public class PnHeader extends JPanel implements Patron {

    private JPanel pFondo;
    private JPanel pFondoTodo;
    private JPanel pCentral;
    private JPanel pMargen;


    private JLabel jIcono;


    private Button btnInicio;
    private Button btnBlog;
    private Button btnPvp;
    private Button btnModoCreador;
    private Button btnAyuda;
    private final String TIPO;

    private ImageIcon icono;

    private boolean isLogin = false;

    public PnHeader(String tipo) {
        this.TIPO = tipo;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension( 0, (int)(ALTO*0.095)));

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pFondo.setBackground(COLOR_PRINCIPAL);

//        pRellenoIzq = new PnRelleno();
//        pFondo.add(pRellenoIzq, BorderLayout.WEST);
//
//        pRellenoDer = new PnRelleno();
//        pFondo.add(pRellenoDer, BorderLayout.EAST);

        pMargen = new JPanel();
        pMargen.setBackground(COLOR_GRIS);
        pMargen.setPreferredSize(new Dimension(0, 3));

        pFondo.add(pMargen, BorderLayout.SOUTH);

        pFondoTodo = new JPanel();
        pFondoTodo.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pFondoTodo.setBackground(COLOR_PRINCIPAL);
        pFondo.add(pFondoTodo, BorderLayout.CENTER);

        pCentral = new JPanel();
        pCentral.setLayout(new FlowLayout(FlowLayout.CENTER, MARGEN * 3, MARGEN));
        pCentral.setBackground(COLOR_PRINCIPAL);
        pFondoTodo.add(pCentral, BorderLayout.CENTER);

        //icono = new ImageIcon(resUrlBase + "Iconos/logo1.png");
        //jIcono = new JLabel();
        // jIcono.setPreferredSize(new Dimension((int) (ANCHO * 0.04), (int) (ALTO * 0.07)));
        // Icon icon = new ImageIcon(icono.getImage().getScaledInstance((int) (ANCHO * 0.04), (int) (ALTO * 0.07), Image.SCALE_DEFAULT));
        //jIcono.setIcon(icon);

        IconMod iconMod = new IconMod(resUrlBase + "Iconos/logo1.png", (int) (ANCHO * 0.04), (int) (ALTO * 0.07));
        pCentral.add(iconMod);


        btnInicio = new Button(new Dimension((int) (ANCHO * 0.09), (int) (ALTO * 0.05)), "App Educativa", BOTON_CABECERA, (TIPO.equals("INICIO")));
        pCentral.add(btnInicio);


        btnBlog = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "Blog", BOTON_CABECERA, (TIPO.equals("BLOG")));
        pCentral.add(btnBlog);


//        btnPvp = new Boton(new Dimension((int) (ANCHO*0.03), (int) (ALTO*0.03)), "PvP", BOTON_CABECERA);
//        pCentral.add(btnPvp);

//        btnModoCreador = new Boton(new Dimension((int) (ANCHO*0.08), (int) (ALTO*0.03)), "Modo Creador", BOTON_CABECERA);
//        pCentral.add(btnModoCreador);
//        
        btnAyuda = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "Ayuda", BOTON_CABECERA, (TIPO.equals("AYUDA")));
        pCentral.add(btnAyuda);

        this.add(pFondo);

    }

    public void colorC(Color c) {
        btnInicio.FOREGROUND = c;
    }

    public Button getBtnInicio() {
        return btnInicio;
    }

    public Button getBtnBlog() {
        return btnBlog;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public Button getBtnAyuda() {
        return btnAyuda;
    }
}
