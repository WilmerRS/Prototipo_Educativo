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

import com.leonet.app.view.shared.*;

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
public class ViewBlog extends JFrame implements Patron {
    
    private JPanel pFondo;
    private JPanel pAux;
    private JPanel pRelleno;
    
    private PnRelleno pRellenoIzq;
    private PnRelleno pRellenoDer;
    private PnRellenoSur pRellenoSur;
    
    private PnHeader pCabecera;
    private PnBlog pBlog;
    private PnInicioSesion pInicio;
    private PnFooter pInformacion;
    
    private String titulo = "Login";
    
    public ViewBlog(){
        iniciarComponentes();
        this.setLocationRelativeTo(null);
    }

    private void iniciarComponentes() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.3), (int) (ALTO * 0.5)));
        this.setTitle(titulo);
        this.setIconImage(new ImageIcon(resUrlBase + "Iconos/logo1.png").getImage());
        paneles();
        agregarEventos();
        pack();
    }

    private void paneles() {
        
        this.setLayout(new BorderLayout());
        
        pFondo= new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN, MARGEN*5));
        pFondo.setBackground(COLOR_PRINCIPAL);
        pFondo.setPreferredSize(new Dimension ((int) (ANCHO * 0.8), (int) (ALTO * 0.8)));
        
        pRelleno = new JPanel();
        pRelleno.setLayout(new BorderLayout());
        pFondo.add(pRelleno, BorderLayout.CENTER);
        
        pRellenoIzq = new PnRelleno();
        pFondo.add(pRellenoIzq, BorderLayout.WEST);
        
        pRellenoDer = new PnRelleno();
        pFondo.add(pRellenoDer, BorderLayout.EAST);
        
        pRellenoSur = new PnRellenoSur();
        pFondo.add(pRellenoSur, BorderLayout.SOUTH);
        
        pCabecera = new PnHeader("BLOG");
        pFondo.add(pCabecera, BorderLayout.NORTH);
        
        pBlog = new PnBlog();
        pRelleno.add(pBlog, BorderLayout.CENTER);
        
        
        pAux = new JPanel();
        pAux.setLayout(new BorderLayout());
        pRelleno.add(pAux, BorderLayout.EAST);
        
        pInicio = new PnInicioSesion();
        pAux.add(pInicio, BorderLayout.NORTH);
        
        pInformacion = new PnFooter();
        pAux.add(pInformacion, BorderLayout.CENTER);
        
        this.add(pFondo);
    }

    private void agregarEventos(){
        
         ActionListener clickInicio = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 //pCabecera.getbtnInicio().setForeground(COLOR_VERDE);
//                 ViwePrincipal = new view();
//                 ViwePrincipal.setVisible(true);
             }

         };
        
         //pLogin.getBtnInicarSesion().addActionListener(clickInicio);
         
         
         
    }
            
}
