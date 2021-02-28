package com.leonet.app.model.problems.itemsListProblem;

import com.leonet.app.model.problems.ProblemRepository;

import java.util.ArrayList;

public class ProblemList extends ProblemRepository {
    private final String PROBLEM_TYPE = "ITEMS_LIST";
    private ArrayList<ItemList> itemListsArray;

    public ProblemList(String contextProblem, String exampleProblem,
                       String definitionProblem, int pointsEarned,
                       int linesContext, int linesExample, int linesDefProblem,
                       ArrayList<ItemList> itemListsArray) {
        super(contextProblem, exampleProblem, definitionProblem,
                pointsEarned, linesContext, linesExample, linesDefProblem);
        this.itemListsArray = itemListsArray;
    }


    public String getPROBLEM_TYPE() {
        return PROBLEM_TYPE;
    }

    public ArrayList<ItemList> getItemListsArray() {
        return itemListsArray;
    }
}
