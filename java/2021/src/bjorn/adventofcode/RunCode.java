package bjorn.adventofcode;

import bjorn.adventofcode.day1.Sonar;
import bjorn.adventofcode.day2.Submarine;
import bjorn.adventofcode.day3.Diagnostics;
import bjorn.adventofcode.day4.Bingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
                } else if (day.equals("2")) {
                    day2();
                } else if (day.equals("3")) {
                    day3();
                } else if (day.equals("4")) {
                    day4();

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

    private static void day2() throws IOException {
        System.out.println("Starting part one...");
        Submarine submarine = new Submarine();
        submarine.move(readInput("data/day2.data"));

        System.out.println("Answer part one: " + submarine.getDepth() * submarine.getDistance());

        System.out.println("Starting part two...");
        submarine = new Submarine();
        submarine.aim(readInput("data/day2.data"));

        System.out.println("Answer part two: " + submarine.getDepth() * submarine.getDistance());
    }

    private static void day3() throws IOException {
        System.out.println("Starting part one...");
        Diagnostics diagnostics = new Diagnostics();
        int gamma = diagnostics.getGamma(readInput("data/day3.data"));
        int epsilon = diagnostics.getEpsilon(readInput("data/day3.data"));

        System.out.println("Answer part one: " + gamma * epsilon);

        System.out.println("Starting part two...");
        int oxygenGenerator = diagnostics.getOxygenGenerator(readInput("data/day3.data"));
        int co2Scrubber = diagnostics.getCO2Scrubber(readInput("data/day3.data"));

        System.out.println("Answer part two: " + oxygenGenerator * co2Scrubber);

    }

    private static void day4() throws IOException {
        System.out.println("Starting part one...");
        List<String> fileInput = readInput("data/day4.data").toList();
        String numbers = fileInput.get(0);

        Bingo bingo = new Bingo(createBoards(fileInput.subList(2, fileInput.size())));
        for(String number : numbers.split(",")) {
            bingo.playNumber(number);
            int score = bingo.getScore();
            if(score != 0) {
                System.out.println("Answer part one: " + (score * Integer.parseInt(number)));
                break;
            }
        }

        System.out.println("Starting part two...");

        bingo = new Bingo(createBoards(fileInput.subList(2, fileInput.size())));
        String lastnumber = "";
        for(String number : numbers.split(",")) {
            bingo.playNumber(number);
            int score = bingo.getScore();
            if(bingo.boardsInPlay() == 0) {
                System.out.println("Answer part two: " + (score * Integer.parseInt(number)));
                break;
            } else if (bingo.boardsInPlay() == 1) {
                System.out.println("One left!");
            }
            lastnumber = number;
        }
    System.out.println("Finished all numbers last winner score is " +
            (bingo.getLastScore() *  Integer.parseInt(lastnumber)));
    }

    private static List<String> createBoards(List<String> input) {
        ArrayList<String> boards = new ArrayList<>();
        StringBuilder board = new StringBuilder();
        for(String row : input) {
            if(!row.isEmpty()) {
                board.append(row + "\n");
            } else {
                boards.add(board.toString());
                board = new StringBuilder();
            }
        }
        return boards;
    }

    private static Stream<String> readInput(String path) throws IOException {
        Path p = Paths.get(path);
        BufferedReader reader = Files.newBufferedReader(p);
        return reader.lines();
    }
}
