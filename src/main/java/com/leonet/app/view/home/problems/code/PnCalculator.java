package com.leonet.app.view.home.problems.code;

import javax.swing.*;
import java.awt.*;

import com.leonet.app.view.shared.*;
import com.leonet.app.view.shared.Button;
import com.leonet.app.view.shared.TextField;

public class PnCalculator extends JPanel implements Patron {

    private RoundedPanel pbackground;
    private JPanel pbuttons;

    private JPanel backgroundall;

    private TextField textInputNumber;

    private JLabel title;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonlikewise;
    private Button buttonfactorial;
    private Button buttondelete;

    public PnCalculator() {
        startcomponents();
    }

    private void startcomponents() {
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_PRINCIPAL);

        backgroundall = new JPanel();
        backgroundall.setOpaque(false);
        backgroundall.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        // backgroundall.setBackground(COLOR_AZUL_BOTON);

        JPanel temp = new JPanel();
        temp.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        temp.setBackground(COLOR_PRINCIPAL);
        backgroundall.add(temp, BorderLayout.NORTH);

        title = new JLabel("Calculadora");
        title.setFont(TITLE_FONT);
        title.setForeground(COLOR_GRIS_OSCURO);
        temp.add(title, BorderLayout.NORTH);

        textInputNumber = new TextField(new Dimension((int) (ANCHO * 0.2), (int) (ALTO * 0.1)), "");
        textInputNumber.getTxtField().setFont(TITLE_BIG_FONT);
        textInputNumber.getTxtField().setForeground(COLOR_GRIS_MEDIO);
        textInputNumber.getTxtField().setEditable(false);
        temp.add(textInputNumber, BorderLayout.CENTER);

        pbuttons = new JPanel();
        pbuttons.setOpaque(false);
        pbuttons.setLayout(new GridLayout(4, 3, MARGEN_2, MARGEN_2));

        RoundedPanel rpNumbers = new RoundedPanel(RADIO_BUTTON, COLOR_GRIS, COLOR_GRIS);
        rpNumbers.setLayout(new BorderLayout());
        JPanel pnNumbersCenter = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnNumbersCenter.setOpaque(false);
        UIComponents.marginAll(pnNumbersCenter);
        pnNumbersCenter.add(pbuttons, BorderLayout.CENTER);
        rpNumbers.add(pnNumbersCenter);

        backgroundall.add(rpNumbers, BorderLayout.CENTER);

        JPanel temp1 = new JPanel(new BorderLayout(MARGEN, MARGEN));
        temp1.setBackground(COLOR_PRINCIPAL);
        UIComponents.marginTop(temp1);
        JPanel temp2 = new JPanel(new BorderLayout());
        temp2.setBackground(COLOR_PRINCIPAL);

        JLabel titleCode = new JLabel("Escribe tu código aquí: ");
        titleCode.setFont(TITLE_FONT);
        titleCode.setForeground(COLOR_GRIS_OSCURO);
        temp2.setPreferredSize(new Dimension(50, (int) (ALTO * 0.2)));

        TextPane textPane = new TextPane("factorial (x):\n" +
                "\tfactorial = 1\n" +
                "\ti de 1 a x:\n" +
                "\t\tfactorial = i * factorial\n" +
                "\t\n" +
                "\tdevolver factorial\n" +
                "fin factorial\n", COLOR_PRINCIPAL);
        textPane.setEditable(true);

        temp2.add(titleCode, BorderLayout.NORTH);
        temp2.add(textPane, BorderLayout.CENTER);
        temp1.add(temp2, BorderLayout.CENTER);
        backgroundall.add(temp1, BorderLayout.SOUTH);
        table();

        this.add(backgroundall);
    }

    private void table() {
        button7 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "7", WHITE_BUTTON, false);
        pbuttons.add(button7);

        button8 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "8", WHITE_BUTTON, false);
        pbuttons.add(button8);

        button9 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "9", WHITE_BUTTON, false);
        pbuttons.add(button9);


        button4 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "4", WHITE_BUTTON, false);
        pbuttons.add(button4);

        button5 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "5", WHITE_BUTTON, false);
        pbuttons.add(button5);

        button6 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "6", WHITE_BUTTON, false);
        pbuttons.add(button6);

        button1 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "1", WHITE_BUTTON, false);
        pbuttons.add(button1);

        button2 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "2", WHITE_BUTTON, false);
        pbuttons.add(button2);

        button3 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "3", WHITE_BUTTON, false);
        pbuttons.add(button3);

        button0 = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "0", WHITE_BUTTON, false);
        pbuttons.add(button0);

        buttonfactorial = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "Factorial", BLUE_BUTTON, false);
        pbuttons.add(buttonfactorial);

        buttondelete = new Button(new Dimension((int) (ANCHO * 0.05), (int) (ALTO * 0.05)), "Delete", ORANGE_BUTTON, false);
        pbuttons.add(buttondelete);


    }

    public Button getButton0() {
        return button0;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Button getButton3() {
        return button3;
    }

    public Button getButton4() {
        return button4;
    }

    public Button getButton5() {
        return button5;
    }

    public Button getButton6() {
        return button6;
    }

    public Button getButton7() {
        return button7;
    }

    public Button getButton8() {
        return button8;
    }

    public Button getButton9() {
        return button9;
    }

    public Button getButtonlikewise() {
        return buttonlikewise;
    }

    public Button getButtondelete() {
        return buttondelete;
    }

    public Button getButtonfactorial() {
        return buttonfactorial;
    }

    public TextField getContainer() {
        return textInputNumber;
    }


}
