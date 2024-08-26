package bouyguestelecom.tenis_score.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(name = "Response", description = "Schema to hold successful response information")
public class TennisScoreResponseDto {
    @Schema(description = "Status code in the response")
    private String statusCode;
    @Schema(description = "Status message in the response")
    private String statusMsg;
    @Schema(description = " Message du jeu de tenis")
    private List<String> msg;
}
