/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.blog;

import com.leonet.app.view.shared.Boton;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.RoundedPanel;
import com.leonet.app.view.shared.TextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Luis Alfredo
 */
public class PnBlog extends RoundedPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pEspacio;
    private JPanel pContenido;
    private JPanel pBotones;
    
    private RoundedPanel pRedondo;

    private ImageIcon icono;

    private JLabel jIcono;
    private JLabel jUsuario;
    private JLabel jContrasenia;
    private JLabel jOlvido;

    private TextField cUsuario;
    private TextField cContrasenia;

    private Boton btnCrearCuenta;
    private Boton btnIniciarSesion;
    
    private JScrollPane jScroll;

    public PnBlog() {
        super(0, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.setLayout(new BorderLayout());

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        //pFondo.setPreferredSize(new Dimension((int) (ANCHO * 0.0), (int) (ALTO * 0.35)));

        pRedondo = new RoundedPanel(RADIO,COLOR_PRINCIPAL, COLOR_GRIS_BORDE);
        pRedondo.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        pFondo.add(pRedondo, BorderLayout.CENTER);

        pEspacio = new JPanel();
        pEspacio.setLayout(new BorderLayout(MARGEN, MARGEN));
        pEspacio.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pEspacio, BorderLayout.CENTER);
        hacerMargenes();

        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout());
        pCentral.setBackground(COLOR_PRINCIPAL);
        pEspacio.add(pCentral, BorderLayout.CENTER);
        
        
    }

    private void hacerMargenes() {
        int i = 0;
        JPanel izq = new JPanel();
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
        JPanel sur2 = new JPanel();
        sur2.setPreferredSize(new Dimension(0, f));
        sur2.setBackground(COLOR_PRINCIPAL);
        pFondo.add(sur2, BorderLayout.SOUTH);
        
        JPanel izq2 = new JPanel();
        izq2.setPreferredSize(new Dimension(f, 0));
        izq2.setBackground(COLOR_PRINCIPAL);
        pFondo.add(izq2, BorderLayout.WEST);
        
        JPanel der2 = new JPanel();
        der2.setPreferredSize(new Dimension(f, 0));
        der2.setBackground(COLOR_PRINCIPAL);
        pFondo.add(der2, BorderLayout.EAST);
    }
    
}
