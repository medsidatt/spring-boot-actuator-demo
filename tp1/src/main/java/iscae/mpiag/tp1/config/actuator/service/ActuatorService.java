package iscae.mpiag.tp1.config.actuator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ActuatorService {

    private final WebClient client;

    public ActuatorService(@Value("${actuator.base-url}") String baseUrl) {
        this.client = WebClient.create(baseUrl);
    }

    public Map getHealth() {
        return client.get().uri("/health").retrieve().bodyToMono(Map.class).block();
    }

    public Map getMetrics(String name) {
        return client.get().uri("/metrics/" + name).retrieve().bodyToMono(Map.class).block();
    }
}
