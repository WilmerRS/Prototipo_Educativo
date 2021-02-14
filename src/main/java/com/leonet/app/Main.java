/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app;

import com.leonet.app.controller.Controller;
import com.leonet.app.model.Model;
import com.leonet.app.view.login.ViewLogin;

public class Main {

    private static Model model;
    private static ViewLogin view;
    private static Controller controller;

    /**
     * Permite inicial el modelo MVC
     */
    public Main() {
        model = new Model();
        view = new ViewLogin();
        controller = new Controller(model, view);
    }

    /**
     * Inicia la interfaz del protitipo
     * @param args argumentos en la linea de comandos
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /*
         * Ejecuta la ventana principal de la aplicacion
         */
        java.awt.EventQueue.invokeLater(() -> {
            new Main();
            view.setVisible(true);
        });
//        new Prototipo_Educate_Main();
    }

}
