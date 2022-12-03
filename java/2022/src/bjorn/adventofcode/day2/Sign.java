package bjorn.adventofcode.day2;

import java.util.stream.Stream;

public enum Sign {
	Rock(1), Paper(2), Cissor(3);

	private int value;

	Sign(final int value) {
		this.value = value;
	}

	public static Sign[] parse(final String input) {
		Stream<Sign> signs = Stream.of(input.split(" ")).map(Sign::parsePart);
		return signs.toArray(Sign[]::new);
	}
	
	private static Sign parsePart(String part) {
		switch(part) {
		case "A", "X":
			return Rock;
		case "B", "Y":
			return Paper;
		case "C", "Z":
			return Cissor;
		default:
			throw new IllegalStateException();
		}
			
	}

	public Integer count() {
		return value;
	}

	public static Sign[] translate(String string) {
		String[] parts = string.split(" ");
		Sign opponent = parsePart(parts[0]);
		Sign you = translatePart(opponent, parts[1]);
		return new Sign[] {opponent, you};
	}

	public static Sign translatePart(Sign opponent, String result) {
		if(result.equals("Y")) {
			return opponent;
		} else if (result.equals("X")) {
			return getFromValue(lower(opponent.value));
		} else if (result.equals("Z")) {
			return getFromValue(higher(opponent.value));
		}
		return null;
	}
	
	private static int higher(int value) {
		int toReturn = value + 1;

		if (toReturn > 3) {
			toReturn = 1;
		}
		return toReturn;
	}

	private static int lower(int value) {
		int toReturn = value - 1;

		if (toReturn < 1) {
			toReturn = 3;
		}
		return toReturn;
	}

	private static Sign getFromValue(int value) {
		if (value == 1) {
			return Rock;
		} else if (value == 2) {
			return Paper;
		} else if (value == 3) {
			return Cissor;
		}
		throw new IllegalStateException();
	}
}
