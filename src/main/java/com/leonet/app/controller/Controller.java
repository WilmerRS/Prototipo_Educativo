/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.controller;

import com.leonet.app.controller.loginController.ViewLoginController;
import com.leonet.app.model.Model;
import com.leonet.app.view.login.ViewLogin;

/**
 * Clase que permite controlar la interfaz, mediante el llamado de sus eventos
 *
 * @author WILMER
 */
public class Controller {

    // Models
    private Model model;

    // Views
    private ViewLogin viewLogin;

    // Controllers
    private ViewLoginController loginController;

    /**
     * Permite construir el controlador base, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public Controller(Model model, ViewLogin view) {
        this.model = model;
        this.viewLogin = view;
        initControllers();
    }

    private void initControllers() {
        loginController = new ViewLoginController(model, viewLogin);
    }
}
