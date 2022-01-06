package bjorn.adventofcode.day2;

import java.util.stream.Stream;

public class Submarine {
    private int distance = 0;
    private int depth = 0;
    private int aim = 0;

    public void move(String move) {
        String[] parts = move.split(" ");
        String direction = parts[0];
        int amount = Integer.parseInt(parts[1]);
        if(direction.equals("forward")) {
            this.distance += amount;
        } else if(direction.equals("down")) {
            depth += amount;
        } else if(direction.equals("up")) {
            depth -= amount;
        }
    }

    public int getDistance() {
        return distance;
    }

    public int getDepth() {
        return depth;
    }

    public void move(Stream<String> directions) {
        directions.forEach(this::move);
    }

    public void aim(String move) {
        String[] parts = move.split(" ");
        String direction = parts[0];
        int amount = Integer.parseInt(parts[1]);
        if(direction.equals("forward")) {
            distance += amount;
            depth += amount * aim;
        } else if(direction.equals("down")) {
            aim += amount;
        } else if(direction.equals("up")) {
            aim -= amount;
        }
    }

    public void aim(Stream<String> directions) {
        directions.forEach(this::aim);
    }
}
