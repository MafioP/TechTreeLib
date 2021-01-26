package me.techTree.control;

/**
 * Researchable technology implementation. Needs resources and the previous tech to be researched and unlocks new tech.
 *
 * @author MafioP
 */
public class Tech {
    private int minResources;
    private Tech unlocks;
    private Tech requires;
    private String name;
    private boolean researched;

    public Tech (int minResources, String name) {
        this.minResources = minResources;
        this.name = name;
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
        if (!requires.isResearched()) {
            throw new IllegalCallerException("Previous tech is not researched");
        }
        researched = true;
    }

    public boolean isResearched() {
        return researched;
    }

    public int getMinResources() {
        return minResources;
    }

    public void setMinResources(int minResources) {
        this.minResources = minResources;
    }

    public Tech getUnlocks() {
        return unlocks;
    }

    public void setUnlocks(Tech unlocks) {
        this.unlocks = unlocks;
    }

    public Tech getRequires() {
        return requires;
    }

    public void setRequires(Tech requires) {
        this.requires = requires;
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

