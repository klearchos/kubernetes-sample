package example.kubernetes.data.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String clientId;
    private String appId;
    private int message;
}
