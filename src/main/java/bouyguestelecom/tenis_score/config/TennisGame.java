package bouyguestelecom.tenis_score.config;

import bouyguestelecom.tenis_score.state.GameState;
import bouyguestelecom.tenis_score.state.stateImpl.NormalState;

/**
 * Classe représentant un jeu de tennis.
 */
public class TennisGame {
    private int scorePlayerA = Constants.POINT_0;
    private int scorePlayerB = Constants.POINT_0;
    private GameState currentState = new NormalState();

    /**
     * Permet au joueur A de gagner un point.
     */
    public void playerAWinsPoint() {
        
        currentState.playerAWinsPoint(this);
    }

    /**
     * Permet au joueur B de gagner un point.
     */
    public void playerBWinsPoint() {
        currentState.playerBWinsPoint(this);
    }

    /**
     * Définit l'état actuel du jeu.
     * @param state L'état à définir.
     */
    public void setState(GameState state) {
        this.currentState = state;
    }

    /**
     * Définit le score du joueur A.
     * @param score Le score à définir.
     */
    public void setScorePlayerA(int score) {
        this.scorePlayerA = score;
    }

    /**
     * Définit le score du joueur B.
     * @param score Le score à définir.
     */
    public void setScorePlayerB(int score) {
        this.scorePlayerB = score;
    }

    /**
     * Retourne le score du joueur A.
     * @return Le score du joueur A.
     */
    public int getScorePlayerA() {
        return scorePlayerA;
    }

    /**
     * Retourne le score du joueur B.
     * @return Le score du joueur B.
     */
    public int getScorePlayerB() {
        return scorePlayerB;
    }

    /**
     * Réinitialise le jeu.
     */
    public void resetGame() {
        scorePlayerA = Constants.POINT_0;
        scorePlayerB = Constants.POINT_0;
        currentState = new NormalState();
    }

    /**
     * Retourne le score actuel du jeu.
     * @return Le score actuel sous forme de chaîne de caractères.
     */
    public String getCurrentScore() {
        return currentState.getCurrentScore(this);
    }

}