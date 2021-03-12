/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view.help;

import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.UserIcon;

import javax.swing.*;

/**
 *
 * @author Luis Alfredo
 */
public class PnHelp extends JPanel implements Patron {

    public PnHelp() {
        initComponent();
    }

    private void initComponent() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(COLOR_PRINCIPAL);

        UserIcon us = new UserIcon("WilmerRS ro ro", 100);

        this.add(us);
    }
}
