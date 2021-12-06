package bjorn.adventofcode.day5;

public class Line {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final boolean isHorizontal;
    private final boolean isVertical;

    // Y = Vertical
    // X = Horizontal
    public Line(int inputX1, int inputY1, int inputX2, int inputY2) {
        x1 = inputX1;
        y1 = inputY1;
        x2 = inputX2;
        y2 = inputY2;
        isHorizontal = y1 == y2;
        isVertical = x1 == x2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    private int getY2() {
        return y2;
    }

    private int getY1() {
        return y1;
    }

    public boolean horizontalMatch(Line otherLine) {
        return inHorizontalBounds(otherLine.getX1()) || inHorizontalBounds(otherLine.getX2());
    }

    private boolean inHorizontalBounds(int position) {
        return (x1 <= position && x2 >= position) || (x1 >= position && x2 <= position);
    }

    public boolean verticalMatch(Line otherLine) {
        return inVerticalBounds(otherLine.getY1()) || inHorizontalBounds(getY2());
    }

    private boolean inVerticalBounds(int position) {
        return (y1 <= position && y2 >= position) || (y1 >= position && y2 <= position);
    }

    public int calculateOverlap(Line otherLine) {
        if(isHorizontal) {
            return calculateHorizontalOverlap(otherLine);
        } else if (isVertical) {
            return calculateVerticalOverlap(otherLine);
        }
        return 0;
    }

    private int calculateHorizontalOverlap(Line otherLine) {
        int overlap = 0;
        if(otherLine.inVerticalBounds(y1)) {
            int lowX = Math.min(x1, x2);
            int highX = lowX == x1 ? x2 : x1;
            for(int x = lowX ; x <= highX ; x++ ) {
                if(otherLine.inHorizontalBounds(x)) {
                    overlap++;
                }
            }
        }
        return overlap;
    }

    private int calculateVerticalOverlap(Line otherLine) {
        int overlap = 0;
        if(otherLine.inHorizontalBounds(x1)) {
            int lowY = Math.min(y1, y2);
            int highY = lowY == y1 ? y2 : y1;
            for(int y = lowY ; y <= highY ; y++ ) {
                if(otherLine.inVerticalBounds(y)) {
                    overlap++;
                }
            }
        }
        return overlap;
    }

    public boolean isVertical() {
        return !(isVertical || isHorizontal);
    }
}
