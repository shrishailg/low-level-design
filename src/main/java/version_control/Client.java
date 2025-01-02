package main.java.version_control;

public class Client {

    public static void main(String[] args) {
        // Create a repository
        Repository repository = new VersionControlSystem();

        // Create branches
        repository.createBranch("master");
        repository.createBranch("feature");

        // Commit changes to the feature branch
        repository.commit("feature", new Commit("1", "Implement feature A"));
        repository.commit("feature", new Commit("2", "Implement feature B"));

        // Merge changes from the feature branch to master
        repository.mergeBranch("feature", "master");
    }
}
