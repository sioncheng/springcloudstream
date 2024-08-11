package comcom.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class MqConsumerConf {

    private static final Logger logger = LoggerFactory.getLogger(MqConsumerConf.class);

    @Bean
    public Consumer<Message<String>> cloudStreamC() {
        return message -> {
            logger.info("### received {} , {}", message, message.getPayload());
            Long l = System.currentTimeMillis();
            if (Math.abs(l.intValue()) % 2 == 0) {
                logger.info("### oops");
                throw new RuntimeException("oops");
            }
        };
    }

    @Bean
    public Consumer<Message<String>> cloudStreamCF() {
        return message -> {
            logger.info("*** received {} , {}", message, message.getPayload());
        };
    }
}
