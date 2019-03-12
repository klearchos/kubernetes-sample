package example.kubernetes.app.config;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class ApplicationProperties {

    private UUID appId = UUID.randomUUID();

    private final Endpoints endpoints = new Endpoints();

    @Getter
    @Setter
    public static class Endpoints {
        private String dataTierUrl;
    }
}
