/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase que permite crear la interfaz del programa. Solo crea la parte visual
 * @author WILMER
 */
public class View extends JFrame{
    
    private Login login;
    
    public View() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JPanel background = new JPanel();
        background.setLayout(new BorderLayout());
        background.setPreferredSize(new Dimension(500, 300));
        
        login = new Login();
        background.add(login);
        
        getContentPane().add(background, java.awt.BorderLayout.CENTER);
        pack();
    }

    public Login getLogin() {
        return login;
    }
}
