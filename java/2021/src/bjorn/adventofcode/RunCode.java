package bjorn.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RunCode {
    public static void main(String[] args) {
        if (args.length > 0) {
            String day = args[0];
            try {
                if (day.equals("1")) {
                    day1();
                } else {
                    System.out.println("You selected day " + day);
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
        Sonar sonar = new Sonar();

        IntStream is = readInput("data/day1.data").mapToInt(Integer::parseInt);
        List<Integer> depths = is.boxed().collect(Collectors.toList());

        System.out.println("Answer part one: " + sonar.countIncreases(depths));

        System.out.println("Starting part two...");
        List<Integer> slidingDepths = sonar.toSlidingList(depths);
        System.out.println("Answer part two: " + sonar.countIncreases(slidingDepths));
    }

    private static Stream<String> readInput(String path) throws IOException {
        Path p = Paths.get(path);
        BufferedReader reader = Files.newBufferedReader(p);
        return reader.lines();
    }
}
