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

import com.leonet.app.model.user.UserRepository;

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


    private JLabel textDiamante;
    private JLabel textMoneda;


    private Button btnInicio;
    private Button btnBlog;
    private Button btnPvp;
    private Button btnModoCreador;
    private Button btnAyuda;
    private final String TIPO;

    private IconMod diamante;
    private IconMod moneda;
    private UserIcon usuario;

    private UserRepository userProfile;

    private boolean isLogin = false;

    public PnHeader(String tipo) {
        this.TIPO = tipo;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(0, (int) (ALTO * 0.095)));

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
        pCentral.setLayout(new FlowLayout(FlowLayout.CENTER, MARGEN, MARGEN));
        pCentral.setBackground(COLOR_PRINCIPAL);
        pFondoTodo.add(pCentral, BorderLayout.CENTER);

        IconMod iconMod = new IconMod(resUrlBase + "Iconos/logo1.png", (int) (ANCHO * 0.04), (int) (ALTO * 0.07));
        pCentral.add(iconMod);


        btnInicio = new Button(new Dimension((int) (ANCHO * 0.09), (int) (ALTO * 0.05)), "App Educativa", BOTON_CABECERA, (TIPO.equals("INICIO")));
        pCentral.add(btnInicio);


        btnBlog = new Button(new Dimension((int) (ANCHO * 0.04), (int) (ALTO * 0.05)), "Blog", BOTON_CABECERA, (TIPO.equals("BLOG")));
        pCentral.add(btnBlog);

        btnAyuda = new Button(new Dimension((int) (ANCHO * 0.04), (int) (ALTO * 0.05)), "Ayuda", BOTON_CABECERA, (TIPO.equals("AYUDA")));
        pCentral.add(btnAyuda);

        updateHeader();

        this.add(pFondo);

    }

    public void updateHeader() {
        if (isLogin) {
            btnPvp = new Button(new Dimension((int) (ANCHO * 0.03), (int) (ALTO * 0.05)), "PvP", BOTON_CABECERA);
            pCentral.add(btnPvp);

            btnModoCreador = new Button(new Dimension((int) (ANCHO * 0.09), (int) (ALTO * 0.05)), "Modo Creador", BOTON_CABECERA);
            pCentral.add(btnModoCreador);

            JPanel pTemp = new JPanel(new FlowLayout(FlowLayout.RIGHT, MARGEN, 0));
            pTemp.setOpaque(false);
            pCentral.add(pTemp);

            JPanel pTemp1 = new JPanel(new BorderLayout(MARGEN, 0));
            pTemp1.setOpaque(false);
            pTemp.add(pTemp1);

            diamante = new IconMod(resUrlBase + "Iconos/diamante.png", (int) (ANCHO * 0.014), (int) (ALTO * 0.04));
            pTemp1.add(diamante, BorderLayout.WEST);

            textDiamante = new JLabel(userProfile.getGem() + " .g");
            textDiamante.setFont(BUTTON_TEXT_FONT);
            textDiamante.setForeground(COLOR_GRIS_MEDIO);
            pTemp1.add(textDiamante, BorderLayout.CENTER);

            JPanel pTemp2 = new JPanel(new BorderLayout(MARGEN, 0));
            pTemp2.setOpaque(false);
            pTemp.add(pTemp2);

            moneda = new IconMod(resUrlBase + "Iconos/moneda.png", (int) (ANCHO * 0.023), (int) (ALTO * 0.043));
            pTemp2.add(moneda, BorderLayout.WEST);

            textMoneda = new JLabel(userProfile.getCoin() + " .c");
            textMoneda.setFont(BUTTON_TEXT_FONT);
            textMoneda.setForeground(COLOR_GRIS_MEDIO);
            pTemp2.add(textMoneda, BorderLayout.CENTER);


            usuario = new UserIcon(userProfile.getNickname(), userProfile.getLevel());
            pTemp.add(usuario);

        }
        pCentral.updateUI();
    }

    public void updateInfoUser() {
        textDiamante.setText(userProfile.getGem() + " .g");
        textMoneda.setText(userProfile.getCoin() + " .g");
        usuario.updateUser(userProfile.getNickname(), userProfile.getLevel());
    }

    public UserRepository getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserRepository userProfile) {
        this.userProfile = userProfile;
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