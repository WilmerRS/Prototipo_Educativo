/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.home;

import com.leonet.app.view.shared.*;
import com.leonet.app.view.shared.ScrollPane;

import java.awt.*;
import javax.swing.*;

/**
 * @author Luis Alfredo
 */
public class PnContexto extends JPanel implements Patron {

    private JPanel pFondo;
    private JPanel pContenido;
    private JPanel pContexto;
    private JPanel pEjemplo;

    private RoundedPanel pRedondo;
    private RoundedPanel pnBackground;

    private JLabel jTituloContexto;
    private JLabel jTituloEjemplo;

    private ScrollPane spContexto;
    private ScrollPane spEjemplo;

    private TextPane textContexto;
    private TextPane textEjemplo;

    private int MAX_LINES_CONTEXTO = 200;
    private int MAX_LINES_EJEMPLO = 200;
    private JPanel pnContainerEjemplo;

    public PnContexto() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));
        pFondo.setBackground(COLOR_PRINCIPAL);

        pnBackground = new RoundedPanel(RADIO, COLOR_VERDE_MEDIO, COLOR_VERDE_MEDIO);
        pnBackground.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        UIComponents.marginBottom(pnBackground);

        pRedondo = new RoundedPanel(RADIO, COLOR_VERDE, COLOR_VERDE);
        pRedondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));

        UIComponents.marginAll(pRedondo);
        UIComponents.marginTop(pFondo);

        pnBackground.add(pRedondo, BorderLayout.CENTER);

        pFondo.add(pnBackground, BorderLayout.CENTER);

        pContenido = new JPanel();
        pContenido.setLayout(new BoxLayout(pContenido, BoxLayout.Y_AXIS));
        pContenido.setBackground(COLOR_VERDE);

        pContexto = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pContexto.setBackground(COLOR_VERDE);
        pContexto.setPreferredSize(new Dimension(0,MAX_LINES_CONTEXTO));

        jTituloContexto = new JLabel("CONTEXTO");
        jTituloContexto.setFont(TITLE_FONT);
        jTituloContexto.setForeground(COLOR_VERDE_OSCURO);
        pContexto.add(jTituloContexto, BorderLayout.NORTH);

        /**textContexto = new TextPane("", COLOR_VERDE);

        spContexto = new ScrollPane(textContexto,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pContexto.add(spContexto, BorderLayout.CENTER);**/

        pContenido.add(pContexto);

        pnContainerEjemplo = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pnContainerEjemplo.setPreferredSize(new Dimension(0,MAX_LINES_EJEMPLO));
        pnContainerEjemplo.setBackground(COLOR_VERDE);
        UIComponents.marginTop(pnContainerEjemplo);

        pEjemplo = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pEjemplo.setBackground(COLOR_VERDE);

        jTituloEjemplo = new JLabel("EJEMPLO:");
        jTituloEjemplo.setFont(TITLE_FONT);
        jTituloEjemplo.setForeground(COLOR_VERDE_OSCURO);
        pEjemplo.add(jTituloEjemplo, BorderLayout.NORTH);

        /**textEjemplo = new TextPane("", COLOR_VERDE);

        spEjemplo = new ScrollPane(textEjemplo,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        pEjemplo.add(spEjemplo, BorderLayout.CENTER);*/
        pnContainerEjemplo.add(pEjemplo);

        pContenido.add(pnContainerEjemplo);

        pRedondo.add(pContenido, BorderLayout.CENTER);

        //this.setPreferredSize(new Dimension(0,500));
        this.add(pFondo);
    }

    public void updateContext(String text, int linesCount){
        pContexto.setPreferredSize(new Dimension(0,linesCount));
        textContexto = new TextPane(text, COLOR_VERDE);

        spContexto = new ScrollPane(textContexto,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pContexto.add(spContexto, BorderLayout.CENTER);
    }

    public void updateExample(String text, int linesCount){
        pnContainerEjemplo.setPreferredSize(new Dimension(0,linesCount));
        textEjemplo = new TextPane(text, COLOR_VERDE);

        spEjemplo = new ScrollPane(textEjemplo,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        pEjemplo.add(spEjemplo, BorderLayout.CENTER);
    }


    public void setMAX_LINES_CONTEXTO(int MAX_LINES_CONTEXTO) {
        this.MAX_LINES_CONTEXTO = MAX_LINES_CONTEXTO;
    }

    public void setMAX_LINES_EJEMPLO(int MAX_LINES_EJEMPLO) {
        this.MAX_LINES_EJEMPLO = MAX_LINES_EJEMPLO;
    }
}
