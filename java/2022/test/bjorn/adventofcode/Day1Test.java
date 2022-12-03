package bjorn.adventofcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import bjorn.adventofcode.day1.CaloriesCounter;

class Day1Test {
	private final static List<Long> elf1 = List.of(1000l, 2000l, 3000l);
	private final static List<Long> elf2 = List.of(4000l);
	private final static List<Long> elf3 = List.of(5000l, 6000l);
	private final static List<Long> elf4 = List.of(7000l, 8000l, 9000l);
	private final static List<Long> elf5 = List.of(10000l);
	
	private List<List<Long>> elfs = List.of(elf1, elf2, elf3, elf4, elf5);
	
	@Test
	void testCountCalories() {
		List<Long> calories = List.of(1000l, 2000l, 3000l);
		assertEquals(6000l, CaloriesCounter.count(calories));
	}

	@Test
	void testMostCalories() {
		assertEquals(24000l, CaloriesCounter.countMax(elfs));
	}
	
	@Test
	void testTop3() {
		assertEquals(45000l, CaloriesCounter.countTopThree(elfs));
	}
}
