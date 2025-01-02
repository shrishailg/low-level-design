package main.java.version_control;

import java.beans.beancontext.BeanContext;
import java.util.HashMap;
import java.util.Map;

public class VersionControlSystem implements Repository {
    private final Map<String, Branch> branchMap;

    public VersionControlSystem() {
        this.branchMap = new HashMap<>();
    }

    @Override
    public void createBranch(String name) {
        if (branchMap.containsKey(name)) {
            System.out.println("Branch already present");
        } else {
            branchMap.put(name, new Branch(name));
        }
    }

    @Override
    public void commit(String branchName, Commit commit) {
        if (!branchMap.containsKey(branchName)) {
            System.out.println("Invalid branch name");
        } else {
            Branch branch = branchMap.get(branchName);
            branch.addCommit(commit);
        }
    }

    @Override
    public void mergeBranch(String sourceBranchName, String targetBranchName) {
        Branch sourceBranch = branchMap.get(sourceBranchName);
        Branch targetBranch = branchMap.get(targetBranchName);

        if (sourceBranch != null && targetBranch != null) {
            Commit sourceBranchHead = sourceBranch.getHead();
            Commit targetBranchHead = targetBranch.getHead();

            if (targetBranchHead != null && !targetBranchHead.equals(sourceBranchHead)) {
                System.out.println("Merging could result in conflicts.");
            } else {
                targetBranch.addCommit(sourceBranchHead);
            }
        }

    }

    @Override
    public Branch getBranch(String branchName) {
        Branch branch = branchMap.get(branchName);
        if (branch == null) {
            System.out.println("Branch does not exist.");
            return null;
        }

        return branch;
    }
}
