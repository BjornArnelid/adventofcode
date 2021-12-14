import bjorn.adventofcode.day9.HeatMap;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Test {
    @Test
    public void testLowestInRow() {
        HeatMap map = new HeatMap();
        map.addRow("2199943210");
        assertEquals(3, map.calculateRisk());
    }

    @Test
    public void testLowestInSquare() {
        HeatMap map = new HeatMap();
        map.addRow("2199943210");
        map.addRow("3987894921");
        map.addRow("9856789892");
        map.addRow("8767896789");
        map.addRow("9899965678");
        assertEquals(15, map.calculateRisk());
    }
}
