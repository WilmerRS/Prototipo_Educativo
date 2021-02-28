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

import com.leonet.app.view.shared.Button;
import com.leonet.app.view.shared.IconMod;
import com.leonet.app.view.shared.Patron;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luis Alfredo
 */
public class PnCabecera extends JPanel implements Patron {

    private JPanel pFondo;
    private JPanel pFondoTodo;
    private JPanel pCentral;
    private JPanel pMargen;
    private JPanel pNick;


    private JLabel jIcono;
    private JLabel jNick;
    private JLabel jMoneda;
    private JLabel jDiamante;
    private JLabel imagenMoneda;
    private JLabel imagenDiamante;
    private JLabel c;
    private JLabel g;

    private Button btnInicio;
    private Button btnBlog;
    private Button btnPvp;
    private Button btnModoCreador;
    private Button btnAyuda;

    private ImageIcon icono;
    private ImageIcon icono2;
    private ImageIcon icono3;
    private ImageIcon icono4;

    public PnCabecera() {
        super();
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pFondo.setBackground(COLOR_PRINCIPAL);

        /**pRellenoIzq = new PnRelleno();
        pFondo.add(pRellenoIzq, BorderLayout.WEST);

        pRellenoDer = new PnRelleno();
        pFondo.add(pRellenoDer, BorderLayout.EAST);*/

        pMargen = new JPanel();
        pMargen.setBackground(COLOR_GRIS);
        pMargen.setPreferredSize(new Dimension(0, 3));

        pFondo.add(pMargen, BorderLayout.SOUTH);

        pFondoTodo = new JPanel();
        pFondoTodo.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pFondoTodo.setBackground(COLOR_PRINCIPAL);
        pFondo.add(pFondoTodo, BorderLayout.CENTER);

        pCentral = new JPanel();
        pCentral.setLayout(new FlowLayout(FlowLayout.LEFT, MARGEN, MARGEN));
        pCentral.setBackground(COLOR_PRINCIPAL);
        pFondoTodo.add(pCentral, BorderLayout.CENTER);

        IconMod iconMod = new IconMod(resUrlBase + "Iconos//logo1.png", (int) (ANCHO * 0.04), (int) (ALTO * 0.07));
        pCentral.add(iconMod);

        btnInicio = new Button(new Dimension((int) (ANCHO * 0.08), (int) (ALTO * 0.03)), "App Educativa", BOTON_CABECERA);
        pCentral.add(btnInicio);

        btnBlog = new Button(new Dimension((int) (ANCHO * 0.03), (int) (ALTO * 0.03)), "blog", BOTON_CABECERA);
        pCentral.add(btnBlog);

        btnPvp = new Button(new Dimension((int) (ANCHO * 0.03), (int) (ALTO * 0.03)), "PvP", BOTON_CABECERA);
        pCentral.add(btnPvp);

        btnModoCreador = new Button(new Dimension((int) (ANCHO * 0.08), (int) (ALTO * 0.03)), "Modo Creador", BOTON_CABECERA);
        pCentral.add(btnModoCreador);

        btnAyuda = new Button(new Dimension((int) (ANCHO * 0.04), (int) (ALTO * 0.03)), "ayuda", BOTON_CABECERA);
        pCentral.add(btnAyuda);

        pNick = new JPanel();
        pNick.setLayout(new FlowLayout(FlowLayout.LEFT, MARGEN, MARGEN_2));
        pNick.setBackground(COLOR_PRINCIPAL);
        pFondoTodo.add(pNick, BorderLayout.EAST);

        iconMod = new IconMod(resUrlBase + "Iconos/moneda.png", (int) (ANCHO * 0.02), (int) (ALTO * 0.034));
        pNick.add(iconMod);

        jMoneda = new JLabel("50");
        jMoneda.setFont(TITLE_FONT);
        jMoneda.setForeground(COLOR_GRIS_CLARO);
        pNick.add(jMoneda);

        c = new JLabel(".c");
        c.setFont(TITLE_FONT);
        c.setForeground(COLOR_GRIS_CLARO);
        pNick.add(c);

        iconMod = new IconMod(resUrlBase + "Iconos/diamante.png", (int) (ANCHO * 0.014), (int) (ALTO * 0.04));
        pNick.add(iconMod);

        jDiamante = new JLabel("5.0");
        jDiamante.setFont(TITLE_FONT);
        jDiamante.setForeground(COLOR_GRIS_CLARO);
        pNick.add(jDiamante);

        g = new JLabel(".g");
        g.setFont(TITLE_FONT);
        g.setForeground(COLOR_GRIS_CLARO);
        pNick.add(g);

        iconMod = new IconMod(resUrlBase + "Iconos/nick.png", (int) (ANCHO * 0.10), (int) (ALTO * 0.08));
        pNick.add(iconMod);

        this.add(pFondo);

    }

    public Button getbtnInicio() {
        return btnInicio;
    }

    public Button getbtnBlog() {
        return btnBlog;
    }

    public Button getbtnPvp() {
        return btnPvp;
    }

    public Button getbtnModoCreador() {
        return btnModoCreador;
    }

    public Button getbtnAyuda() {
        return btnAyuda;
    }
}
