package bforbank.tenis_score.state.stateImpl;

import bforbank.tenis_score.config.Constants;
import bforbank.tenis_score.config.TennisGame;
import bforbank.tenis_score.state.GameState;

/**
 * Classe représentant l'état d'avantage pour un joueur dans un jeu de tennis.
 */
public class AdvantageState implements GameState {
    private final String advantagePlayer;

    /**
     * Initialise une nouvelle instance de AdvantageState avec le joueur en avantage.
     * 
     * @param advantagePlayer Le joueur en avantage ("Player A" ou "Player B").
     */
    public AdvantageState(String advantagePlayer) {
        this.advantagePlayer = advantagePlayer;
    }

    @Override
    public void playerAWinsPoint(TennisGame game) {
        if (Constants.PLAYER_A_NAME.equals(advantagePlayer)) {
            game.setState(new EndGameState(Constants.PLAYER_A_NAME));
        } else {
            game.setState(new DeuceState());
        }
    }

    @Override
    public void playerBWinsPoint(TennisGame game) {
        if (Constants.PLAYER_B_NAME.equals(advantagePlayer)) {
            game.setState(new EndGameState(Constants.PLAYER_B_NAME));
        } else {
            game.setState(new DeuceState());
        }
    }

    @Override
    public String getCurrentScore(TennisGame game) {
        return Constants.ADVANTAGE_PREFIX + advantagePlayer;
    }
}