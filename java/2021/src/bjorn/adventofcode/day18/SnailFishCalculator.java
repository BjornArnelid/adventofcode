package bjorn.adventofcode.day18;

public class SnailFishCalculator {
    SnailNumber number = null;

    public static SnailNumber add(SnailNumber leftHand, SnailNumber rightHand) {
        SnailNumber result = new SnailNumber(null, leftHand, rightHand);

        boolean doRun = true;
        while(doRun) {
            while (doRun) {
                doRun = result.explode();
            }
            if (result.split()) {
                doRun = true;
            }
        }
        return result;
    }

    public void add(String newNumber) {
        if(number != null) {
            number = add(number, new SnailNumber(null, newNumber));
        } else {
            number = new SnailNumber(null, newNumber);
        }
    }

    public SnailNumber getResult() {
        return number;
    }
}
