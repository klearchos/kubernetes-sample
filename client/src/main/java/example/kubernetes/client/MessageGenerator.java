package example.kubernetes.client;

import example.kubernetes.client.config.ApplicationProperties;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class MessageGenerator {

    private final RestTemplate restTemplate;
    private final ApplicationProperties applicationProperties;
    private final AtomicInteger counter = new AtomicInteger();

    MessageGenerator(RestTemplateBuilder builder, ApplicationProperties applicationProperties) {
        this.restTemplate = builder.build();
        this.applicationProperties = applicationProperties;
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduleMessageGenerator() {
        restTemplate.postForObject(applicationProperties.getEndpoints().getAppTierUrl(),
                applicationProperties.getClientId(), String.class);
        log.info("Client with Id {} generated {} messages",
                applicationProperties.getClientId(), counter.incrementAndGet());
    }
}
