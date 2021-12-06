package bjorn.adventofcode.day5;

import java.util.ArrayList;
import java.util.List;

public class Navigator {
    private final List<Line> vents = new ArrayList<>();
    private final ArrayList<Position> overlapList = new ArrayList<>();

    public void addLine(Line line) {
        for(Line otherLine : vents) {
            if(!otherLine.isVertical()){
                if(line.horizontalMatch(otherLine) || line.verticalMatch(otherLine)) {
                    for(Position overlap : line.calculateOverlap(otherLine)) {
                        addOverlaps(overlap);
                    }

                }
            }
        }

        vents.add(line);
    }

    private void addOverlaps(Position overlap) {
        for(Position old : overlapList) {
            if(overlap.equals(old)) {
                return;
            }
        }
        overlapList.add(overlap);
    }


    public int getNumberOfOverlapa() {
        return overlapList.size();
    }
}
