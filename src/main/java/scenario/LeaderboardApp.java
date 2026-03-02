package scenario;

import java.util.*;

public class LeaderboardApp {

    public static void main(String[] args) {

        Leaderboard board = new Leaderboard();

        board.addScore(1, 50);
        board.addScore(2, 80);
        board.addScore(3, 40);

        System.out.println("Top2 score sum: " + board.top(2));

        board.reset(2);

        board.addScore(2, 30);

        System.out.println("Top2 score sum after reset: " + board.top(2));
    }
}

class Leaderboard {

    private Map<Integer, Integer> playerScore = new HashMap<>();
    //key : score, value: number of players with that score
    private TreeMap<Integer, Integer> scoreCount = new TreeMap<>();

    public void addScore(int playerId, int score) {

        int oldScore = playerScore.getOrDefault(playerId, 0);
        int newScore = oldScore + score;

        playerScore.put(playerId, newScore);

        if (oldScore > 0) {
            scoreCount.put(oldScore, scoreCount.get(oldScore) - 1);

            if (scoreCount.get(oldScore) == 0)
                scoreCount.remove(oldScore);
        }

        scoreCount.put(newScore,
                scoreCount.getOrDefault(newScore, 0) + 1);
    }

    public int top(int k) {

        int sum = 0;

        for (var entry : scoreCount.descendingMap().entrySet()) {

            int score = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count && k > 0; i++) {
                sum += score;
                k--;
            }

            if (k == 0)
                break;
        }

        return sum;
    }

    public void reset(int playerId) {
        int score = playerScore.remove(playerId);

        if (scoreCount.get(score) - 1 == 0) {
            scoreCount.remove(score);
        } else {
            scoreCount.put(score, scoreCount.get(score) - 1);
        }
    }
}