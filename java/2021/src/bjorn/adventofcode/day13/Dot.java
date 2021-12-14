package bjorn.adventofcode.day13;

public class Dot {
    public int y;
    public int x;

    public Dot(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Dot(String inString) {
        String[] parts = inString.split(",");
        x = Integer.parseInt(parts[0]);
        y = Integer.parseInt(parts[1]);
    }
}
