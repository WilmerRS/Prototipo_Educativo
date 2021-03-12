package com.leonet.app.controller.problemsController.code;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.model.Model;
import com.leonet.app.model.problems.itemsListProblem.ProblemList;
import com.leonet.app.model.user.UserRepository;
import com.leonet.app.view.View;
import com.leonet.app.view.home.problems.code.PnCalculator;
import com.leonet.app.view.shared.Button;
import com.leonet.app.view.shared.TextField;

import java.util.*;
import java.math.BigInteger;

public class CalculatorController extends ControllerRepositoty {

    public CalculatorController(Model model, View view) {
        super(model, view);
    }

    private void clics(Button button, String numero, TextField textField){
        button.addActionListener(ae -> {
            String temp=textField.getTxtField().getText();
            textField.getTxtField().setText(temp+numero);

        });
    }
    private boolean verifynumber(String num) {
        boolean q=false;
        int temp = Integer.parseInt(num);
        if(temp<=50){
            q=true;
        }
        return q;
    }

    private void btnfactorial(Button button, TextField textField){
        try {
            button.addActionListener(ae -> {
                if(verifynumber(textField.getTxtField().getText())) {
                    String temp = textField.getTxtField().getText();
                    int temp1 = Integer.parseInt(temp);
                    textField.getTxtField().setText("" + factorial((temp1)));
                }else{
                    textField.getTxtField().setText("0");
                }
            });
        }catch (ArrayIndexOutOfBoundsException off){

        }
    }

    private void btndelete(Button button, TextField jTextField1){
        button.addActionListener(ae -> {
            if(jTextField1.getText().length()!=0){
                jTextField1.setText(jTextField1.getText().substring(0, jTextField1.getText().length()-1));
            }

        });
    }

    private void button(){
        PnCalculator calculator = view.getPnLeonetApp().getpProblema().getPnCalculator();
        clics(calculator.getButton0(),"0",calculator.getContainer());
        clics(calculator.getButton1(),"1",calculator.getContainer());
        clics(calculator.getButton2(),"2",calculator.getContainer());
        clics(calculator.getButton3(),"3",calculator.getContainer());
        clics(calculator.getButton4(),"4",calculator.getContainer());
        clics(calculator.getButton5(),"5",calculator.getContainer());
        clics(calculator.getButton6(),"6",calculator.getContainer());
        clics(calculator.getButton7(),"7",calculator.getContainer());
        clics(calculator.getButton8(),"8",calculator.getContainer());
        clics(calculator.getButton9(),"9",calculator.getContainer());
        btndelete(calculator.getButtondelete(),calculator.getContainer());
        btnfactorial(calculator.getButtonfactorial(),calculator.getContainer());
    }

    private BigInteger factorial(int num){
        Map<Integer,BigInteger> factorials = new HashMap<Integer,BigInteger>();
        factorials.put(0,new BigInteger("1"));
        for(Integer i=1; i <= num; ++i)
        {
            BigInteger fact = new BigInteger(i.toString()).multiply(factorials.get(i - 1));
            factorials.put(i,fact);
        }
        return factorials.get(num);
    }

    public void initCalculatorProblem(UserRepository userProfile){
        loadProblem(userProfile);
        button();
    }

    private void loadProblem(UserRepository userProfile) {
        ProblemList pl = model.getProblems().chooseProblemCode(userProfile.getNickname());
        view.getPnLeonetApp().getpContexto().updateContext(pl.getContextProblem(), pl.linesContext());
        view.getPnLeonetApp().getpContexto().updateExample(pl.getExampleProblem(), pl.linesExample());
        view.getPnLeonetApp().getpProblema().updateDefProblem(pl.getDefinitionProblem(), pl.linesDefProblem());


        view.getPnLeonetApp().getpProblema().loadCalculatorProblem();
        view.getPnLeonetApp().repaint();

        updateInfoUserHeader(userProfile.getNickname());
        updateThemeLevel(userProfile.getNickname());
    }

    private void updateThemeLevel(String nickname) {
        double startingPoint = model.getProblems().getAmountProblemSolved(nickname);

        double finalPoint = model.getProblems().getCountSubThemes(nickname);
        double increasePoint = (startingPoint / finalPoint) * 100;
        view.getPnLeonetApp().getpNivel().updateLoadingBar(increasePoint);

        String[] themeCategory = model.getProblems().getThemeCategoryInfo(nickname);
        String level = themeCategory[0];
        String theme = themeCategory[1];
        view.getPnLeonetApp().getpNivel().updateThemeInfo(level, theme);
    }

    private void updateInfoUserHeader(String nickname) {
        UserRepository user = model.getUser().getUserProfile(nickname);
        view.getPnHeader().setUserProfile(user);
        view.getPnHeader().updateInfoUser();
    }

}
