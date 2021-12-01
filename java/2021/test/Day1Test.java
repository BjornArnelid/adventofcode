import bjorn.adventofcode.Sonar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Day1Test {
    @Test
    public void testDepthIncreases() {
        Sonar sonar= new Sonar();
        boolean increased = sonar.hasIncreased(1,2);
        assertTrue(increased);
    }

    @Test
    public void testCountIncreased() {
        Sonar sonar= new Sonar();
        List<Integer> depths = new ArrayList<>(Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263));
        int increases = sonar.countIncreases(depths);
        assertEquals(7, increases);
    }

    @Test
    public void  testSumOfValues() {
        Sonar sonar= new Sonar();
        int sum = sonar.sum(199, 200, 208);
        assertEquals(607, sum);
    }

    @Test
    public void testConvertList() {
        Sonar sonar= new Sonar();
        List<Integer> depths = new ArrayList<>(Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263));
        List<Integer> expected = new ArrayList<>(Arrays.asList(607, 618, 618, 617, 647, 716, 769, 792));
        List<Integer> slidingDepths = sonar.toSlidingList(depths);
        assertIterableEquals(expected, slidingDepths);
    }
}