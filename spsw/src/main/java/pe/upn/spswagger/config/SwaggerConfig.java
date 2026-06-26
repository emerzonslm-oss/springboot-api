package pe.upn.spswagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Personas")
                        .version("1.0")
                        .description("""
        **Participantes - Grupo 1**
        
        - Keila Carmen Cotrina Ocas
        - Mirko Emerson Sanchez Lozano
        """));

    }
}