/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.controller.loginController;

import com.leonet.app.model.Model;
import com.leonet.app.view.inicio.ViewPrincipal;
import com.leonet.app.view.login.ViewLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {


    // Modelos
    private Model model;

    // Vistas
    private ViewLogin viewLogin;
    private ViewPrincipal viewPrincipal;


    /**
     * Permite construir el controlador de Login, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public LoginController(Model model, ViewLogin view) {
        this.model = model;
        this.viewLogin = view;
        login();
    }

    private void login() {
        viewLogin.getpLogin().getBtnInicarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean isLogin = model.getUsuario().iniciarSesion(viewLogin.getpLogin().getUsuario(), viewLogin.getpLogin().getContrasenia());
                System.out.println("Login = " + isLogin);
//                view.getLogin().isLogin(isLogin);
                if (isLogin) {
                    viewPrincipal = new ViewPrincipal();
                    viewPrincipal.setVisible(true);
                    viewLogin.setVisible(false);
                } else {
                    viewLogin.getpLogin().getjMensajeError().setText("CREDENCIALES INVALIDAS");
                    viewLogin.getpLogin().colorRojo();
                    System.out.println("* Contrasenha errada. *");
                }
            }
        });
    }
}
