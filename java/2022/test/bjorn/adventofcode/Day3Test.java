package bjorn.adventofcode;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import bjorn.adventofcode.day3.RuckSackPlanner;

class Day3Test {

	@ParameterizedTest
	@CsvSource({"p,vJrwpWtwJgWrhcsFMMfFFhFp", "L,jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "P,PmmdzqPrVvPwwTWBwg", 
		"v,wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "t,ttgJtRGJQctTZtZT", "s,CrZsJsPPZsGzwwsLwLmpwMDw"})
	void testFindDuplicatep(char result, String input) {
		assertEquals(Optional.of(result), RuckSackPlanner.check(input));
	}
	
	@ParameterizedTest
	@CsvSource({"1,a", "26,z", "27,A"})
	void testAssignValue(int value, char letter) {
		assertEquals(value, RuckSackPlanner.evaluate(letter));
	}
	
	@Test
	void testEvaluateAllMissingItems() {
		List<String> rucksacks = List.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg", 
		"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw");
		assertEquals(157, RuckSackPlanner.evaluate(rucksacks));
	}
	
	@ParameterizedTest
	@CsvSource({"r,vJrwpWtwJgWrhcsFMMfFFhFp", "r,jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","r,PmmdzqPrVvPwwTWBwg",
		"Z,wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "Z,ttgJtRGJQctTZtZT", "Z,CrZsJsPPZsGzwwsLwLmpwMDw"})
	void testContainsLetter(char letter, String string) {
		assertTrue(RuckSackPlanner.findLetter(letter, string));
	}
	
	@Test
	void testFindBadges() {
		List<String> first = List.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg");
		assertEquals('r', RuckSackPlanner.findBadge(first)); 
		List<String> second = List.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw");
		assertEquals('Z', RuckSackPlanner.findBadge(second));
	}
	
	@Test
	void countBadges() {
		List<String> rucksacks = List.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg", 
		"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw");
		assertEquals(70, RuckSackPlanner.countAllBadges(rucksacks));
	}
}
