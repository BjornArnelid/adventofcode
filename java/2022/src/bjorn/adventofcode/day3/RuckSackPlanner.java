package bjorn.adventofcode.day3;

import java.util.List;
import java.util.Optional;

public class RuckSackPlanner {
	private static final int LOWERCASE_STARTING_NUMBER = 96;
	private static final int UPPERCASE_STARTING_NUMBER = 38;
	private static final int ALPHABET_LENGTH = 26;
	
	private RuckSackPlanner() {
		// Hidden constructor
	}

	public static Optional<Character> check(final String rucksackContents) {
		int halfway = rucksackContents.length()/2;
		String firstCompartment = rucksackContents.substring(0, halfway);
		String secondCompartment = rucksackContents.substring(halfway);
		
		for(char item : firstCompartment.toCharArray()) {
			if (findLetter(item, secondCompartment)) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

	public static int evaluate(final char letter) {
		if (LOWERCASE_STARTING_NUMBER < letter && LOWERCASE_STARTING_NUMBER + ALPHABET_LENGTH >= letter) {
			return letter - LOWERCASE_STARTING_NUMBER;
		}
		return letter - UPPERCASE_STARTING_NUMBER;
	}

	public static int evaluate(final List<String> rucksacks) {
		return rucksacks.stream().map(RuckSackPlanner::evaluateIfDuplicate).reduce(0, (subtotal, element) -> subtotal + element);
	}
	
	private static int evaluateIfDuplicate(final String rucksack) {
		final Optional<Character> duplicate = check(rucksack);
		if (duplicate.isPresent()) {
			return evaluate(duplicate.get());
		}
		return 0;
	}

	public static boolean findLetter(char letter, String string) {
		return string.chars().anyMatch(i -> i == letter);
	}

	public static char findBadge(List<String> rucksacks) {
		for (char item : rucksacks.get(0).toCharArray()) {
			if(findLetter(item, rucksacks.get(1))) {
				if (findLetter(item, rucksacks.get(2))) {
					return item;
				}
			}
		}
		return 0;
	}

	public static int countAllBadges(List<String> rucksacks) {
		int sum = 0;
		for (int i = 0; i < rucksacks.size(); i += 3) {
			char found = findBadge(rucksacks.subList(i, i+3));
			sum += evaluate(found);
		}
		return sum;
	}
}
