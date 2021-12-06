package bjorn.adventofcode.day6;

import java.util.*;

public class FishSimulator {
    private Collection<FishGeneration> fishPopulation = new ArrayList<>();

    public FishSimulator(List<Integer> initialFishes) {
        for(int fish : initialFishes) {
            fishPopulation.add(new FishGeneration(fish, 1));
        }
        mergeGenerations();
    }

    private void mergeGenerations() {
        HashMap<Integer, FishGeneration> populationByAge = new HashMap<>();
        for(FishGeneration population : fishPopulation) {
            if(populationByAge.get(population.getDaysToSpawn()) == null) {
                populationByAge.put(population.getDaysToSpawn(), population);
            } else {
                populationByAge.get(population.getDaysToSpawn()).addFishes(population.getAmount());
            }
        }
        fishPopulation = new ArrayList<>(populationByAge.values());
    }

    public void step(int steps) {
        for(int i = 0; i < steps; i++) {
            ArrayList<FishGeneration> spawns = new ArrayList<>();
            for (FishGeneration generation : fishPopulation) {
                FishGeneration spawn = generation.step();
                if (spawn != null) {
                    spawns.add(spawn);
                }
            }
            fishPopulation.addAll(spawns);
            mergeGenerations();
        }
    }

    public double getNumberOfFishes() {
        double total = 0;
        for(FishGeneration population : fishPopulation) {
            total += population.getAmount();
        }
        return total;
    }
}
