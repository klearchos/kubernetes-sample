package example.kubernetes.data.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

    private String clientId;
    private String appId;
    private int message;
}
