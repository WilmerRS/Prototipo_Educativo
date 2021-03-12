package com.leonet.app.model.problems.itemsListProblem;

import com.leonet.app.model.problems.ProblemRepository;

import java.util.ArrayList;

public class ProblemList extends ProblemRepository {
    private final String PROBLEM_TYPE = "ITEMS_LIST";
    private ArrayList<ItemList> itemListsArray;
    private ArrayList<Integer> indentation;


    public ProblemList(String contextProblem, String exampleProblem,
                       String definitionProblem, int rewardCoin, double percentageCompletion,
                       int linesContext, int linesExample, int linesDefProblem,
                       ArrayList<ItemList> itemListsArray,
                       ArrayList<Integer> indentation) {
        super(contextProblem, exampleProblem, definitionProblem,
                rewardCoin, percentageCompletion, linesContext, linesExample, linesDefProblem);
        this.itemListsArray = itemListsArray;
        this.indentation = indentation;
    }

    public ArrayList<Integer> getIndentation() {
        return indentation;
    }

    public String getPROBLEM_TYPE() {
        return PROBLEM_TYPE;
    }

    public ArrayList<ItemList> getItemListsArray() {
        return itemListsArray;
    }
}
