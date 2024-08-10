package comcom.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Function;

@Configuration
public class MqFunctionConf {

    private static final Logger logger = LoggerFactory.getLogger(MqFunctionConf.class);

    @Bean
    public Function<Message<String>, Message<String>> mqFunction() {
        return (input) -> {
            String payload = input.getPayload();
            return MessageBuilder.withPayload("mqFunction : " + payload).build();
        };
    }
}
