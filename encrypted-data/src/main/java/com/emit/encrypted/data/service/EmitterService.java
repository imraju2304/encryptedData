package com.emit.encrypted.data.service;// EmitterService.java

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class EmitterService {

    private final List<String> names = List.of("Jack Reacher", "John Wick", "Alice", "Bob");
    private final List<String> origins = List.of("Bengaluru", "Mumbai", "Delhi", "Chennai");
    private final List<String> destinations = List.of("New York", "Tokyo", "London", "Paris");

    public void startEmitter(WebSocketSession session) {
        try {
            while (true) {
                String encryptedStream = generateEncryptedStream();
                session.sendMessage(new TextMessage(encryptedStream));
                Thread.sleep(10000); // Wait for 10 seconds before sending the next stream
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateEncryptedStream() {
        Random random = new Random();
        int numMessages = random.nextInt(450) + 50;
        StringBuilder encryptedStream = new StringBuilder();

        for (int i = 0; i < numMessages; i++) {
            String name = getRandomElement(names);
            String origin = getRandomElement(origins);
            String destination = getRandomElement(destinations);

            String originalMessage = String.format("{\"name\":\"%s\",\"origin\":\"%s\",\"destination\":\"%s\"}", name, origin, destination);
            String secretKey = generateHash(originalMessage);
            String encryptedMessage = encryptMessage(originalMessage, secretKey);

            encryptedStream.append(encryptedMessage).append("|");
        }

        return encryptedStream.toString();
    }

    private String getRandomElement(List<String> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    private String generateHash(String message) {
        // Implement SHA-256 hash generation
    }

    private String encryptMessage(String message, String secretKey) {
        // Implement AES-256-CTR encryption
    }
}
