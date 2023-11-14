package tn.esprit.tp1_benelbeyskander_4twin7.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDocDemo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("benelbey.skander@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
        return contact;
    }
    @Bean
    public GroupedOpenApi blocPublicApi() {
        return GroupedOpenApi.builder()

                .group("Bloc")

                                .pathsToMatch("/Bloc/**")
                                .pathsToExclude("**")
                                .build();

    }
    @Bean
    public GroupedOpenApi chambrePublicApi() {
        return GroupedOpenApi.builder()

                .group("Chambre")

                .pathsToMatch("/Chambre/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder()

                .group("Etudiant")

                .pathsToMatch("/Etudiant/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi foyerPublicApi() {
        return GroupedOpenApi.builder()

                .group("foyer")

                .pathsToMatch("/foyer/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi reservationPublicApi() {
        return GroupedOpenApi.builder()

                .group("reservation")

                .pathsToMatch("/reservation/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi universitePublicApi() {
        return GroupedOpenApi.builder()

                .group("Universite")

                .pathsToMatch("/Universite/**")
                .pathsToExclude("**")
                .build();

    }
}
