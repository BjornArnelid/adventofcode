package bjorn.adventofcode;

import bjorn.adventofcode.day1.Sonar;
import bjorn.adventofcode.day13.Dot;
import bjorn.adventofcode.day13.Manual;
import bjorn.adventofcode.day2.Submarine;
import bjorn.adventofcode.day3.Diagnostics;
import bjorn.adventofcode.day4.Bingo;
import bjorn.adventofcode.day5.Line;
import bjorn.adventofcode.day5.Navigator;
import bjorn.adventofcode.day6.FishSimulator;
import bjorn.adventofcode.day7.CrabSubmarine;
import bjorn.adventofcode.day8.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
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
                } else if (day.equals("5")) {
                    day5();
                } else if (day.equals("6")) {
                    day6();
                } else if (day.equals("7")) {
                    day7();
                } else if (day.equals("8")) {
                    day8();
                } else if (day.equals("13")) {
                    day13();
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
                board.append(row).append("\n");
            } else {
                boards.add(board.toString());
                board = new StringBuilder();
            }
        }
        return boards;
    }

    private static void day5() throws IOException {
        System.out.println("Starting day 5 part one...");
        Navigator navigator = new Navigator();
        readInput("data/day5.data").forEach(s -> navigator.addLine(createLine(s)));

        System.out.println("Answer part one: " + navigator.getNumberOfOverlapa());
    }

    private static Line createLine(String input) {
        String[] lineStrings = input.split(" -> ");
        String[] first = lineStrings[0].split(",");
        String[] second = lineStrings[1].split(",");
        return new Line(Integer.parseInt(first[0]), Integer.parseInt(first[1]), Integer.parseInt(second[0]), Integer.parseInt(second[1]));
    }

    private static void day6() throws IOException {
        System.out.println("Starting day 6 part one...");

        List<Integer> initialFishes = Arrays.stream(readInput("data/day6.data")
                .findFirst().get().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        FishSimulator simulator = new FishSimulator(initialFishes);
        simulator.step(80);
        System.out.println("Answer part one: " + simulator.getNumberOfFishes());

        System.out.println("Starting part two...");
        simulator.step(256-80);
        NumberFormat myformatter = new DecimalFormat("########");

        String result = myformatter.format(simulator.getNumberOfFishes());
        System.out.println("Answer part two: " + result);

    }

    private static void day7() throws IOException {
        System.out.println("Starting day 7 part one...");
        List<Integer> crabPositions = Arrays.stream(readInput("data/day7.data")
                .findFirst().get().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        System.out.println("Answer part one: " + CrabSubmarine.calculateOptimalFuel(crabPositions, false));

        System.out.println("Answer part two: " + CrabSubmarine.calculateOptimalFuel(crabPositions, true));
    }

    private static void day8() throws IOException {
        System.out.println("Starting day 8 part one...");
        int amount = 0;
        List<String> rows = readInput("data/day8.data").toList();
        for(String row : rows) {
            Display display = new Display();
            String[] signalParts = row.split(Pattern.quote(" | "));
            display.setPattern(Arrays.stream(signalParts[0].split(" ")));
            amount += display.countNumbers(Arrays.stream(signalParts[1].split(" ")));
        }
        System.out.println("Answer part one: " + amount);
    }

    private static void day13() throws IOException {
        System.out.println("Starting day 13 part one...");
        Manual manual = new Manual();
        List<String> rows = readInput("data/day13.data").toList();
        List<String> dotInput = getDotPart(rows);
        List<String> folds = getFolds(rows, dotInput);
        dotInput.stream().forEach(s -> manual.addDot(new Dot(s)));
        String firstFold = folds.get(0);
        if(firstFold.startsWith("y")) {
            manual.foldY(Integer.parseInt(firstFold.substring(2)));
        } else {
            manual.foldX(Integer.parseInt(firstFold.substring(2)));
        }

        String folded = manual.paintDots();
        long count = folded.chars().filter(ch -> ch == '#').count();
        System.out.println("Answer part one: " + count);

        System.out.println("Starting part two...");
        for(String fold : folds.subList(1, folds.size())) {
            if(fold.startsWith("y")) {
                manual.foldY(Integer.parseInt(fold.substring(2)));
            } else {
                manual.foldX(Integer.parseInt(fold.substring(2)));
            }
        }
        System.out.println("Answer part two:\n" + manual.paintDots());
    }

    private static List<String> getDotPart(List<String> rows) {
        ArrayList<String> dots = new ArrayList<>();
        for (String row : rows) {
            if (row.isBlank()) {
                return dots;
            }
            dots.add(row);
        }
        return null;
    }

    private static List<String> getFolds(List<String> rows, List<String> dotInput) {
        ArrayList<String> folds = new ArrayList<>();
        for(String row : rows.subList(dotInput.size() + 1, rows.size())) {
            folds.add(row.substring(11));
        }
        return folds;
    }

    private static Stream<String> readInput(String path) throws IOException {
        Path p = Paths.get(path);
        BufferedReader reader = Files.newBufferedReader(p);
        return reader.lines();
    }
}
