package example.kubernetes.data;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Statistics {

    private AtomicInteger numberOfClientCalls = new AtomicInteger();

    public void increaseNumberOfClientCalls() {
        log.info("Client calls " + numberOfClientCalls.incrementAndGet());
    }

}
