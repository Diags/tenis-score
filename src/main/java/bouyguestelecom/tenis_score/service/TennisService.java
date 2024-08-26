package bouyguestelecom.tenis_score.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import bouyguestelecom.tenis_score.config.Constants;
import bouyguestelecom.tenis_score.config.TennisGame;
import bouyguestelecom.tenis_score.utils.Utils;

/**
 * Service pour gérer les calculs et la logique du score du jeu de tennis.
 */
@Service
public class TennisService {
    private final TennisGame game;

    public TennisService() {
        this.game = new TennisGame();
    }

    /**
     * Calcule les scores en fonction de la séquence de points.
     * 
     * @param input La séquence de points gagnés par les joueurs.
     * @return La liste des scores après chaque point.
     */
    public List<String> computeScore(String input) {
        // validation de l'input
        Utils.validateInput(input);
        game.resetGame();
        List<String> results = new ArrayList<>();
        for (char point : input.toCharArray()) {
            switch (point) {
                case 'A' -> game.playerAWinsPoint();
                case 'B' -> game.playerBWinsPoint();
                default -> {
                    results.add(Constants.INVALID_INPUT_ERROR + point);
                    return results;
                }
            }

            String currentScore = game.getCurrentScore();
            results.add(currentScore);

            // Arrêter le traitement si le jeu est terminé
            if (currentScore.contains(Constants.WIN_SUFFIX)) {
                break;
            }
        }
        return results;
    }


}