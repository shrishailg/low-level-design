package main.java.version_control;

public interface Repository {
    void createBranch(String name);
    void commit(String branchName, Commit commit);
    void mergeBranch(String sourceBranchName, String targetBranchName);
    Branch getBranch(String branchName);
}
