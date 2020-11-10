package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String[] argv) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("districts_list", Districts_list.class,
                    "A map/reduce program that lists districts containing trees");
            programDriver.addClass("species_list", Species_List.class,
                    "A map/reduce program that lists species");
            programDriver.addClass("trees_counter", Trees_counter.class,
                    "A map/reduce program that counts the number of trees by species");
            programDriver.addClass("max_height", Max_Height.class,
                    "A map/reduce program that finds the maximum height of trees in each district");
            programDriver.addClass("sort_trees", Sort_Tree.class,
                    "A map/reduce program that sorts the trees height from smallest to largest");
            programDriver.addClass("oldest_tree", Oldest_Tree.class,
                    "A map/reduce program that give the oldest tree in the trees csv files.");
            programDriver.addClass("most_trees", Most_Trees.class,
                    "A map/reduce program that displays the district containing the most trees");
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
