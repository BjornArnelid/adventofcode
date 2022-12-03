package bjorn.adventofcode.day2;

public class Game {
	private int score = 0;

	public void playRound(String input) {
		Sign[] signs = Sign.parse(input);
		score += play(signs[0], signs[1]);
	}

	public void playTranslatedRound(String input) {
		Sign[] signs = Sign.translate(input);
		score += play(signs[0], signs[1]);
	}
	
	public int getScore() {
		return score;
	}
	
	public static int play(Sign opponent, Sign you) {
		int score = you.count();
		score += countWin(opponent, you);
		return score;
	}

	private static int countWin(Sign opponent, Sign you) {
		if (you == Sign.Rock && opponent == Sign.Cissor) {
			return 6;
		} else if (you == Sign.Cissor && opponent == Sign.Rock) {
			return 0;
		} else if(you.count() > opponent.count()) {
			return 6;
		} else if (you.count() == opponent.count()) {
			return 3;
		}
		return 0;
	}
}
