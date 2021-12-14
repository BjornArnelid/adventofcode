package bjorn.adventofcode.day13;

import java.util.ArrayList;
import java.util.List;


public class Manual {
    List<Dot> dots = new ArrayList<>();
    private int lineBreak = 0;

    public void addDot(Dot dot) {
        if (dot.x > lineBreak) {
            lineBreak = dot.x;
        }
        dots.add(dot);
    }

    public List<Dot> getDots() {
        return dots;
    }

    public String paintDots() {
        List<String> lines = new ArrayList<>();
        for (Dot dot : dots) {
            while(dot.y >= lines.size()) {
                lines.add(".".repeat(lineBreak+1));
            }
            String line = lines.get(dot.y);
            if(dot.x > 0) {
                lines.set(dot.y, line.substring(0, dot.x) + "#" + line.substring(dot.x+1));
            } else {
                lines.set(dot.y, "#" + line.substring(dot.x+1));
            }
        }
        return String.join("\n", lines);
    }

    public void foldY(int foldPosition) {
        for (Dot dot : dots) {
            if (dot.y >= foldPosition) {
                int foldedY = dot.y - foldPosition;
                dot.y = foldPosition - foldedY;
            }
        }
    }

    public void foldX(int foldPosition) {
        for (Dot dot : dots) {
            if (dot.x >= foldPosition) {
                int foldedX = dot.x - foldPosition;
                dot.x = foldPosition - foldedX;
            }
        }
        lineBreak = foldPosition-1;
    }
}
