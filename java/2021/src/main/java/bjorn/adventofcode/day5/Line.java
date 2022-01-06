package bjorn.adventofcode.day5;

import java.util.ArrayList;
import java.util.List;

public class Line {

    Position from;
    Position to;

    private final boolean isHorizontal;
    private final boolean isVertical;

    // Y = Vertical
    // X = Horizontal
    public Line(Position fromPosition , Position toPosition) {
        from = fromPosition;
        to = toPosition;
        isHorizontal = from.getY() == to.getY();
        isVertical = from.getX() == to.getX();
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Position(x1, y1), new Position(x2, y2));
    }

    public boolean horizontalMatch(Line otherLine) {
        return inHorizontalBounds(otherLine.from.getX()) || inHorizontalBounds(otherLine.to.getX());
    }

    private boolean inHorizontalBounds(int position) {
        return (from.getX() <= position && to.getX() >= position) || (from.getX() >= position && to.getX() <= position);
    }

    public boolean verticalMatch(Line otherLine) {
        return inVerticalBounds(otherLine.from.getY()) || inHorizontalBounds(to.getY());
    }

    private boolean inVerticalBounds(int position) {
        return (from.getY() <= position && to.getY() >= position) || (from.getY() >= position && to.getY() <= position);
    }

    public List<Position> calculateOverlap(Line otherLine) {
        if(isHorizontal) {
            return calculateHorizontalOverlap(otherLine);
        } else if (isVertical) {
            return calculateVerticalOverlap(otherLine);
        } else { // Diagonal line
            return calculateDiagonalOverlap(otherLine);
        }
    }

    private List<Position> calculateDiagonalOverlap(Line otherLine) {
        List<Position> overlaps = new ArrayList<>();
        int xStep = to.getX() > from.getX() ? 1 : -1;
        int yStep = to.getY() > from.getY() ? 1 : -1;
        int x = from.getX();
        int y = from.getY();
        while(inHorizontalBounds(x)) {
            if(otherLine.matches(new Position(x, y))) {
                overlaps.add(new Position(x, y));
            }
            x += xStep;
            y +=yStep;
        }
        return overlaps;
    }

    private List<Position> calculateHorizontalOverlap(Line otherLine) {
        List<Position> overlaps = new ArrayList<>();
        int lowX = getMinX();
        int highX = getMaxX();
        for(int x = lowX ; x <= highX ; x++ ) {
            if(otherLine.matches(new Position(x, getMinY()))) {
                overlaps.add(new Position(x, from.getY()));
            }
        }
        return overlaps;
    }

    private List<Position> calculateVerticalOverlap(Line otherLine) {
        List<Position> overlaps = new ArrayList<>();
        int lowY = getMinY();
        int highY = getMaxY();
        for(int y = lowY ; y <= highY ; y++ ) {
            if(otherLine.matches(new Position(from.getX(), y))) {
                overlaps.add(new Position(from.getX(), y));
            }
        }
        return overlaps;
    }

    private boolean matches(Position position) {
        if(isDiagonal()) {
            if (inHorizontalBounds(position.getX()) && inVerticalBounds(position.getY())) {
                int xStep = to.getX() > from.getX() ? 1 : -1;
                int yStep = to.getY() > from.getY() ? 1 : -1;

                int xDiff = getMaxX() - getMinX();
                for (int i = 0; i <= xDiff; i++) {
                    if(position.getX() == from.getX() + i*xStep && position.getY() == from.getY() + i*yStep) {
                        return true;
                    }
                }
            }
            return false;
        }
        return inHorizontalBounds(position.getX()) && inVerticalBounds(position.getY());
    }

    public boolean isDiagonal() {
        return !(isVertical || isHorizontal);
    }

    public boolean isInBounds(Line otherLine) {
        return getMaxX() >= otherLine.getMinX() && getMinX() <= otherLine.getMaxX()
                && getMaxY() >= otherLine.getMinY() && getMinY() <= otherLine.getMaxY();
    }

    private int getMinY() {
        return Math.min(from.getY(), to.getY());
    }

    private int getMaxY() {
        return Math.max(from.getY(), to.getY());
    }

    private int getMinX() {
        return Math.min(from.getX(), to.getX());
    }

    private int getMaxX() {
        return Math.max(from.getX(), to.getX());
    }
}
