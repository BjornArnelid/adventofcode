package bjorn.adventofcode.day5;

import java.util.ArrayList;
import java.util.Collections;
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
        }
        return Collections.emptyList();
    }

    private List<Position> calculateHorizontalOverlap(Line otherLine) {
        List<Position> overlaps = new ArrayList<>();
        if(otherLine.inVerticalBounds(from.getY())) {
            int lowX = Math.min(from.getX(), to.getX());
            int highX = lowX == from.getX() ? to.getX() : from.getX();
            for(int x = lowX ; x <= highX ; x++ ) {
                if(otherLine.inHorizontalBounds(x)) {
                    overlaps.add(new Position(x, from.getY()));
                }
            }
        }
        return overlaps;
    }

    private List<Position> calculateVerticalOverlap(Line otherLine) {
        List<Position> overlaps = new ArrayList<>();
        if(otherLine.inHorizontalBounds(from.getX())) {
            int lowY = Math.min(from.getY(), to.getY());
            int highY = lowY == from.getY() ? to.getY() : from.getY();
            for(int y = lowY ; y <= highY ; y++ ) {
                if(otherLine.inVerticalBounds(y)) {
                    overlaps.add(new Position(from.getX(), y));
                }
            }
        }
        return overlaps;
    }

    public boolean isVertical() {
        return !(isVertical || isHorizontal);
    }
}
