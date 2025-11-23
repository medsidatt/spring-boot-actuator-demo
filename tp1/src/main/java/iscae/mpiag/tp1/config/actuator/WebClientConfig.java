package iscae.mpiag.tp1.config.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${actuator.base-url}")
    private String actuatorBaseUrl;

    @Bean
    public WebClient actuatorWebClient() {
        return WebClient.builder()
                .baseUrl(actuatorBaseUrl)
                .build();
    }
}
