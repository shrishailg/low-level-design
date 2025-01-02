package main.java.version_control;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private final String name;
    private List<Commit> commits;

    public Branch(String name) {
        this.name = name;
        this.commits = new ArrayList<>();
    }

    public void addCommit(Commit commit) {
        commits.add(commit);
    }

    public Commit getHead() {
        if (commits.isEmpty()) {
            return null;
        }

        return commits.get(commits.size()-1);
    }

    public String getName() {
        return name;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }
}
