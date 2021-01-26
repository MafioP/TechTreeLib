package test;

import me.techTree.control.Tech;
import me.techTree.control.TechBranch;
import me.techTree.control.TechTree;

public class TestTree {

    public static void main(String[] args) {

        Tech eng1 = new Tech(200, "Chemical Engine");
        Tech eng2 = new Tech(1000, "Ion engine");
        Tech eng3 = new Tech(4000, "Epstein Drive");

        TechBranch engineBranch = new TechBranch.Builder()
                .firstTech(eng1)
                .nextTech(eng2)
                .lastTech(eng3)
                .build();

        Tech tech1 = new Tech(10, "Wind Turbine");
        Tech tech2 = new Tech(40, "Solar Panel");
        Tech tech3 = new Tech(100, "Nuclear Reactor");
        Tech tech4 = new Tech(1000, "Fusion Reactor");
        Tech tech5 = new Tech(10000, "Dyson Sphere");

        TechBranch powerBranch = new TechBranch.Builder()
                .firstTech(tech1)
                .nextTech(tech2)
                .nextTech(tech3)
                .branchesInto(engineBranch)
                .nextTech(tech4)
                .lastTech(tech5)
                .build();

        Tech stone = new Tech(5, "Stone Ore");
        Tech coal = new Tech(10, "Coal Ore");
        Tech iron = new Tech(20, "Iron Ore");

        TechBranch mineralBranch = new TechBranch.Builder()
                .firstTech(stone)
                .nextTech(coal)
                .lastTech(iron)
                .branchesInto(powerBranch)
                .build();

        TechTree techTree = new TechTree(mineralBranch);

        System.out.println(powerBranch.toString());
        System.out.println(engineBranch.toString());
        System.out.println(mineralBranch.toString());

        Tech next = powerBranch.getTech(0);
    }
}
