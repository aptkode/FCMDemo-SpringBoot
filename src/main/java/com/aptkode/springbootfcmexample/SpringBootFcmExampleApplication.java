package com.aptkode.springbootfcmexample;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class SpringBootFcmExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFcmExampleApplication.class, args);
    }

    @Bean
    public FirebaseApp initFirebaseApp() throws IOException {
        InputStream serviceAccount = SpringBootFcmExampleApplication.class.getResourceAsStream("/xxx.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        return FirebaseApp.getInstance();
    }

}
