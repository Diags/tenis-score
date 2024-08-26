package bouyguestelecom.tenis_score.config;
/**
 * Classe contenant des constantes explicites pour le jeu de tennis.
 */
public final class Constants {

    // Identifiants des joueurs
    public static final String PLAYER_A_NAME = "Player A";
    public static final String PLAYER_B_NAME = "Player B";

    // États du jeu
    public static final String DEUCE_STATE = "Deuce";
    public static final String ADVANTAGE_PREFIX = "Advantage ";
    public static final String WIN_SUFFIX = " wins the game";

    // Points de score
    public static final int POINT_0 = 0;     // Valeur du score 0
    public static final int POINT_15 = 15;   // Valeur du score 15
    public static final int POINT_30 = 30;   // Valeur du score 30
    public static final int POINT_40 = 40;   // Valeur du score 40

    // Affichage du score
    public static final String SCORE_0_DISPLAY = "0";
    public static final String SCORE_15_DISPLAY = "15";
    public static final String SCORE_30_DISPLAY = "30";
    public static final String SCORE_40_DISPLAY = "40";

    // Messages d'erreur
    public static final String INVALID_INPUT_ERROR = "Invalid input: ";
    // Api response
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_404 = "404";
    public static final String MESSAGE_404 = "BAD Request : request not processed";

    private Constants() {
        // Empêche l'instanciation
    }
}