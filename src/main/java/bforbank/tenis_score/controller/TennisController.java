package bforbank.tenis_score.controller;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bforbank.tenis_score.config.Constants;
import bforbank.tenis_score.dto.ErrorResponseDto;
import bforbank.tenis_score.dto.TennisScoreResponseDto;
import bforbank.tenis_score.service.TennisService;
import bforbank.tenis_score.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Contrôleur REST pour gérer les requêtes liées au jeu de tennis.
 */
@Tag(name = "Tenis score API", description = "jeu de tennis : https://en.wikipedia.org/wiki/Tennis#Scoring ")
@RestController
@Validated
public class TennisController {
    private final TennisService tennisService;

    /**
     * Initialise une nouvelle instance de TennisController.
     * 
     * @param tennisService Le service de tennis à utiliser.
     */
    public TennisController(TennisService tennisService) {
        this.tennisService = tennisService;
    }

    /**
     * Point d'entrée pour calculer le score en fonction de l'entrée de points.
     * 
     * @param input La chaîne de caractères représentant les points gagnés par les joueurs.
     * @return La liste des scores après chaque point.
     */
     @Operation(summary = "recupere le resultat du jeu", description = "REST API Get qui demare le jeu et retourne une reponse")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "HTTP Status OK", content = @Content(schema = @Schema(implementation = TennisScoreResponseDto.class))),
                        @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
        })
     @GetMapping("/tenis-score")
     public ResponseEntity<Object> computeScore(@RequestParam String input) {
               Utils.validateInput(input);
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(new TennisScoreResponseDto(Constants.STATUS_200, Constants.MESSAGE_200, tennisService.computeScore(input)));
     }
}