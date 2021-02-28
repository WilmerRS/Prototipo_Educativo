package com.leonet.app.model.problems;

public class ProblemRepository {
    private String contextProblem;
    private String exampleProblem;
    private String definitionProblem;
    private int pointsEarned;
    private int linesContext;
    private int linesExample;
    private int linesDefProblem;


    public ProblemRepository(String contextProblem, String exampleProblem,
                             String definitionProblem, int pointsEarned, int linesContext,
                             int linesExample, int linesDefProblem) {
        this.contextProblem = contextProblem;
        this.exampleProblem = exampleProblem;
        this.definitionProblem = definitionProblem;
        this.pointsEarned = pointsEarned;
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

    public int getPointsEarned() {
        return pointsEarned;
    }
}
