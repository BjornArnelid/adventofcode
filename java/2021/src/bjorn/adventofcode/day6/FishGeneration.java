package bjorn.adventofcode.day6;

public class FishGeneration {
    private int daysToSpawn;
    private double amount;

    public FishGeneration(int age, double numberOfFishes) {
        daysToSpawn = age;
        amount = numberOfFishes;
    }

    public int getDaysToSpawn() {
        return daysToSpawn;
    }

    public FishGeneration step() {
        if(daysToSpawn==0) {
            daysToSpawn = 6;
            return new FishGeneration(8, amount);
        }
        daysToSpawn--;
        return null;
    }

    public double getAmount() {
        return amount;
    }

    public void addFishes(double fishesToAdd) {
        amount += fishesToAdd;
    }
}
