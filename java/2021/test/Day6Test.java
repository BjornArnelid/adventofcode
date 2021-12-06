import bjorn.adventofcode.day6.FishSimulator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Test {
    @Test
    public void testFishMultiply() {
        List<Integer> initialFishes = new ArrayList<>();
        initialFishes.add(0);
        FishSimulator simulator = new FishSimulator(initialFishes);
        simulator.step(1);
        assertEquals(2, simulator.getNumberOfFishes());
    }

    @Test
    public void testFish80Steps() {
        List<Integer> initialFishes = new ArrayList<>();
        initialFishes.addAll(IntStream.of(3,4,3,1,2).boxed().collect(Collectors.toList()));
        FishSimulator simulator = new FishSimulator(initialFishes);
        simulator.step(80);
        assertEquals(5934, simulator.getNumberOfFishes());
    }
}
