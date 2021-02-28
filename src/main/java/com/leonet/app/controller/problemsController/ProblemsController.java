package com.leonet.app.controller.problemsController;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.controller.problemsController.listProblem.ListProblemController;
import com.leonet.app.model.Model;
import com.leonet.app.view.View;

public class ProblemsController extends ControllerRepositoty {
    public ProblemsController(Model model, View view) {
        super(model, view);
    }

    private final String ITEMS_LIST = "ITEMS_LIST";
    private final String FLOWCHART = "FLOWCHART";
    private final String CODE = "CODE";

    // Sub-controllers
    ListProblemController listProblemController;

    @Override
    protected void addListeners() {
        String typeProblem = /** Model.user..tag del problema*/ "ITEMS_LIST";
        switch (typeProblem) {
            case ITEMS_LIST:
                listProblemController = new ListProblemController(model, view);
                break;
            case FLOWCHART:
                break;
            case CODE:
                break;
        }
    }

}
