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
                .addTech(eng1)
                .addTech(eng2, eng1)
                .addTech(eng3, eng2)
                .build();

        Tech tech1 = new Tech(10, "Wind Turbine");
        Tech tech2 = new Tech(40, "Solar Panel");
        Tech tech3 = new Tech(100, "Nuclear Reactor");
        Tech tech4 = new Tech(1000, "Fusion Reactor");
        Tech tech5 = new Tech(10000, "Dyson Sphere");

        TechBranch powerBranch = new TechBranch.Builder()
                .addTech(tech1)
                .addTech(tech2, tech1)
                .addTech(tech3, tech2)
                .addTech(tech4, tech3)
                .addTech(tech5, tech4)
                .build();

        Tech stone = new Tech(5, "Stone Ore");
        Tech coal = new Tech(10, "Coal Ore");
        Tech iron = new Tech(20, "Iron Ore");

        TechBranch mineralBranch = new TechBranch.Builder()
                .addTech(stone)
                .addTech(coal, stone)
                .addTech(iron, coal, eng1)
                .build();

        TechTree techTree = new TechTree(mineralBranch);

        System.out.println(powerBranch.toString());
        System.out.println(engineBranch.toString());
        System.out.println(mineralBranch.toString());

        Tech next = powerBranch.getTech(0);
    }
}
