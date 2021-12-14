import bjorn.adventofcode.day8.Display;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Test {
    @Test
    public void testIsOne() {
        Display display = new Display();
        display.setPattern(Arrays.stream("ab".split(" ")));
        assertEquals("1", display.translateOutput(Arrays.stream("ab".split(" "))));
    }

    @Test
    public void testIsFour() {
        Display display = new Display();
        display.setPattern(Arrays.stream("eafb".split(" ")));
        assertEquals("4", display.translateOutput(Arrays.stream("eafb".split(" "))));
    }

    @Test
    public void testIsSeven() {
        Display display = new Display();
        display.setPattern(Arrays.stream("dab".split(" ")));
        assertEquals("7", display.translateOutput(Arrays.stream("dab".split(" "))));
    }

    @Test
    public void testIsEight() {
        Display display = new Display();
        display.setPattern(Arrays.stream("acedgfb".split(" ")));
        assertEquals("8", display.translateOutput(Arrays.stream("acedgfb".split(" "))));
    }

    @Test
    public void testCountEasyNumbers() {
        Display display = new Display();
        display.setPattern(Arrays.stream("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb".split(" ")));
        assertEquals(2, display.countNumbers(Arrays.stream("fdgacbe cefdb cefbgd gcbe".split(" "))));
    }

    @Test
    @Disabled
    public void testFindNumberFive() {
        Display display = new Display();
        display.setPattern(Arrays.stream("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab".split(" ")));
        assertEquals("5", display.translateOutput(Arrays.stream("cdfeb".split(" "))));
    }
}
