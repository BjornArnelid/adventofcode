package bjorn.adventofcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import bjorn.adventofcode.day2.Game;
import bjorn.adventofcode.day2.Sign;

class Day2Test {

	@Test
	void testParseString() {
		Sign[] signs = Sign.parse("A Y");
		assertEquals(Sign.Rock, signs[0]);
		assertEquals(Sign.Paper, signs[1]);
	}

	@Test 
	void testcountSignScore() {
		assertEquals(2, Sign.Paper.count());
	}
	
	@Test
	void testCountWin() {
		Sign[] signs = Sign.parse("A Y");
		assertEquals(8, Game.play(signs[0], signs[1]));
	}
	
	@Test
	void testCountLoss() {
		Sign[] signs = Sign.parse("B X");
		assertEquals(1, Game.play(signs[0], signs[1]));
	}
	
	@Test
	void testCountDraw() {
		Sign[] signs = Sign.parse("C Z");
		assertEquals(6, Game.play(signs[0], signs[1]));
	}
	
	@Test
	void testWinRock() {
		Sign[] signs = Sign.parse("C X");
		assertEquals(7, Game.play(signs[0], signs[1]));
	}
	
	@Test
	void testLossCissor() {
		Sign[] signs = Sign.parse("A Z");
		assertEquals(3, Game.play(signs[0], signs[1]));
	}
	
	@Test
	void testFullGame() {
		Game game = new Game();
		Stream.of("A Y", "B X", "C Z").forEach(game::playRound);
		assertEquals(15, game.getScore());
	}
	
	@Test
	void testTranslateDraw() {
		Sign[] signs = Sign.translate("A Y");
		assertEquals(Sign.Rock, signs[0]);
		assertEquals(Sign.Rock, signs[1]);
	}
	
	@Test
	void testTranslateLoss() {
		Sign[] signs = Sign.translate("B X");
		assertEquals(Sign.Rock, signs[1]);
	}
	
	@Test
	void testTRanslateWin() {
		Sign[] signs = Sign.translate("C Z");
		assertEquals(Sign.Rock, signs[1]);
	}
	
	@Test
	void testTranslatedGame() {
		Game game = new Game();
		Stream.of("A Y", "B X", "C Z").forEach(game::playTranslatedRound);
		assertEquals(12, game.getScore());
	}
}
