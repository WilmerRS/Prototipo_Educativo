/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.controller;

import com.leonet.app.controller.headerController.HeaderController;
import com.leonet.app.controller.problemsController.ProblemsController;
import com.leonet.app.controller.userController.UserController;
import com.leonet.app.model.Model;
import com.leonet.app.view.View;

/**
 * Clase que permite controlar la interfaz, mediante el llamado de sus eventos
 *
 * @author WILMER
 */
public class Controller extends ControllerRepositoty {

    // Controllers


    /**
     * Permite construir el controlador principal, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public Controller(Model model, View view) {
        super(model, view);
    }

    protected void initControllers() {
        headerController = new HeaderController(model, view);
        userController = new UserController(model, view, problemsController);
    }
}
