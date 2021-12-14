package bjorn.adventofcode.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HeatMap {
    // TODO 2d array?
    private int[] theMap = null;

    public HeatMap() {
    }

    public void addRow(String data) {
        if(theMap == null) {
            theMap = new int[data.length()];
        }

        String[] readings = data.split("");
        for(int i = 0; i < readings.length; i++) {
            theMap[i] = Integer.parseInt(readings[i]);
        }
    }

    public int calculateRisk() {
        int risk = 0;
        List<Integer> lowPoints = getLowpoints();
        for(int lowpoint :lowPoints) {
            risk += lowpoint + 1;
        }
        return risk;
    }

    private List<Integer> getLowpoints() {
        ArrayList<Integer> foundLowpoint = new ArrayList<>();
        for(int i = 0; i < theMap.length; i++) {
            int current = theMap[i];
            if(i == 0 || current < theMap[i-1]) {
                if(i == theMap.length-1 || current < theMap[i+1]) {
                    foundLowpoint.add(current);
                }
            }
        }
        return foundLowpoint;
    }
}
