package bouyguestelecom.tenis_score;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bouyguestelecom.tenis_score.config.TennisGame;
import bouyguestelecom.tenis_score.service.TennisService;

/**
 * Classe de test unitaire pour la classe {@link TennisGame}.
 * Vérifie les comportements de gestion des scores et des états du jeu.
 */
@SpringBootTest
class TennisGameTest {
    @Autowired
    private TennisService tennisService;

    @Test
    void testComputeScore_validInput_playerAWins() {
        // Given a valid input sequence where player A wins
        String input = "AAABBBBAAAAA";

        // When computing the score
        List<String> result = tennisService.computeScore(input);

        // Then it should reflect player A wins
        assertTrue(result.get(result.size() - 1).contains("wins"));
        assertTrue(result.get(result.size() - 1).contains("Player A"));
    }

    @Test
    void testComputeScore_validInput_playerBWins() {
        // Given a valid input sequence where player B wins
        String input = "BBBBABBB";

        // When computing the score
        List<String> result = tennisService.computeScore(input);

        // Then it should reflect player B wins
        assertTrue(result.get(result.size() - 1).contains("wins"));
        assertTrue(result.get(result.size() - 1).contains("Player B"));
    }

    @Test
    void testComputeScore_validInput_deuceToWin() {
        // Given a valid input sequence leading to deuce and advantage
        String input = "AAABBBABAB";

        // When computing the score
        List<String> result = tennisService.computeScore(input);

        // Then it should reflect a deuce situation and subsequent win
        assertEquals("Advantage Player B", result.get(result.size() - 3)); // Third from last should be Deuce
    }

    @Test
    void testComputeScore_invalidInput() {
        // Given an invalid input sequence
        String input = "AACXZ";

        // When and Then: computing the score should throw an IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tennisService.computeScore(input);
        });
        // Then it should process until the first invalid character and stop
        // Validate the exception message
        assertEquals("Invalid input: AACXZ", exception.getMessage());
    }

    @Test
    void testComputeScore_mixedInputWithInvalidCharacters() {
        // Given an input sequence with some valid and some invalid points
        String input = "AAAXBB";

        // When and Then: computing the score should throw an IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tennisService.computeScore(input);
        });

        // Then it should process until the first invalid character and stop
        // Validate the exception message
        assertEquals("Invalid input: AAAXBB", exception.getMessage());
    }
}