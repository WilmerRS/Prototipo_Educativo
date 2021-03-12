/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.controller.userController;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.controller.problemsController.AdvaceButtonsController;
import com.leonet.app.controller.problemsController.ProblemsController;
import com.leonet.app.model.Model;
import com.leonet.app.model.user.UserRepository;
import com.leonet.app.view.View;

public class UserController extends ControllerRepositoty {

    /**
     * Permite construir el controlador de Login, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public UserController(Model model, View view, ProblemsController problemsController) {
        super(model, view);
        this.problemsController = problemsController;
    }

    protected void addListeners() {
        loginListener();
        registerListener();
    }

    private void registerListener() {
        view.getPnLogin().getBtnCrearCuenta().addActionListener(ae -> {
            //System.out.println("Crear cuenta CLASS UserController 67");
        });
    }

    private void loginListener() {
        view.getPnLogin().getBtnInicarSesion().addActionListener(ae -> {
            UserRepository userProfileLogged = model.getUser().login(view.getPnLogin().getUsuario(), view.getPnLogin().getContrasenia());
            //System.out.println("Login = " + isLogin + "CLASS UserController 52");
            if (userProfileLogged != null) {
                view.updateTab(view.getPnLeonetApp(), "Inicio");
                view.userHasLogged();
                view.getPnHeader().setUserProfile(userProfileLogged);
                view.getPnHeader().updateHeader();
                view.setUserNickname(view.getPnLogin().getUsuario());
                loadProblems();
            } else {
                view.getPnLogin().invalidCredentials();
            }
        });
    }

    private void loadProblems() {
        problemsController = new ProblemsController(model, view);
        problemsController.chooseTypeProblem();
        advaceButtonsController = new AdvaceButtonsController(model, view);
    }
}
