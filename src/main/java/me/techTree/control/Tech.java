package me.techTree.control;

import java.util.ArrayList;

/**
 * Researchable technology implementation. Needs resources and the previous tech to be researched and unlocks new tech.
 *
 * @author MafioP
 */
public class Tech {
    private int minResources;
    private ArrayList<Tech> unlocks;
    private ArrayList<Tech> requires;
    private String name;
    private boolean researched;

    public Tech (int minResources, String name) {
        this.minResources = minResources;
        this.name = name;
        unlocks = new ArrayList<>();
        requires = new ArrayList<>();
        researched = false;
    }

    public void research(int resources) {
        if (resources != minResources) {
            throw new IllegalArgumentException("Resources provided do not match resources required");
        }
        if (requires == null) {
            researched = true;
            return;
        }
        if(!isResearchable()) {
            throw new IllegalCallerException("Previous tech is not researched");
        }
        researched = true;
    }

    /**
     * @return true if tech is researched or false if it is not
     */
    public boolean isResearched() {
        return researched;
    }

    public boolean isResearchable() {
        boolean resercheable = true;
        for(Tech tech : requires) {
            if (!tech.isResearched()) {
                resercheable = false;
                break;
            }
        }
        return resercheable;
    }

    public int getMinResources() {
        return minResources;
    }

    public void setMinResources(int minResources) {
        this.minResources = minResources;
    }

    public ArrayList<Tech> getUnlocks() {
        return unlocks;
    }

    public void addUnlocks(Tech unlocks) {
        this.unlocks.add(unlocks);
    }

    public void addUnlocks(ArrayList<Tech> unlocks) {
        this.unlocks.addAll(unlocks);
    }

    public ArrayList<Tech> getRequires() {
        return requires;
    }

    public void addRequires(Tech requires) {
        this.requires.add(requires);
    }

    public void addRequires(ArrayList<Tech> requires) {
        this.requires.addAll(requires);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tech{" +
                "minResources=" + minResources +
                ", name='" + name + '\'' +
                '}';
    }
}

