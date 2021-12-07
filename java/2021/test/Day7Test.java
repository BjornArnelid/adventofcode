import bjorn.adventofcode.day7.CrabSubmarine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Test {
    @Test
    public void testCountFuel() {
        assertEquals(14, CrabSubmarine.countFuel(16, 2));
    }

    @Test
    public void testCalculateFuel() {
        assertEquals(37, CrabSubmarine.countFuel(List.of(16,1,2,0,4,2,7,1,2,14), 2, false));
    }

    @Test
    public void testGetBestFuelOption() {
        assertEquals(37, CrabSubmarine.calculateOptimalFuel(List.of(16,1,2,0,4,2,7,1,2,14), false));
    }

    @Test
    public void testNewFuel() {
        assertEquals(66, CrabSubmarine.countFuelNew(16, 5));
    }

    @Test
    public void testNewFuelArray() {
        assertEquals(168, CrabSubmarine.countFuel(List.of(16,1,2,0,4,2,7,1,2,14), 5, true));
    }

    @Test
    public void testCalculateNewFuel() {
        assertEquals(168, CrabSubmarine.calculateOptimalFuel(List.of(16,1,2,0,4,2,7,1,2,14), true));
    }
}
