package com.leonet.app.controller;

import com.leonet.app.controller.headerController.HeaderController;
import com.leonet.app.controller.problemsController.AdvaceButtonsController;
import com.leonet.app.controller.problemsController.ProblemsController;
import com.leonet.app.controller.problemsController.code.CalculatorController;
import com.leonet.app.controller.problemsController.listProblem.ListProblemController;
import com.leonet.app.controller.userController.UserController;
import com.leonet.app.model.Model;
import com.leonet.app.view.View;
import com.leonet.app.view.home.problems.code.PnCalculator;

public class ControllerRepositoty {
    // Models
    protected Model model;

    // Views
    protected View view;

    // Controladores
    protected HeaderController headerController;
    protected UserController userController;
    protected ProblemsController problemsController;
    protected AdvaceButtonsController advaceButtonsController;
    protected ListProblemController listProblemController;
    protected CalculatorController pnCalculator;

    /**
     * Permite construir el controlador base, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public ControllerRepositoty(Model model, View view) {
        this.model = model;
        this.view = view;
        initComponents();
        initControllers();
        addListeners();
    }

    protected void initComponents() {
    }

    protected void initControllers() {
    }

    protected void addListeners() {
    }
}
