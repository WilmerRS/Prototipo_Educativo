/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.model;

import com.leonet.app.model.databaseConection.ConectionBD;
import com.leonet.app.model.problems.Problems;
import com.leonet.app.model.user.User;

/**
 * Clase que tiene toda la parte logica del programa
 *
 * @author WILMER
 */
public class Model extends ConectionBD {

    private User user;
    private Problems problems;

    public Model() {
        super();
        initModels();
    }

    public User getUser() {
        return user;
    }

    public Problems getProblems() {
        return problems;
    }

    private void initModels() {
        user = new User(this.getBasicDataSource());
        problems = new Problems(this.getBasicDataSource());
    }
}
