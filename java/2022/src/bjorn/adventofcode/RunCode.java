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
import bjorn.adventofcode.day2.Game;

public class RunCode {
	public static void main(final String[] args) {
		if (args.length > 0) {
			final String day = args[0];
			try {
				if (day.equals("1")) {
					day1();
				} else if (day.equals("2")) {
					day2();
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
		final List<List<Long>> elfs = new ArrayList<>();
		final List<String> input = readInput("data/day1.data").toList();
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

		System.out.println("Answer part 1: " + CaloriesCounter.countMax(elfs));

		System.out.println("Starting part two...");

		System.out.println("Answer part 2: " + CaloriesCounter.countTopThree(elfs));
	}

	private static void day2() throws IOException {
		System.out.println("Starting part one...");
		Game game = new Game();
		readInput("data/day2.data").forEach(game::playRound);

		System.out.println("Answer part 1: " + game.getScore());
		
		System.out.println("Starting part two...");

		game = new Game();
		readInput("data/day2.data").forEach(game::playTranslatedRound);

		System.out.println("Answer part 2: " + game.getScore());
	}

	private static Stream<String> readInput(final String path) throws IOException {
		final Path p = Paths.get(path);
		final BufferedReader reader = Files.newBufferedReader(p);
		return reader.lines();
	}
}
