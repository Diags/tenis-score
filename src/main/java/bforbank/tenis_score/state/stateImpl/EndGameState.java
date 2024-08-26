package bforbank.tenis_score.state.stateImpl;

import bforbank.tenis_score.config.Constants;
import bforbank.tenis_score.config.TennisGame;
import bforbank.tenis_score.state.GameState;

/**
 * Classe représentant l'état de fin de jeu lorsqu'un joueur a gagné.
 */
public class EndGameState implements GameState {
    private final String winner;

    /**
     * Initialise une nouvelle instance de EndGameState avec le gagnant du jeu.
     * 
     * @param winner Le gagnant du jeu ("Player A" ou "Player B").
     */
    public EndGameState(String winner) {
        this.winner = winner;
    }

    @Override
    public void playerAWinsPoint(TennisGame game) {
        System.out.println("Terminer");
    }

    @Override
    public void playerBWinsPoint(TennisGame game) {
        System.out.println("Terminer");
    }

    @Override
    public String getCurrentScore(TennisGame game) {
        return winner + Constants.WIN_SUFFIX;
    }
}