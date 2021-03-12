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

import com.leonet.app.controller.problemsController.listProblem.ListProblemController;
import com.leonet.app.model.problems.itemsListProblem.ItemList;
import com.leonet.app.view.home.problems.code.PnCalculator;
import com.leonet.app.view.home.problems.listProblem.PnListProblem;
import com.leonet.app.view.shared.*;
import com.leonet.app.view.shared.ScrollPane;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collector;
import javax.swing.*;

/**
 * @author Luis Alfredo
 */
public class PnProblema extends JPanel implements Patron {

    private final String ITEMS_LIST = "ITEMS_LIST";
    private final String FLOWCHART = "FLOWCHART";
    private final String CODE = "CODE";

    private JPanel pFondo;
    private JPanel pCentral;
    private JPanel pTitulo;
    private JPanel pEspacio;
    private JPanel pContenido;
    private JPanel pLinea;
    private JPanel pnDefProblem;

    private RoundedPanel pRedondo;

    private JLabel jTitulo;

    private JTextArea textPro;

    private TextPane textDefProblem;

    private ScrollPane spDefProblem;
    private ScrollPane jScroll;

    private PnListProblem pnListProblem;
    private PnCalculator pnCalculator;

    private int MAX_LINES_DEF_PROBLEM = 200;

    public PnProblema() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        pFondo = new JPanel();
        pFondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));
        pFondo.setBackground(COLOR_PRINCIPAL);

        pRedondo = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_GRIS_BORDER);
        pRedondo.setLayout(new BorderLayout(MARGEN_2 * 3, MARGEN_2 * 3));
        pFondo.add(pRedondo, BorderLayout.CENTER);

        pEspacio = new JPanel();
        pEspacio.setLayout(new BorderLayout());
        pEspacio.setBackground(COLOR_PRINCIPAL);
        pRedondo.add(pEspacio, BorderLayout.CENTER);

        UIComponents.marginAll(pRedondo);
        UIComponents.marginTop(pFondo);

        pCentral = new JPanel();
        pCentral.setLayout(new BoxLayout(pCentral, BoxLayout.Y_AXIS));
        pCentral.setBackground(COLOR_PRINCIPAL);

        jScroll = new ScrollPane(pCentral,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        pEspacio.add(jScroll, BorderLayout.CENTER);

        pTitulo = new JPanel(new BorderLayout());
        pTitulo.setBackground(COLOR_PRINCIPAL);
        pCentral.add(pTitulo, BorderLayout.NORTH);

        jTitulo = new JLabel("PROBLEMA");
        jTitulo.setFont(TITLE_FONT);
        jTitulo.setForeground(COLOR_GRIS_OSCURO);
        pTitulo.add(jTitulo, BorderLayout.WEST);

        IconMod iconMod = new IconMod(resUrlBase + "Iconos/icon2.PNG", (int) (ANCHO * 0.07), (int) (ALTO * 0.037));
        pTitulo.add(iconMod, BorderLayout.EAST);

        pContenido = new JPanel();
        pContenido.setLayout(new BorderLayout());
        pContenido.setBackground(COLOR_PRINCIPAL);

        pLinea = UIComponents.lineSeparator(1, COLOR_GRIS_BORDER);

        pContenido.add(pLinea, BorderLayout.SOUTH);

        pnDefProblem = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pnDefProblem.setBackground(COLOR_PRINCIPAL);
        pnDefProblem.setPreferredSize(new Dimension(0, MAX_LINES_DEF_PROBLEM));

        UIComponents.marginVertical(pnDefProblem);

        textDefProblem = new TextPane("", COLOR_PRINCIPAL);
         spDefProblem = new ScrollPane(textDefProblem,
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         pnDefProblem.add(spDefProblem, BorderLayout.CENTER);
        pContenido.add(pnDefProblem, BorderLayout.NORTH);

        pCentral.add(pContenido);

        this.add(pFondo);
    }

    public void updateDefProblem(String text, int linesCount) {
        textDefProblem.setText(text);
        pnDefProblem.setPreferredSize(new Dimension(0, linesCount));
        /*pnDefProblem.setPreferredSize(new Dimension(0, linesCount));
        textDefProblem = new TextPane(text, COLOR_PRINCIPAL);
        spDefProblem = new ScrollPane(textDefProblem,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        pnDefProblem.add(spDefProblem, BorderLayout.CENTER);*/
    }

    public void loadItemListProblem(ArrayList<ItemList> itemLists, ArrayList<Integer> indentation) {

        /** Collections.shuffle(itemLists); -> Activar en prod*/
        if(pnCalculator != null){
            pCentral.remove(pnCalculator);
        }
        if(pnListProblem != null){
            pCentral.remove(pnListProblem);
        }
        pnListProblem = new PnListProblem(itemLists, indentation);
        pCentral.add(pnListProblem);
    }

    public void loadCalculatorProblem(){
        if(pnCalculator != null){
            pCentral.remove(pnCalculator);
        }
        if(pnListProblem != null){
            pCentral.remove(pnListProblem);
        }
        pnCalculator = new PnCalculator();
        pCentral.add(pnCalculator);
    }

    public PnCalculator getPnCalculator() {
        return pnCalculator;
    }

    public TextPane getTextDefProblem() {
        return textDefProblem;
    }

    public PnListProblem getPnListProblem() {
        return pnListProblem;
    }
}
