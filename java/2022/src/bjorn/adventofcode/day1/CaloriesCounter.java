package bjorn.adventofcode.day1;

import java.util.List;

public class CaloriesCounter {

	public static Long count(final List<Long> calories) {
		return calories.stream().reduce(0l, Long::sum);
	}

	public static Long countMax(List<List<Long>> elfs) {
		List<Long> totals = mapToSum(elfs);
		return totals.get(totals.size()-1);
	}

	private static List<Long> mapToSum(List<List<Long>> elfs) {
		return elfs.stream().map(CaloriesCounter::count).sorted().toList();
	}

	public static Long countTopThree(List<List<Long>> elfs) {
		List<Long> totals = mapToSum(elfs);
		return totals.get(totals.size()-1) + totals.get(totals.size()-2) + totals.get(totals.size()-3);
	}

}
