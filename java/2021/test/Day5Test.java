import bjorn.adventofcode.day5.Line;
import bjorn.adventofcode.day5.Navigator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Day5Test {
    @Test
    public void testHorizontalCollide() {
        Navigator navigator = new Navigator(false);
        Line line1 = new Line(0,9,5,9);
        Line line2 = new Line(0,9, 2,9);
        navigator.addLine(line1);
        navigator.addLine(line2);

        assertEquals(3, navigator.getNumberOfOverlapa());
    }

    @Test
    public void testHorizontalOverlap() {
        Navigator navigator = new Navigator(false);
        Line line1 = new Line(9,4, 3, 4);
        Line line2 = new Line(7, 0, 7, 4);
        navigator.addLine(line1);
        navigator.addLine(line2);

        assertEquals(1, navigator.getNumberOfOverlapa());
    }

    @Test
    public void testVentMap() {
        Navigator navigator = new Navigator(false);
        navigator.addLine(new Line(0,9,5,9));
        navigator.addLine(new Line(8,0,0,8));
        navigator.addLine(new Line(9,4,3,4));
        navigator.addLine(new Line(2,2,2,1));
        navigator.addLine(new Line(7,0,7,4));
        navigator.addLine(new Line(6,4,2,0));
        navigator.addLine(new Line(0,9,2,9));
        navigator.addLine(new Line(3,4,1,4));
        navigator.addLine(new Line(0,0,8,8));

        assertEquals(5, navigator.getNumberOfOverlapa());
    }

    @ParameterizedTest
    @MethodSource("diagonalLineSource")
    public void testDiagonalOverlap(Line first, Line second) {
        Navigator navigator = new Navigator(true);
        navigator.addLine(first);
        navigator.addLine(second);

        assertEquals(1, navigator.getNumberOfOverlapa());
    }

    private static Stream<Arguments> diagonalLineSource() {
        return Stream.of(
                arguments(new Line(1,1,1,3), new Line(0,0,3,3)),
                arguments(new Line(0,0,3,3), new Line(1,1,1,3)),
                arguments(new Line(1,1,3,1), new Line(0,0,3,3)),
                arguments(new Line(0,0,3,3), new Line(3,1,3,3)));
    }

    @Test
    public void testDiagonalMap() {
        Navigator navigator = new Navigator(true);
        navigator.addLine(new Line(0,9,5,9));
        navigator.addLine(new Line(8,0,0,8));
        navigator.addLine(new Line(9,4,3,4));
        navigator.addLine(new Line(2,2,2,1));
        navigator.addLine(new Line(7,0,7,4));
        navigator.addLine(new Line(6,4,2,0));
        navigator.addLine(new Line(0,9,2,9));
        navigator.addLine(new Line(3,4,1,4));
        navigator.addLine(new Line(0,0,8,8));
        navigator.addLine(new Line(5,5,8,2));

        assertEquals(12, navigator.getNumberOfOverlapa());
    }
}
