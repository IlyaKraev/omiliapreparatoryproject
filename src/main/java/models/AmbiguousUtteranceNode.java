package models;

public class AmbiguousUtteranceNode {

    private int position;
    private int potentialBranches;
    private String pattern;

    public AmbiguousUtteranceNode() {
    }

    public AmbiguousUtteranceNode(int position, String pattern) {
        this.position = position;
        this.pattern = pattern;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPotentialBranches() {
        return potentialBranches;
    }

    public void setPotentialBranches(int potentialBranches) {
        this.potentialBranches = potentialBranches;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
