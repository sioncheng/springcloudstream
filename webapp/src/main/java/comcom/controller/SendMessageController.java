package comcom.controller;

import jakarta.annotation.Resource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
public class SendMessageController {


    @Resource
    private StreamBridge streamBridge;

    @RequestMapping("/api/message/send/{key}")
    public ResponseEntity<?> sendMessage(@PathVariable(required = false) String key) {

        MessageBuilder<String> messageBuilder = MessageBuilder.withPayload("hello cloud stream " + LocalDateTime.now());
        if (Objects.nonNull(key)) {
            messageBuilder.setHeader(MessageConst.PROPERTY_KEYS, key);
        }
        streamBridge.send("cloudStreamP-out-0",messageBuilder.build());

        return ResponseEntity.ok("ok");
    }
}
