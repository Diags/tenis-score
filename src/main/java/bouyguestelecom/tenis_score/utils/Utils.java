package bouyguestelecom.tenis_score.utils;

import java.util.regex.Pattern;

public class Utils {

        private static final Pattern VALID_INPUT_PATTERN = Pattern.compile("^[ABab]+$");


    private Utils(){}
    /**
     * Valide l'entrée pour s'assurer qu'elle ne contient que des lettres 'A' ou
     * 'B'.
     * 
     * @param input La séquence de points à valider.
     * @throws IllegalArgumentException Si l'entrée contient des caractères non
     *                                  valides.
     */
    public static void validateInput(String input) {
        if (input == null || input.isBlank() || !VALID_INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
    }
}
