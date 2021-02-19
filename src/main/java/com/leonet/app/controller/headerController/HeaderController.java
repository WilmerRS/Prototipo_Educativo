package com.leonet.app.controller.headerController;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.model.Model;
import com.leonet.app.view.View;

public class HeaderController extends ControllerRepositoty {

    public HeaderController(Model model, View view) {
        super(model, view);
    }

    protected void addListeners() {
        // Button blog
        view.getPnHeader().getBtnBlog().addActionListener(ae -> {
            view.updateTab(view.getPnBlog(), "Blog");
        });

        // Button LeonetApp
        view.getPnHeader().getBtnInicio().addActionListener(ae -> {
            boolean isLogin = view.isLogin();
            if(isLogin){
                view.updateTab(view.getPnLeonetApp(), "Inicio");
            }else{
                view.getPnLogin().resetMessageCredentials();
                view.updateTab(view.getPnLogin(), "Iniciar sesión");
            }
        });
    }
}
