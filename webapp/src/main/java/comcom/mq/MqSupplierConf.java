package comcom.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDateTime;
import java.util.function.Supplier;

@Configuration
public class MqSupplierConf {

    private static final Logger logger = LoggerFactory.getLogger(MqSupplierConf.class);

    @Bean
    public Supplier<Message<String>> cloudStreamP() {
        return () -> {
            String message = "hello cloud stream " + LocalDateTime.now();
            logger.info("@@@ send message {}", message);
            return MessageBuilder
                .withPayload(message)
                .build();
        };
    }
}
