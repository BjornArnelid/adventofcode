package bjorn.adventofcode.day7;

import java.util.List;

public class CrabSubmarine {
    public static int countFuel(int oldPosition, int newPosition)
    {
        return Math.abs(oldPosition - newPosition);
    }

    public static int countFuel(List<Integer> positions, int newPosition, boolean countNew) {
        int fuel = 0;
        for(Integer position : positions) {
            if(countNew) {
                fuel += countFuelNew(position, newPosition);
            } else {
                fuel += countFuel(position, newPosition);
            }
        }
        return fuel;
    }

    public static int calculateOptimalFuel(List<Integer> positions, boolean countNew) {
        int listLength = positions.size();
        if(listLength==0) {
            return 0;
        }

        List<Integer> sortedPositions = positions.stream().sorted().toList();
        int highIndex = sortedPositions.size() - 1;
        int totalFuel = Integer.MAX_VALUE;

        // Im sorry, but it works...
        for(int i = 0; i <= sortedPositions.get(highIndex); i++) {
            int newVal = countFuel(sortedPositions, i, countNew);
            if(newVal < totalFuel) {
                totalFuel = newVal;
            }
        }

        return totalFuel;
    }

    public static int countFuelNew(int oldPosition, int newPosition) {
        int newFuel = 0;
        int oldFuel = countFuel(oldPosition, newPosition);
        for(int i = 1; i <= oldFuel; i++) {
            newFuel += i;
        }
        return newFuel;
    }
}
