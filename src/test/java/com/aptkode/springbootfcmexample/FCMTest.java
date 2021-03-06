package com.aptkode.springbootfcmexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FCMTest {

    @Autowired
    private FCMService fcmService;

    @Test
    void sendNotificationTest() {
        final Optional<String> response = fcmService.sendNotification("xxxxxxxxxxxxxx",
                "test-notification",
                "test-body");
        assertTrue(response.isPresent());
    }

}
