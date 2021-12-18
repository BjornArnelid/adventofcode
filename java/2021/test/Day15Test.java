import bjorn.adventofcode.day15.RiskMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day15Test {
    String[] theMap = """
            1163751742
            1381373672
            2136511328
            3694931569
            7463417111
            1319128137
            1359912421
            3125421639
            1293138521
            2311944581""".split("\n");

    @Test
    public void testcountRisk() {
        RiskMap map = new RiskMap(new String[]{"1"});
        assertEquals(0, map.calculateRisk());
    }

    @Test
    public void testFindPath() {
        RiskMap map = new RiskMap(new String[]{"12", "11"});
        assertEquals(2, map.calculateRisk());
    }

    @Test
    @Disabled
    public void testFullMap() {
        RiskMap map = new RiskMap(theMap);
        assertEquals(40, map.calculateRisk());
    }

    @Test
    @Disabled
    public void testEvilMap() {
        RiskMap map = new RiskMap(new String[] {
                "19999",
                "19111",
                "11191"});
        assertEquals(8, map.calculateRisk());

    }
}
