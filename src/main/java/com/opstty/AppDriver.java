package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String args[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("oldest", Oldest.class,
                    "A map/reduce program that that sort the displays the district where the oldest tree is.");
            programDriver.addClass("sortheight", SortHeight.class,
                    "A map/reduce program that that sort the trees height from smallest to largest.");
            programDriver.addClass("numbertree", NumberOfTreesBySpecies.class,
                    "A map/reduce program that count the tree by species.");
            programDriver.addClass("highest", Highest.class,
                    "A map/reduce program that count the words in the input file.");
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that count the words in the input file.");
            programDriver.addClass("show", Show.class,
                    "show all species.");
            programDriver.addClass("districts", Districts.class,
                    "A map red program that list of the separate districts containing trees from the input");
            exitCode = programDriver.run(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
