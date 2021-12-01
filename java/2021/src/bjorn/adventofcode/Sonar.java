package bjorn.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Sonar {
    public boolean hasIncreased(int oldDepth, int newDepth) {
        return oldDepth < newDepth;
    }

    public int countIncreases(List<Integer> depths) {
        int increases = 0;
        int previousDepth = depths.get(0);

        for (int i = 1; i < depths.size(); i++) {
            if (hasIncreased(previousDepth, depths.get(i))) {
                increases++;
            }
            previousDepth = depths.get(i);
        }
        return increases;
    }

    public int sum(int first, int second, int third) {
        return first + second + third;
    }

    public List<Integer> toSlidingList(List<Integer> depths) {
        ArrayList slidingList = new ArrayList<>();

        for (int i = 2; i < depths.size(); i++) {
            int sliding = sum(depths.get(i-2), depths.get(i-1), depths.get(i));
            slidingList.add(sliding);
        }
        return slidingList;
    }
}
