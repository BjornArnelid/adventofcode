package bjorn.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import bjorn.adventofcode.day1.CaloriesCounter;

public class RunCode {
    public static void main(String[] args) {
        if (args.length > 0) {
            String day = args[0];
            try {
                if (day.equals("1")) {
                    day1();
                } else {
                    System.out.println("Day " + day + " not implemented yet!");
                }
            } catch (IOException e) {
                System.out.println("Error reading file!");
                e.printStackTrace();
            }
        } else {
            System.out.println("Select a day!");
        }
    }

    private static void day1() throws IOException {
        System.out.println("Starting part one...");
        List<List<Long>> elfs = new ArrayList<>();
        List<String> input = readInput("data/day1.data").toList();
        List<Long> elfList = new ArrayList<Long>();
        for (String value : input) {
        	if(!value.isBlank()) {
        		elfList.add(Long.valueOf(value.strip()));
        	} else {
        		elfs.add(elfList);
        		elfList = new ArrayList<>();
        	}
        }
        
		elfs.add(elfList);
		elfList = new ArrayList<>();
		
        System.out.println("Answer part 1: " + CaloriesCounter.countMax(elfs));
        
        System.out.println("Starting part two...");
        
        System.out.println("Answer part 2: " + CaloriesCounter.countTopThree(elfs));
    }
    
    private static Stream<String> readInput(String path) throws IOException {
        Path p = Paths.get(path);
        BufferedReader reader = Files.newBufferedReader(p);
        return reader.lines();
    }
}
