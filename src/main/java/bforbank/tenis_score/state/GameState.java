package bforbank.tenis_score.state;

import bforbank.tenis_score.config.TennisGame;

/**
 * Interface représentant un état du jeu de tennis.
 * Chaque état gère les actions possibles (gagner un point) et fournit
 * l'affichage du score.
 */
public interface GameState {
    
    /**
     * Méthode appelée lorsqu'un point est gagné par le joueur A.
     *
     * @param game Instance du jeu de tennis.
     */
    void playerAWinsPoint(TennisGame game);

    /**
     * Méthode appelée lorsqu'un point est gagné par le joueur B.
     *
     * @param game Instance du jeu de tennis.
     */
    void playerBWinsPoint(TennisGame game);

    /**
     * Obtient la représentation du score actuel.
     *
     * @return Représentation du score sous forme de chaîne.
     */
    String getCurrentScore(TennisGame game);
}