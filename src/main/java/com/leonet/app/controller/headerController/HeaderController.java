package com.leonet.app.controller.headerController;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.model.Model;
import com.leonet.app.view.View;

public class HeaderController extends ControllerRepositoty {

    public HeaderController(Model model, View view) {
        super(model, view);
    }

    protected void addListener() {
        view.getPnHeader().getBtnBlog().addActionListener(ae -> {
            view.updateTab(view.getPnBlog());
        });

        view.getPnHeader().getBtnInicio().addActionListener(ae -> {
            view.updateTab(view.getPnLogin());
        });
    }
}
