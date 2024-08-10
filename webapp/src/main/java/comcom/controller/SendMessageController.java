package comcom.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
public class SendMessageController {


    @Resource
    private StreamBridge streamBridge;

    @RequestMapping("/api/message/send")
    public ResponseEntity<?> sendMessage() {
        streamBridge.send("cloudStreamP-out-0",
                MessageBuilder.withPayload("hello cloud stream " + LocalDateTime.now()).build());

        return ResponseEntity.ok("ok");
    }
}
