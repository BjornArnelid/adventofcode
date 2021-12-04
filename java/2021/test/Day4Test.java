import bjorn.adventofcode.Bingo;
import bjorn.adventofcode.Board;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Day4Test {
    @Test
    public void testBoardNoBingo() {
        String boardInput = """
                22 13 17 11  0
                 8  2 23  4 24
                21  9 14 16  7
                 6 10  3 18  5
                 1 12 20 15 19""";

        Board board = new Board(boardInput);
        assertFalse(board.hasBingo());
    }

    @Test
    public void testCountBoard() {
        String boardInput = """
                 X  X  X  X  X
                10 16 15  X 19
                18  8  X 26 20
                22  X 13  6  X
                 X  X 12  3  X""";
        Board board = new Board(boardInput);
        assertEquals(188, board.count());
    }

    @Test
    public void testBoardHasBingo() {
        String boardInput = """
                14 21 17 24  4
                10 16 15  9 19
                18  8 23 26 20
                22 11 13  6  5
                 2  0 12  3  7""";
        Board board = new Board(boardInput);
        Stream.of("7","4","9","5","11","17","23","2","0","14","21","24").forEach(number -> board.setNumber(number));
        assertTrue(board.hasBingo());
        assertEquals(188, board.count());
    }

    @Test
    public void testVerticalBingo() {
        String boardInput = """
                14 10 18 22  2
                21 16 15  9 19
                17  8 23 26 20
                24 11 13  6  5
                 4  0 12  3  7""";
        Board board = new Board(boardInput);
        Stream.of("7","4","9","5","11","17","23","2","0","14","21","24").forEach(number -> board.setNumber(number));
        assertTrue(board.hasBingo());
        assertEquals(188, board.count());
    }

    @Test
    public void testFindBestBoard() {
        List<String> bingoBoards = List.of (
                """
                        22 13 17 11  0
                         8  2 23  4 24
                        21  9 14 16  7
                         6 10  3 18  5
                         1 12 20 15 19
                        """,

                """
                         3 15  0  2 22
                         9 18 13 17  5
                        19  8  7 25 23
                        20 11 10 24  4
                        14 21 16 12  6
                        """,

                """
                        14 21 17 24  4
                        10 16 15  9 19
                        18  8 23 26 20
                        22 11 13  6  5
                         2  0 12  3  7"""
        );
        Bingo bingo = new Bingo(bingoBoards);

        Stream.of("7,4,9,5,11,17,23,2,0,14,21,24".split(",")) .forEach(s -> bingo.playNumber(s));
        assertEquals(188, bingo.getScore());
    }

    @Test
    public void testBoardsInPlay() {
        List<String> bingoBoards = List.of (
                """
                        22 13 17 11  0
                         8  2 23  4 24
                        21  9 14 16  7
                         6 10  3 18  5
                         1 12 20 15 19
                        """,

                """
                         3 15  0  2 22
                         9 18 13 17  5
                        19  8  7 25 23
                        20 11 10 24  4
                        14 21 16 12  6
                        """,

                """
                        14 21 17 24  4
                        10 16 15  9 19
                        18  8 23 26 20
                        22 11 13  6  5
                         2  0 12  3  7"""
        );
        Bingo bingo = new Bingo(bingoBoards);
        Stream.of("7,4,9,5,11,17,23,2,0,14,21,24".split(",")) .forEach(s -> {
            bingo.playNumber(s);
            bingo.getScore();
        });
        assertEquals(2, bingo.boardsInPlay());
    }
}
