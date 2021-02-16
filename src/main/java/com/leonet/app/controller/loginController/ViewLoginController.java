/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.controller.loginController;

import com.leonet.app.model.Model;
import com.leonet.app.view.blog.ViewBlog;
import com.leonet.app.view.home.PnBotones;
import com.leonet.app.view.login.ViewLogin;

public class ViewLoginController {


    // Modelos
    private Model model;

    // Vistas
    private ViewLogin viewLogin;
    private PnBotones.ViewPrincipal viewPrincipal;
    private ViewBlog viewBlog;

    private boolean isLogin;

    /**
     * Permite construir el controlador de Login, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public ViewLoginController(Model model, ViewLogin view) {
        this.model = model;
        this.viewLogin = view;
        initListener();
    }

    private void initListener() {
        loginListener();
        registerListener();
        buttonsHeaderListener();
    }

    private void buttonsHeaderListener() {
        // Button LeonetApp
        viewLogin.getpCabecera().getBtnInicio().addActionListener(ae -> {
            if (/*isLogin*/ false) {
                viewPrincipal.setVisible(true);
                viewLogin.setVisible(false);
            } else {
                viewLogin.setVisible(true);
                if(viewBlog != null){
                    viewBlog.setVisible(false);
                }
            }
        });

        //Button Blog
        viewLogin.getpCabecera().getBtnBlog().addActionListener(ae -> {
            viewBlog = new ViewBlog();
            viewBlog.setVisible(true);
            viewLogin.setVisible(false);
        });

        //Button Ayuda
        viewLogin.getpCabecera().getBtnAyuda().addActionListener(ae -> {
            // Hola
        });
    }



    private void registerListener() {
    }

    private void loginListener() {
        viewLogin.getpLogin().getBtnInicarSesion().addActionListener(ae -> {
            isLogin = model.getUsuario().iniciarSesion(viewLogin.getpLogin().getUsuario(), viewLogin.getpLogin().getContrasenia());
            System.out.println("Login = " + isLogin);
//                view.getLogin().isLogin(isLogin);
            if (/*isLogin*/ true) {
                viewPrincipal = new PnBotones.ViewPrincipal();
                viewPrincipal.setVisible(true);
                viewLogin.setVisible(false);
            } else {
                viewLogin.getpLogin().getjMensajeError().setText("CREDENCIALES INVALIDAS");
                viewLogin.getpLogin().colorRojo();
                System.out.println("* Contraseña errada. *");
            }
        });
    }
}
