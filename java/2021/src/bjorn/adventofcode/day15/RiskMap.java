package bjorn.adventofcode.day15;

public class RiskMap {
    private final Tile[][] map;
    private final int maxX;
    private final int maxY;
    private int cutOff;

    public RiskMap(String[] mapInput) {
        cutOff = Integer.MAX_VALUE;
        maxX = mapInput[0].length() - 1;
        maxY = mapInput.length - 1;
        map = new Tile[maxY+1][maxX+1];
        for(int y = 0; y < maxY+1; y++) {
            String[] mapRow = mapInput[y].split("");
            for(int x = 0; x < maxX+1; x++) {
                map[y][x] = new Tile(mapRow[x]);
            }
        }
    }

    public Integer calculateRisk() {
        if (0 == maxX && 0 == maxY) {
            return 0;
        }
        map[0][0].isLocked = true;
        int rightRisk = calculateRisk(1, 0, 0);
        int downRisk = calculateRisk(0, 1, 0);
        return Math.min(rightRisk, downRisk);
    }

    private int calculateRisk(int x, int y, int buildupRisk) {
        Tile tile = map[y][x];
        tile.isLocked = true;
        int risk = tile.risk;
        if (buildupRisk + risk > cutOff) {
            tile.isLocked = false;
            return Integer.MAX_VALUE;
        }
        if (tile.isCalculated) {
            tile.isLocked = false;
            return buildupRisk + tile.cost;
        }
        if (x == maxX && y == maxY) {
            cutOff = buildupRisk + risk;
            tile.isLocked = false;
            return buildupRisk + risk;
        }
        int downRisk = Integer.MAX_VALUE;
        int upRisk = Integer.MAX_VALUE;
        int rightRisk = Integer.MAX_VALUE;
        int leftRisk = Integer.MAX_VALUE;
        // Right
        if (x < maxX && !map[y][x+1].isLocked) {
            rightRisk = calculateRisk(x + 1, y, buildupRisk + risk);
            if(rightRisk < 0) {
                rightRisk = Integer.MAX_VALUE;
            }
        }
        // Left
        if (x > 0 && !map[y][x-1].isLocked) {
            leftRisk = calculateRisk(x - 1, y, buildupRisk + risk);
            if(leftRisk < 0) {
                leftRisk = Integer.MAX_VALUE;
            }
        }
        // Down
        if(y < maxY && !map[y+1][x].isLocked) {
            downRisk = calculateRisk(x, y + 1, buildupRisk + risk);
            if (downRisk < 0) {
                downRisk = Integer.MAX_VALUE;
            }
        }
        // up
        if(y > 0 && !map[y-1][x].isLocked) {
            upRisk = calculateRisk(x, y - 1, buildupRisk + risk);
            if (upRisk < 0) {
                upRisk = Integer.MAX_VALUE;
            }
        }

        int lowestPath = Math.min(Math.min(rightRisk, leftRisk), Math.min(downRisk, upRisk));
        tile.isCalculated = true;
        tile.cost = lowestPath - buildupRisk;
        tile.isLocked = false;
        return lowestPath;
    }
}
