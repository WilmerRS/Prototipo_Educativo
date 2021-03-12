package com.leonet.app.controller.problemsController;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.model.Model;
import com.leonet.app.view.View;
import com.leonet.app.view.home.problems.listProblem.PnItemList;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.ResultDialog;

import java.util.ArrayList;

public class AdvaceButtonsController extends ControllerRepositoty {
    /**
     * Permite construir el controlador base, que une el la interfaz con el modelo
     *
     * @param model Modelo, parte lógica del programa
     * @param view  Interfaz, parte visual del programa
     */
    public AdvaceButtonsController(Model model, View view) {
        super(model, view);
    }

    @Override
    protected void addListeners() {
        view.getPnLeonetApp().getpBotones().getBtnSig().addActionListener(ae -> {
            ArrayList<PnItemList> pnItemListArray = view.getPnLeonetApp().getpProblema().getPnListProblem().getPnItemListArray();
            boolean correct = true;
            for (PnItemList item : pnItemListArray) {
                if (item.getCurrentPosition() != item.getCorrectPosition()) {
                    correct = false;
                }
            }
            if (correct) {
                ResultDialog resultDialog = new ResultDialog(view, true, "Se ha completado el reto correctamente.", Patron.DONE_TYPE_MODAL);
                resultDialog.setVisible(true);
                String userProfileNickname = view.getPnHeader().getUserProfile().getNickname();
                double percentageCompletion = model.getProblems().getPercentageCompletion(userProfileNickname);
                view.getPnLeonetApp().getpNivel().getLoadingBar().increasePoints((int) (percentageCompletion));
                if (problemsController == null) {
                    problemsController = new ProblemsController(model, view);
                }
                boolean nextProblemAvailable = model.getUser().advanceToNextTheme(userProfileNickname);
                System.out.println("nextProblemAvailable "+ nextProblemAvailable);
                if (nextProblemAvailable) {
                    problemsController.chooseTypeProblem();
                }
            } else {
                ResultDialog resultDialog = new ResultDialog(view, true, "La respuesta no es correcta.", Patron.ERROR_TYPE_MODAL);
                resultDialog.setVisible(true);
            }
        });
    }


}
