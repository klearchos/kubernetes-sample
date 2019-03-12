package example.kubernetes.app.web.rest;

import example.kubernetes.app.config.ApplicationProperties;
import example.kubernetes.data.domain.Message;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class DataResource {

    private final RestTemplate restTemplate;
    private final ApplicationProperties applicationProperties;

    DataResource(RestTemplateBuilder builder, ApplicationProperties applicationProperties) {
        this.restTemplate = builder.build();
        this.applicationProperties = applicationProperties;
    }

    @PostMapping("/message")
    public void createMessage(@RequestBody String clientId) {
        Message msg = new Message();
        msg.setClientId(clientId);
        msg.setAppId(applicationProperties.getAppId().toString());
        msg.setMessage((int)(Math.random() * 1000 + 1)); // A random number between 1 - 1000
        restTemplate.postForObject(applicationProperties.getEndpoints().getDataTierUrl(),
                msg, Message.class);
    }
}
