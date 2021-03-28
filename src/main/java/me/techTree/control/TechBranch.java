package me.techTree.control;

import java.util.ArrayList;
import java.util.Arrays;

public class TechBranch {
    public static class Builder {
        private final ArrayList<Tech> branch;

        public Builder () {
            branch = new ArrayList<>();
        }

        public Builder addTech(Tech tech, Tech ...requires) {
            tech.addRequires(new ArrayList<>(Arrays.asList(requires)));
            branch.add(tech);
            return this;
        }

        public TechBranch build() {
            branch.forEach(e -> e.getRequires().forEach(e1 -> e1.addUnlocks(e)));
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

    public ArrayList<Tech> getTechs() {
        return new ArrayList<>(branch);
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
