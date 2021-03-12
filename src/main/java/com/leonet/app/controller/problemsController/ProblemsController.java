package com.leonet.app.controller.problemsController;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.controller.problemsController.code.CalculatorController;
import com.leonet.app.controller.problemsController.listProblem.ListProblemController;
import com.leonet.app.model.Model;
import com.leonet.app.model.user.UserRepository;
import com.leonet.app.view.View;
import com.leonet.app.view.home.problems.code.PnCalculator;

public class ProblemsController extends ControllerRepositoty {
    private final String ITEMS_LIST = "ITEMS_LIST";
    private final String FLOWCHART = "FLOWCHART";
    private final String CODE = "CODE";
    private final String FINISH = "FINISH";

    public ProblemsController(Model model, View view) {
        super(model, view);
    }

    public void chooseTypeProblem() {
        UserRepository userProfile = model.getUser().getUserProfile();
        String typeProblem = model.getProblems().getTypeProblem(userProfile.getNickname());
        switch (typeProblem.toUpperCase()) {
            case ITEMS_LIST:
                if (listProblemController == null) {
                    listProblemController = new ListProblemController(model, view);
                }
                listProblemController.initProblemList(userProfile, ITEMS_LIST);
                break;
            case FLOWCHART:
                break;
            case CODE:
                if (pnCalculator == null) {
                    pnCalculator = new CalculatorController(model, view);
                }
                pnCalculator.initCalculatorProblem(userProfile);
                break;
            case FINISH:
                break;
        }
    }

}
