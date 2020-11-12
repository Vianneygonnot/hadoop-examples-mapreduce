package com.opstty;

import com.opstty.job.Districts;
import com.opstty.job.Show;
import com.opstty.job.WordCount;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that count the words in the input file.");
            programDriver.addClass("show", Show.class,
                    "show species.");
            programDriver.addClass("districts", Districts.class,
                    "A map red program that list of the separate districts containing tress from the input");
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
