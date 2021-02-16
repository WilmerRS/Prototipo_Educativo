/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.inicio;

import com.leonet.app.view.paneles_aux.Boton;
import com.leonet.app.view.paneles_aux.IconMod;
import com.leonet.app.view.paneles_aux.Patron;
import com.leonet.app.view.paneles_aux.PnRelleno;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.Icon;
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

    private PnRelleno pRellenoDer;
    private PnRelleno pRellenoIzq;
    private PnRelleno pRelleno;

    private JLabel jIcono;
    private JLabel jNick;
    private JLabel jMoneda;
    private JLabel jDiamante;
    private JLabel imagenMoneda;
    private JLabel imagenDiamante;
    private JLabel c;
    private JLabel g;

    private Boton btnInicio;
    private Boton btnBlog;
    private Boton btnPvp;
    private Boton btnModoCreador;
    private Boton btnAyuda;

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

        pRellenoIzq = new PnRelleno();
        pFondo.add(pRellenoIzq, BorderLayout.WEST);

        pRellenoDer = new PnRelleno();
        pFondo.add(pRellenoDer, BorderLayout.EAST);

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

        //icono = new ImageIcon(resUrlBase + "Iconos/logo1.png");
        //jIcono = new JLabel();
        //jIcono.setPreferredSize(new Dimension((int) (ANCHO * 0.04), (int) (ALTO * 0.07)));
        //Icon icon = new ImageIcon(icono.getImage().getScaledInstance((int) (ANCHO * 0.04), (int) (ALTO * 0.07), Image.SCALE_DEFAULT));
        //jIcono.setIcon(icon);

        IconMod iconMod = new IconMod(resUrlBase + "Iconos//logo1.png", (int) (ANCHO * 0.04), (int) (ALTO * 0.07));
        pCentral.add(iconMod);

        btnInicio = new Boton(new Dimension((int) (ANCHO * 0.08), (int) (ALTO * 0.03)), "App Educativa", BOTON_CABECERA);
        pCentral.add(btnInicio);

        btnBlog = new Boton(new Dimension((int) (ANCHO * 0.03), (int) (ALTO * 0.03)), "blog", BOTON_CABECERA);
        pCentral.add(btnBlog);

        btnPvp = new Boton(new Dimension((int) (ANCHO * 0.03), (int) (ALTO * 0.03)), "PvP", BOTON_CABECERA);
        pCentral.add(btnPvp);

        btnModoCreador = new Boton(new Dimension((int) (ANCHO * 0.08), (int) (ALTO * 0.03)), "Modo Creador", BOTON_CABECERA);
        pCentral.add(btnModoCreador);

        btnAyuda = new Boton(new Dimension((int) (ANCHO * 0.04), (int) (ALTO * 0.03)), "ayuda", BOTON_CABECERA);
        pCentral.add(btnAyuda);

        pNick = new JPanel();
        pNick.setLayout(new FlowLayout(FlowLayout.LEFT, MARGEN, MARGEN_2));
        pNick.setBackground(COLOR_PRINCIPAL);
        pFondoTodo.add(pNick, BorderLayout.EAST);

        //icono2 = new ImageIcon(resUrlBase + "Iconos/moneda.png");
        //imagenMoneda = new JLabel();
        //imagenMoneda.setPreferredSize(new Dimension((int) (ANCHO * 0.02), (int) (ALTO * 0.04)));
        //Icon ico = new ImageIcon(icono2.getImage().getScaledInstance((int) (ANCHO * 0.02), (int) (ALTO * 0.04), Image.SCALE_DEFAULT));

        //imagenMoneda.setIcon(ico);

        iconMod = new IconMod(resUrlBase + "Iconos/moneda.png", (int) (ANCHO * 0.02), (int) (ALTO * 0.034));
        pNick.add(iconMod);

        jMoneda = new JLabel("50");
        jMoneda.setFont(CIUDATELLA_BOLD);
        jMoneda.setForeground(COLOR_GRIS_CLARO);
        pNick.add(jMoneda);

        c = new JLabel(".c");
        c.setFont(CIUDATELLA_BOLD);
        c.setForeground(COLOR_GRIS_CLARO);
        pNick.add(c);

        //icono3 = new ImageIcon(resUrlBase + "Iconos/diamante.png");
        //imagenDiamante = new JLabel();
        //imagenDiamante.setPreferredSize(new Dimension((int) (ANCHO * 0.02), (int) (ALTO * 0.04)));
        //Icon ic = new ImageIcon(icono3.getImage().getScaledInstance((int) (ANCHO * 0.02), (int) (ALTO * 0.04), Image.SCALE_DEFAULT));
        //imagenDiamante.setIcon(ic);

        iconMod = new IconMod(resUrlBase + "Iconos/diamante.png", (int) (ANCHO * 0.014), (int) (ALTO * 0.04));
        pNick.add(iconMod);

        jDiamante = new JLabel("5.0");
        jDiamante.setFont(CIUDATELLA_BOLD);
        jDiamante.setForeground(COLOR_GRIS_CLARO);
        pNick.add(jDiamante);

        g = new JLabel(".g");
        g.setFont(CIUDATELLA_BOLD);
        g.setForeground(COLOR_GRIS_CLARO);
        pNick.add(g);

        //icono4 = new ImageIcon(resUrlBase + "Iconos/nick.png");
        //jNick = new JLabel();
        //jNick.setPreferredSize(new Dimension((int) (ANCHO * 0.11), (int) (ALTO * 0.08)));
        //Icon i = new ImageIcon(icono4.getImage().getScaledInstance((int) (ANCHO * 0.11), (int) (ALTO * 0.08), Image.SCALE_DEFAULT));
        //jNick.setIcon(i);

        iconMod = new IconMod(resUrlBase + "Iconos/nick.png", (int) (ANCHO * 0.10), (int) (ALTO * 0.08));
        pNick.add(iconMod);

        this.add(pFondo);

    }

    public Boton getbtnInicio() {
        return btnInicio;
    }

    public Boton getbtnBlog() {
        return btnBlog;
    }

    public Boton getbtnPvp() {
        return btnPvp;
    }

    public Boton getbtnModoCreador() {
        return btnModoCreador;
    }

    public Boton getbtnAyuda() {
        return btnAyuda;
    }
}
