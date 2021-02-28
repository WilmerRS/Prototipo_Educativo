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
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Wilmer RS
 * @author Luis Alfredo
 */
public class PnFooter extends JPanel implements Patron {

    private final String ABOUT_US_LABEL = "Acerca de";
    private final String APP_LABEL = "Aplicaciones";
    private final String TERMS_COND_LABEL = "Términos y condiciones";
    private final String JOIN_US_LABEL = "¡Únetenos y apoya!";

    private JPanel pFondo;
    private JPanel pContenido;

    private Button btnAboutUs;
    private Button btnApplications;
    private Button btnTermsAndConditions;
    private Button btnJoinUs;

    public PnFooter() {
        super();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_PRINCIPAL);

        pFondo = new JPanel();
        pFondo.setOpaque(false);
        pFondo.setLayout(new BorderLayout());
        pFondo.setBackground(COLOR_PRINCIPAL);

        JPanel pnRow1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnRow1.setOpaque(false);

        int h16 = (int)(ALTO*0.01851);
        int w100 = (int)(ANCHO*0.06510);
        int w80 = (int)(ANCHO*0.05208);

        btnAboutUs = new Button(new Dimension(w80, h16), ABOUT_US_LABEL, LABEL_BUTTON);
        btnApplications = new Button(new Dimension(w100, h16), APP_LABEL, LABEL_BUTTON);

        JLabel lbBullet = new JLabel("<html><body><span>&#8226;</span></body></html>");
        lbBullet.setForeground(COLOR_GRIS_MEDIO);
        lbBullet.setFont(BUTTON_TEXT_FONT);

        pnRow1.add(btnAboutUs);
        pnRow1.add(lbBullet);
        pnRow1.add(btnApplications);

        JPanel pnRow2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnRow2.setOpaque(false);

        btnTermsAndConditions = new Button(new Dimension(w100*2, h16), TERMS_COND_LABEL, LABEL_BUTTON);
        pnRow2.add(btnTermsAndConditions);

        JPanel pnRow3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnRow3.setOpaque(false);

        btnJoinUs = new Button(new Dimension(w100*2, h16), JOIN_US_LABEL, LABEL_BUTTON);
        pnRow3.add(btnJoinUs);

        pContenido = new JPanel();
        pContenido.setLayout(new BoxLayout(pContenido, BoxLayout.Y_AXIS));
        pContenido.setBackground(COLOR_PRINCIPAL);
        pFondo.add(pContenido, BorderLayout.CENTER);

        pContenido.add(pnRow1);
        pContenido.add(pnRow2);
        pContenido.add(pnRow3);

        this.add(pFondo, BorderLayout.NORTH);
    }

}
