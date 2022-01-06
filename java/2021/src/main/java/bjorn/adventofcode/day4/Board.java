package bjorn.adventofcode.day4;

public class Board {
    private final String[] tiles;
    private int winningScore = 0;

    public Board(String boardInput) {
        tiles = new String[25];

        String[] boardRows = boardInput.split("\n");
        for(int row = 0; row < 5; row++) {
            for(int column = 0; column < 5; column++) {
                int index = column*3;
                tiles[row*5+column] = boardRows[row].substring(index, index+2).strip();
            }
        }

    }

    public boolean hasBingo() {
        // Test row Bingo
        if (doCheckBingoRow() || doCheckBingoColumn()) {
            count();
            return true;
        }
        return false;
    }

    private boolean doCheckBingoRow() {
        for(int row = 0; row < 5; row++) {
            int checks = 0;
            for(int tile = row*5; tile < row*5+5; tile++) {
                if (tiles[tile].equals("X")) {
                    checks++;
                } else {
                    break;
                }
            }
            if(checks==5) {
                return true;
            }
        }
        return false;
    }

    private boolean doCheckBingoColumn() {
        for(int column = 0; column < 5; column++) {
            int checks = 0;
            for(int tile = column; tile <= 20 + column; tile += 5) {
                if (tiles[tile].equals("X")) {
                    checks++;
                } else {
                    break;
                }
            }
            if(checks==5) {
                return true;
            }
        }
        return false;
    }

    public int count() {
        if(winningScore == 0) {
            for (String val : tiles) {
                if (!val.equals("X")) {
                    winningScore += Integer.valueOf(val);
                }
            }
        }
        return winningScore;
    }

    public void setNumber(String number) {
        if(winningScore != 0) {
            return;
        }
        for(int i = 0; i < tiles.length; i++) {
            if(tiles[i].strip().equals(number)) {
                tiles[i] = "X";
            }
        }
    }
}
