package com.leonet.app.controller;

import com.leonet.app.model.Model;
import com.leonet.app.view.View;

public class ControllerRepositoty {
    // Models
    protected Model model;

    // Views
    protected View view;

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
