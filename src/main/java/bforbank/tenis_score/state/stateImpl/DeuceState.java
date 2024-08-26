package bforbank.tenis_score.state.stateImpl;

import bforbank.tenis_score.config.Constants;
import bforbank.tenis_score.config.TennisGame;
import bforbank.tenis_score.state.GameState;

/**
 * Classe représentant l'état d'égalité ("deuce") d'un jeu de tennis.
 */
public class DeuceState implements GameState {
        @Override
        public void playerAWinsPoint(TennisGame game) {
            game.setState(new AdvantageState(Constants.PLAYER_A_NAME));
        }
    
        @Override
        public void playerBWinsPoint(TennisGame game) {
            game.setState(new AdvantageState(Constants.PLAYER_B_NAME));
        }
    
        @Override
        public String getCurrentScore(TennisGame game) {
            return Constants.DEUCE_STATE;
        }
    }