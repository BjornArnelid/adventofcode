import bjorn.adventofcode.day13.Dot;
import bjorn.adventofcode.day13.Manual;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Test {
    private static String dotString = """
        6,10
        0,14
        9,10
        0,3
        10,4
        4,11
        6,0
        6,12
        4,1
        0,13
        10,12
        3,4
        3,0
        8,4
        1,10
        2,14
        8,10
        9,0""";

    @Test
    public void testAddDot() {
        Manual manual = new Manual();
        manual.addDot(new Dot(6,10));
        assertEquals(1, manual.getDots().size());
    }

    @Test
    public void testPrintSingleDot() {
        Manual manual = new Manual();
        manual.addDot(new Dot(3,1));
        assertEquals("....\n...#", manual.paintDots());
    }

    @Test
    public void testPrintDots() {
        Manual manual = new Manual();
        Stream.of(dotString.split("\n")).forEach(s ->manual.addDot(new Dot(s)));

        String map = """
                ...#..#..#.
                ....#......
                ...........
                #..........
                ...#....#.#
                ...........
                ...........
                ...........
                ...........
                ...........
                .#....#.##.
                ....#......
                ......#...#
                #..........
                #.#........""";
        assertEquals(map, manual.paintDots());
    }

    @Test
    public void testFoldY() {
        Manual manual = new Manual();
        Stream.of(dotString.split("\n")).forEach(s ->manual.addDot(new Dot(s)));
        manual.foldY(7);
        String folded = """
                #.##..#..#.
                #...#......
                ......#...#
                #...#......
                .#.#..#.###""";
        assertEquals(folded, manual.paintDots());
    }

    @Test
    public void testFoldX() {
        Manual manual = new Manual();
        Stream.of(dotString.split("\n")).forEach(s ->manual.addDot(new Dot(s)));
        manual.foldY(7);
        manual.foldX(5);
        String folded = """
                #####
                #...#
                #...#
                #...#
                #####""";
        assertEquals(folded, manual.paintDots());
    }
}
