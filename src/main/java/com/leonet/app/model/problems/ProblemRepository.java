package com.leonet.app.model.problems;

public class ProblemRepository {
    private String contextProblem;
    private String exampleProblem;
    private String definitionProblem;
    private int rewardCoin;
    private int linesContext;
    private int linesExample;
    private int linesDefProblem;
    private double percentageCompletion;


    public ProblemRepository(String contextProblem, String exampleProblem,
                             String definitionProblem, int rewardCoin, double percentageCompletion,
                             int linesContext,
                             int linesExample, int linesDefProblem) {
        this.contextProblem = contextProblem;
        this.exampleProblem = exampleProblem;
        this.definitionProblem = definitionProblem;
        this.rewardCoin = rewardCoin;
        this.percentageCompletion = percentageCompletion;
        this.linesContext = linesContext;
        this.linesExample = linesExample;
        this.linesDefProblem = linesDefProblem;
    }

    public int linesContext() {
        return linesContext;
    }

    public int linesExample() {
        return linesExample;
    }

    public int linesDefProblem() {
        return linesDefProblem;
    }

    public String getContextProblem() {
        return contextProblem;
    }

    public String getExampleProblem() {
        return exampleProblem;
    }

    public String getDefinitionProblem() {
        return definitionProblem;
    }

    public int getRewardCoin() {
        return rewardCoin;
    }
}
