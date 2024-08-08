package comcom;

import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDateTime;

@SpringBootApplication
public class App implements ApplicationRunner {

    @Resource
    private StreamBridge streamBridge;


    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(streamBridge);

        streamBridge.send("cloudStream-out-0",
                MessageBuilder.withPayload("hello cloud stream " + LocalDateTime.now()).build());
    }
}
