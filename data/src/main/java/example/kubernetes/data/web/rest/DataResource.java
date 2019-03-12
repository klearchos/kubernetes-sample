package example.kubernetes.data.web.rest;

import example.kubernetes.data.Statistics;
import example.kubernetes.data.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class DataResource {

    Statistics statistics;

    DataResource(Statistics statistics) {
        this.statistics = statistics;
    }

    @PostMapping("/message")
    public void createMessage(@RequestBody Message message) {
        log.info("Incoming Message {}", message.toString());
        statistics.increaseNumberOfClientCalls();
    }

}
