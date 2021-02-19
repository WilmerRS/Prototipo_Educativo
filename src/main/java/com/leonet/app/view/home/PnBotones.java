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

import com.leonet.app.view.shared.*;
import com.leonet.app.view.shared.Button;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Luis Alfredo
 */
public class PnBotones extends JPanel implements Patron {
    
    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pBotones;
    private JPanel pInfo;
    
    private Button btnAnt;
    private Button btnSig;
    
    private PnFooter pInformacion;
    
    public PnBotones() {
        super();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        this.setLayout(new BorderLayout());
        
        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);
        
        hacerMargenes();
        
        pCentral = new JPanel();
        pCentral.setLayout(new BorderLayout());
        pFondo.add(pCentral, BorderLayout.CENTER);
        
        pBotones = new JPanel();
        pBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        pBotones.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pBotones, BorderLayout.NORTH);
        
        btnAnt = new Button(new Dimension((int) (ANCHO*0.07), (int) (ALTO*0.06)), "ANTERIOR", BOTON_ANTERIOR);
        pBotones.add(btnAnt);
        
        btnSig = new Button(new Dimension((int) (ANCHO*0.07), (int) (ALTO*0.06)), "SIGUIENTE", BOTON_SIGUIENTE);
        pBotones.add(btnSig);
        
        pInformacion = new PnFooter();
        pCentral.add(pInformacion, BorderLayout.CENTER);
        
        this.add(pFondo);
        
    }
    
     private void hacerMargenes(){
        int f=10;
        JPanel nor1 = new JPanel();
        nor1.setPreferredSize(new Dimension(0, f));
        nor1.setBackground(COLOR_PRINCIPAL);
        pFondo.add(nor1, BorderLayout.NORTH);
        
        JPanel izq1 = new JPanel();
        izq1.setPreferredSize(new Dimension(f, 0));
        izq1.setBackground(COLOR_PRINCIPAL);
        pFondo.add(izq1, BorderLayout.WEST);
    }

    /**
     *
     * @author Luis Alfredo
     */
    public static class ViewPrincipal extends JFrame implements Patron {

        private JPanel pFondo;
        private JPanel pCentral;

        private PnCabecera pCabecera;
        private PnContexto pContexto;
        private PnNivel pNivel;
        private PnTop pTop;
        private PnProblema pProblema;
        private PnBotones pBotones;

        private PnRelleno pRellenoDer;
        private PnRelleno pRellenoIzq;
        private PnRellenoSur pRellenoSur;

        private String titulo = "App Educativa";

        private boolean activo;

        public ViewPrincipal(){
            iniciarComponentes();
            this.setLocationRelativeTo(null);
        }

        private void iniciarComponentes() {
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setMinimumSize(new Dimension((int) (ANCHO * 0.5), (int) (ALTO * 0.5)));
            this.setTitle(titulo);
            this.setIconImage(new ImageIcon(resUrlBase + "Iconos/logo1.png").getImage());
            paneles();
            agregarEventos();
            pack();
        }

        private void paneles(){
           this.setLayout(new BorderLayout());

            pFondo= new JPanel();
            pFondo.setLayout(new BorderLayout(MARGEN*5, MARGEN));
            pFondo.setBackground(COLOR_PRINCIPAL);
            pFondo.setPreferredSize(new Dimension ((int) (ANCHO * 0.8), (int) (ALTO * 0.8)));

            pCabecera = new PnCabecera();
            pFondo.add(pCabecera, BorderLayout.NORTH);

            pRellenoIzq = new PnRelleno();
            pFondo.add(pRellenoIzq, BorderLayout.WEST);

            pRellenoDer = new PnRelleno();
            pFondo.add(pRellenoDer, BorderLayout.EAST);

            pRellenoSur = new PnRellenoSur();
            pFondo.add(pRellenoSur, BorderLayout.SOUTH);

            pCentral = new JPanel();
            pCentral.setLayout(new GridBagLayout());
            pCentral.setBackground(COLOR_PRINCIPAL);
            GridBagConstraints gbc = new GridBagConstraints();

            pFondo.add(pCentral, BorderLayout.CENTER);
            pContexto = new PnContexto();
            gbc.gridx = 0; // El área de texto empieza en la columna cero.
            gbc.gridy = 0; // El área de texto empieza en la fila cero
            gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
            gbc.gridheight = 3; // El área de texto ocupa 2 filas.
            gbc.weighty = 2.0;
            gbc.weightx = 2.0;
            gbc.fill = gbc.BOTH;
            pCentral.add(pContexto, gbc);

            pProblema = new PnProblema();
            gbc.gridx = 0; // El área de texto empieza en la columna cero.
            gbc.gridy = 3; // El área de texto empieza en la fila cero
            gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
            gbc.gridheight = 6; // El área de texto ocupa 2 filas.
            gbc.weighty = 2.0;
            gbc.weightx = 2.0;
            gbc.fill = gbc.BOTH;
            pCentral.add(pProblema, gbc);

            gbc.weighty = 0.0;
            gbc.weightx = 0.3;


            pNivel = new PnNivel();
            gbc.gridx = 6; // El área de texto empieza en la columna cero.
            gbc.gridy = 0; // El área de texto empieza en la fila cero
            gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
            gbc.gridheight = 2; // El área de texto ocupa 2 filas.
            gbc.fill = gbc.BOTH;
            pCentral.add(pNivel, gbc);

            pTop = new PnTop();
            gbc.gridx = 6; // El área de texto empieza en la columna cero.
            gbc.gridy = 2; // El área de texto empieza en la fila cero
            gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
            gbc.gridheight = 2; // El área de texto ocupa 2 filas.
            gbc.fill = gbc.BOTH;
            pCentral.add(pTop, gbc);

            pBotones = new PnBotones();
            gbc.gridx = 6; // El área de texto empieza en la columna cero.
            gbc.gridy = 5; // El área de texto empieza en la fila cero
            gbc.gridwidth = 5; // El área de texto ocupa dos columnas.
            gbc.gridheight = 4; // El área de texto ocupa 2 filas.
            gbc.fill = gbc.BOTH;
            pCentral.add(pBotones, gbc);

            this.add(pFondo);


        }

        private void agregarEventos(){

             ActionListener clickInicio = new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     pCabecera.getbtnInicio().CLICK=COLOR_NARANJA_BOTON;
                     pCabecera.getbtnPvp().TIPO = BOTON_ANTERIOR;
                     pCabecera.updateUI();
                 }
             };
             pCabecera.getbtnInicio().addActionListener(clickInicio);



        }


    }
}
