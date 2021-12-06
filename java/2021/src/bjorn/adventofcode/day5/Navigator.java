package bjorn.adventofcode.day5;

import java.util.ArrayList;
import java.util.List;

public class Navigator {
    private List<Line> vents = new ArrayList<>();
    private int overlaps = 0;

    public void addLine(Line line) {
        for(Line otherLine : vents) {
            if(!otherLine.isVertical()){
                if(line.horizontalMatch(otherLine) || line.verticalMatch(otherLine)) {
                    overlaps += line.calculateOverlap(otherLine);
                }
            }
        }

        vents.add(line);
    }


    public int getNumberOfOverlapa() {
        return overlaps;
    }
}
