import bjorn.adventofcode.Submarine;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {
    @Test
    public void testMoveForward() {
        Submarine sub = new Submarine();
        sub.move("forward 5");
        assertEquals(5, sub.getDistance());
    }

    @Test
    public void testDown() {
        Submarine sub = new Submarine();
        sub.move("down 5");
        assertEquals(5, sub.getDepth());
    }

    @Test
    public void testUp() {
        Submarine sub = new Submarine();
        sub.move("up 2");
        assertEquals(-2, sub.getDepth());
    }

    @Test
    public void testStream() {
        Stream<String> directions = Stream.of("forward 5,down 5,forward 8,up 3,down 8,forward 2".split(","));
        Submarine sub = new Submarine();
        sub.move(directions);
        assertEquals(15, sub.getDistance());
        assertEquals(10, sub.getDepth());
    }

    @Test
    public void testAimForward() {
        Submarine sub = new Submarine();
        sub.aim("forward 5");
        assertEquals(5, sub.getDistance());
        assertEquals(0, sub.getDepth());
    }

    @Test
    public void testAimDown() {
        Submarine sub = new Submarine();
        sub.aim("down 5");
        sub.aim("forward 5");
        assertEquals(5, sub.getDistance());
        assertEquals(25, sub.getDepth());
    }

    @Test
    public void testAimStream() {
        Stream<String> directions = Stream.of("forward 5,down 5,forward 8,up 3,down 8,forward 2".split(","));
        Submarine sub = new Submarine();
        sub.aim(directions);
        assertEquals(15, sub.getDistance());
        assertEquals(60, sub.getDepth());
    }
}