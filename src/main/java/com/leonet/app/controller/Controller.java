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

import com.leonet.app.controller.loginController.LoginController;
import com.leonet.app.model.Model;
import com.leonet.app.view.inicio.ViewPrincipal;
import com.leonet.app.view.login.ViewLogin;

/**
 * Clase que permite controlar la interfaz, mediante el llamado de sus eventos
 *
 * @author WILMER
 */
public class Controller {

    // Modelos
    private Model model;

    // Vistas
    private ViewLogin viewLogin;

    // Controladores
    private LoginController loginController;

    /**
     * Permite construir el controlador base, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public Controller(Model model, ViewLogin view) {
        this.model = model;
        this.viewLogin = view;
        iniciarControllers();
    }

    private void iniciarControllers() {
        loginController = new LoginController(model, viewLogin);
    }
}
