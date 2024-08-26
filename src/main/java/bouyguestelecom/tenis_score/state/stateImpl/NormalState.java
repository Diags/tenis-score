package bouyguestelecom.tenis_score.state.stateImpl;

import bouyguestelecom.tenis_score.config.Constants;
import bouyguestelecom.tenis_score.config.TennisGame;
import bouyguestelecom.tenis_score.state.GameState;

/**
 * État du jeu lorsque le score est normal, sans avantage ni égalité.
 */
public class NormalState implements GameState {

    @Override
    public void playerAWinsPoint(TennisGame game) {
        int currentScoreA = game.getScorePlayerA();
        int currentScoreB = game.getScorePlayerB();

        if (currentScoreA < Constants.POINT_30) {
            game.setScorePlayerA(currentScoreA + Constants.POINT_15);
        } else if (currentScoreA == Constants.POINT_30) {
            game.setScorePlayerA(Constants.POINT_40);
        } else if (currentScoreA == Constants.POINT_40 && currentScoreB < Constants.POINT_40) {
            game.setState(new EndGameState(Constants.PLAYER_A_NAME));
        } else if (currentScoreA == Constants.POINT_40 && currentScoreB == Constants.POINT_40) {
            game.setState(new DeuceState());
        }
    }

    @Override
    public void playerBWinsPoint(TennisGame game) {
        int currentScoreB = game.getScorePlayerB();
        int currentScoreA = game.getScorePlayerA();

        if (currentScoreB < Constants.POINT_30) {
            game.setScorePlayerB(currentScoreB + Constants.POINT_15);
        } else if (currentScoreB == Constants.POINT_30) {
            game.setScorePlayerB(Constants.POINT_40);
        } else if (currentScoreB == Constants.POINT_40 && currentScoreA < Constants.POINT_40) {
            game.setState(new EndGameState(Constants.PLAYER_B_NAME));
        } else if (currentScoreB == Constants.POINT_40 && currentScoreA == Constants.POINT_40) {
            game.setState(new DeuceState());
        }
    }

    @Override
    public String getCurrentScore(TennisGame game) {
        return Constants.PLAYER_A_NAME + ": " + displayScore(game.getScorePlayerA()) +
               " / " + Constants.PLAYER_B_NAME + ": " + displayScore(game.getScorePlayerB());
    }

    private String displayScore(int score) {
        return switch (score) {
            case Constants.POINT_0 -> Constants.SCORE_0_DISPLAY;
            case Constants.POINT_15 -> Constants.SCORE_15_DISPLAY;
            case Constants.POINT_30 -> Constants.SCORE_30_DISPLAY;
            case Constants.POINT_40 -> Constants.SCORE_40_DISPLAY;
            default -> throw new IllegalArgumentException("Score invalide: " + score);
        };
    }
}