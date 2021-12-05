package bjorn.adventofcode.day4;

import java.util.ArrayList;
import java.util.List;

public class Bingo {
    private ArrayList<Board> boards = new ArrayList<>();
    private Board lastWinner = null;

    public Bingo(List<String> boardInputs) {
        for(String boardInput : boardInputs) {
            boards.add(new Board(boardInput));
        }
    }

    public int getLastScore() {
        return lastWinner.count();
    }

    public int getScore() {
        ArrayList<Board> newBoards = new ArrayList<>();
        for(Board b : boards) {
            if(!b.hasBingo()) {
                newBoards.add(b);
            } else {
                lastWinner = b;
            }
        }
        boards = newBoards;
        return lastWinner == null ? 0 : lastWinner.count();
    }

    public void playNumber(String number) {
        for(Board b : boards) {
            b.setNumber(number);
        }
    }

    public int boardsInPlay() {
        return boards.size();
    }
}
