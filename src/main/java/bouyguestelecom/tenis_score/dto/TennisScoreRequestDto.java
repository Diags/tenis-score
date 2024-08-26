package bouyguestelecom.tenis_score.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) pour représenter l'entrée des points de tennis.
 */

@Getter
@Setter
@AllArgsConstructor
@Schema(name = "Request", description = "Schema to hold successful response information")
public class TennisScoreRequestDto {
    @Schema(description = "Request message")
    private String input;

}