package bouyguestelecom.tenis_score;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import bouyguestelecom.tenis_score.config.Constants;
import bouyguestelecom.tenis_score.controller.TennisController;
import bouyguestelecom.tenis_score.dto.TennisScoreResponseDto;
import bouyguestelecom.tenis_score.service.TennisService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TennisController.class)
@ContextConfiguration(classes = TenisScoreApplication.class)
class TennisControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TennisService tennisService;

    @BeforeEach
    void setUp() {
        // You can set up mocks here if needed
    }

    @Test
    void testValidInput() throws Exception {
        // Given
        TennisScoreResponseDto response = new TennisScoreResponseDto(Constants.STATUS_200, Constants.MESSAGE_200,
                List.of("Player A: 15 / Player B: 0", "Player A: 30 / Player B: 0"));
        when(tennisService.computeScore("AAB")).thenReturn(response.getMsg());

        // When & Then
        mockMvc.perform(get("/tenis-score")
                .param("input", "AAB")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testAnotherValidInput() throws Exception {
        // Given
        TennisScoreResponseDto response = new TennisScoreResponseDto(Constants.STATUS_200, Constants.MESSAGE_200,
                List.of("Player A: 15 / Player B: 15", "Player A: 30 / Player B: 15"));
        when(tennisService.computeScore("ABAB")).thenReturn(response.getMsg());

        // When & Then
        mockMvc.perform(get("/tenis-score")
                .param("input", "ABAB")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testInternalServerError() throws Exception {
        // Given
        when(tennisService.computeScore("ABAB")).thenThrow(new RuntimeException("Unexpected error"));

        // When & Then
        mockMvc.perform(get("/tenis-score")
                .param("input", "ABAB")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testBlankInput() throws Exception {
        mockMvc.perform(get("/tenis-score")
                .param("input", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testInvalidCharacter() throws Exception {
        mockMvc.perform(get("/tenis-score")
                .param("input", "A1B")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}