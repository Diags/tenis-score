package bouyguestelecom.tenis_score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TENNIS-SCORING-GAME: Jeu du tennis scoring  REST API Documentation", description = "TENNIS SCORING API Documentation", 
version = "v1", contact = @Contact(name = "SYLLA Diaguily", email = "diaguilybouna@gmail.com", url = "https://www.youtube.com/@sylladiaguily2465"),
 license = @License(name = "Apache 2.0", url = "https://www.youtube.com/@sylladiaguily2465")),
  externalDocs = @ExternalDocumentation(description = "TENNIS-SCORING-API REST Documentation", url = "https://www.tenis-score.boyguetelecome.com/swagger-ui.html"))
public class TenisScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenisScoreApplication.class, args);
	}

}
