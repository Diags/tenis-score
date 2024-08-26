package bandyou.tenis_score;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bforbank.tenis_score.config.Constants;
import bforbank.tenis_score.config.TennisGame;


/**
 * Classe de test unitaire pour la classe {@link TennisGame}.
 * Vérifie les comportements de gestion des scores et des états du jeu.
 */
class TennisGameUnitTest {

    private TennisGame game;

    /**
     * Configuration avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        game = new TennisGame();
    }

    /**
     * Vérifie que le score initial est à zéro pour les deux joueurs.
     */
    @Test
    void testInitialScore() {
        assertEquals(Constants.POINT_0, game.getScorePlayerA());
        assertEquals(Constants.POINT_0, game.getScorePlayerB());
    }

    /**
     * Vérifie que le score du joueur A est correctement mis à jour après avoir
     * gagné un point.
     */
    @Test
    void testPlayerAWinsPoint() {
        game.playerAWinsPoint();
        assertEquals(Constants.POINT_15, game.getScorePlayerA());
        assertEquals(Constants.POINT_0, game.getScorePlayerB());
    }

    /**
     * Vérifie que le score du joueur B est correctement mis à jour après avoir
     * gagné un point.
     */
    @Test
    void testPlayerBWinsPoint() {
        game.playerBWinsPoint();
        assertEquals(Constants.POINT_0, game.getScorePlayerA());
        assertEquals(Constants.POINT_15, game.getScorePlayerB());
    }

    /**
     * Vérifie la progression des scores pendant le jeu.
     */
    @Test
    void testScoreProgression() {
        game.playerAWinsPoint(); // A: 15
        game.playerBWinsPoint(); // B: 15
        game.playerAWinsPoint(); // A: 30
        game.playerAWinsPoint(); // A: 40
        assertEquals(Constants.POINT_40, game.getScorePlayerA());
        assertEquals(Constants.POINT_15, game.getScorePlayerB());
    }

    /**
     * Vérifie le comportement lors d'un état d'égalité (Deuce).
     */
    @Test
    void testDeuceState() {
        game.playerAWinsPoint(); // A: 15
        game.playerBWinsPoint(); // B: 15
        game.playerAWinsPoint(); // A: 30
        game.playerBWinsPoint(); // B: 30
        game.playerAWinsPoint(); // A: 40
        game.playerBWinsPoint(); // B: 40
        game.playerAWinsPoint(); // A: Advantage
        assertEquals("Deuce", game.getCurrentScore());
    }

    /**
     * Vérifie le score final lorsque le joueur A gagne le jeu.
     */
    @Test
    void testEndGameState() {
        game.playerAWinsPoint(); // A: 15
        game.playerAWinsPoint(); // A: 30
        game.playerAWinsPoint(); // A: 40
        game.playerAWinsPoint(); // A wins
        assertEquals("Player A wins the game", game.getCurrentScore());
    }
}