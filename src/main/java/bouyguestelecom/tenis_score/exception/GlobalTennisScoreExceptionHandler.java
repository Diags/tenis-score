package bouyguestelecom.tenis_score.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import bouyguestelecom.tenis_score.dto.ErrorResponseDto;

/**
 * Gestionnaire des exceptions pour le contrôleur de tennis.
 * <p>
 * Cette classe gère les exceptions qui se produisent dans l'application en
 * fournissant des réponses d'erreur formatées.
 * </p>
 */
@ControllerAdvice
public class GlobalTennisScoreExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Gère les exceptions de validation des arguments de méthode.
     *
     * @param ex         L'exception de validation.
     * @param headers    Les en-têtes HTTP.
     * @param statusCode Le code de statut HTTP.
     * @param request    La requête Web.
     * @return Une réponse contenant les détails des erreurs.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gère les exceptions illégales.
     *
     * @param ex         L'exception illégale.
     * @param webRequest La requête Web.
     * @return Une réponse contenant les détails de l'erreur illégale.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException ex,
            WebRequest webRequest) {
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gère les exceptions générales.
     *
     * @param exception  L'exception générale.
     * @param webRequest La requête Web.
     * @return Une réponse contenant les détails de l'erreur générale.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
            WebRequest webRequest) {
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}