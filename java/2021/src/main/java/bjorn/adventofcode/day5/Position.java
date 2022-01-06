package bjorn.adventofcode.day5;

public class Position {
    private final int x;
    private final int y;

    public Position(int xPos, int yPos) {
        x = xPos;
        y = yPos;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Position) {
            Position other = (Position) obj;
            return x == other.getX() && y == other.getY();
        }
        return false;
    }
}
