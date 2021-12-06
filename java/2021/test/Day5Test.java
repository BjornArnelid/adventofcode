import bjorn.adventofcode.day5.Line;
import bjorn.adventofcode.day5.Navigator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Test {
    @Test
    public void testHorizontalCollide() {
        Navigator navigator = new Navigator();
        Line line1 = new Line(0,9,5,9);
        Line line2 = new Line(0,9, 2,9);
        navigator.addLine(line1);
        navigator.addLine(line2);

        assertEquals(3, navigator.getNumberOfOverlapa());
    }

    @Test
    public void testHorizontalOverlap() {
        Navigator naviator = new Navigator();
        Line line1 = new Line(9,4, 3, 4);
        Line line2 = new Line(7, 0, 7, 4);
        naviator.addLine(line1);
        naviator.addLine(line2);

        assertEquals(1, naviator.getNumberOfOverlapa());
    }

    @Test
    public void testVentMap() {
        Navigator navigator = new Navigator();
        navigator.addLine(new Line(0,9,5,9));
        navigator.addLine(new Line(8,0,0,8));
        navigator.addLine(new Line(9,4,3,4));
        navigator.addLine(new Line(2,2,2,1));
        navigator.addLine(new Line(7,0,7,4));
        navigator.addLine(new Line(6,4,2,0));
        navigator.addLine(new Line(0,9,2,9));
        navigator.addLine(new Line(3,4,1,4));
        navigator.addLine(new Line(0,0,8,2));

        assertEquals(5, navigator.getNumberOfOverlapa());
    }

    @Test
    public void testMultipleOverlap() {
        Navigator navigator = new Navigator();
        navigator.addLine(new Line(0,9,5,9));
        navigator.addLine(new Line(8,0,0,8));
        navigator.addLine(new Line(9,4,3,4));
        navigator.addLine(new Line(2,2,2,1));
        navigator.addLine(new Line(7,0,7,4));
        navigator.addLine(new Line(6,4,2,0));
        navigator.addLine(new Line(0,9,2,9));
        navigator.addLine(new Line(3,4,1,4));
        navigator.addLine(new Line(0,0,8,2));
        navigator.addLine(new Line(0,8,0,9));

        assertEquals(5, navigator.getNumberOfOverlapa());
    }
}
