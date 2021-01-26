package me.techTree.control;

import java.util.ArrayList;

public class TechBranch {
    public static class Builder {
        private final ArrayList<Tech> branch;

        public Builder () {
            branch = new ArrayList<>();
        }
        public Builder firstTech(Tech first) {
            first.setRequires(null);
            branch.add(first);
            return this;
        }
        public Builder nextTech(Tech next) {
            branch.get(branch.size() - 1).setUnlocks(next);
            branch.add(next);

            if (branch.size() > 1) {
                branch.get(branch.size() - 1).setRequires(branch.get(branch.size() - 2));
            }
            return this;
        }

        public Builder lastTech(Tech last) {
            branch.get(branch.size() - 1).setUnlocks(last);
            last.setRequires(branch.get(branch.size() - 1));
            last.setUnlocks(null);
            branch.add(last);
            return this;
        }

        public Builder branchesInto(TechBranch newBranch) {
            newBranch.getTech(0).setRequires(branch.get(branch.size() - 1));
             branch.get(branch.size()-1).setUnlocks(newBranch.getTech(0));
            return this;
        }

        public TechBranch build() {
            TechBranch techBranch = new TechBranch();
            techBranch.branch = branch;

            return techBranch;
        }
    }

    private ArrayList<Tech> branch;
    private TechBranch() {
        branch = new ArrayList<>();
    }

    public Tech getNextTech() {
        for (Tech e : branch) {
            if (!e.isResearched()) {
                return e;
            }
        }
        throw new NullPointerException("There is no next tech to research");
    }

    public Tech getTech(int index) {
        return branch.get(index);
    }

    @Override
    public String toString() {
        String techs = "";
        for (Tech tech : branch) {
            techs = techs + tech.toString() + " Requires: "+ tech.getRequires() + ", Unlocks " +
                    tech.getUnlocks()+ "\n";
        }
        return "TechBranch: \n" + techs;
    }
}
