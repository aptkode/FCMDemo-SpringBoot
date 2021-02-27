package com.aptkode.springbootfcmexample;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FCMService {

    private static final Logger logger = LoggerFactory.getLogger(FCMService.class);

    private final FirebaseApp firebaseApp;

    @Autowired
    public FCMService(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public Optional<String> sendNotification(String token, String title, String body) {
        Message message = Message.builder()
                .setNotification(Notification.builder().setTitle(title).setBody(body).build())
                .setToken(token)
                .build();
        try {
            String response = FirebaseMessaging.getInstance(firebaseApp).send(message);
            logger.info("fcm message sent. response: {}", response);
            return Optional.of(response);
        } catch (FirebaseMessagingException e) {
            logger.error("failed to send fcm message error code: {} message: {}", e.getErrorCode(), e.getMessage());
        }
        return Optional.empty();
    }
}
