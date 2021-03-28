package me.techTree.control;

import java.util.ArrayList;

public class TechTree {

    private final ArrayList<TechBranch> branches;

    public TechTree(TechBranch initialBranch) {
        branches = new ArrayList<>();
        branches.add(initialBranch);
    }

    public void addBranch(TechBranch branch) {
        branches.add(branch);
    }

    public TechBranch getBranch(int index) {
        return branches.get(index);
    }
}
