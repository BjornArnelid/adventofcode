package bjorn.adventofcode.day15;

public class Tile {
    int risk;
    int cost;
    boolean isCalculated = false;
    boolean isLocked = false;

    public Tile(String value) {
        risk = Integer.parseInt(value);
    }
}
