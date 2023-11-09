package com.emit.encrypted.data.service.Impl;// ListenerServiceImpl.java

import com.emit.encrypted.data.entity.TimeSeriesEntity;
import com.emit.encrypted.data.service.ListenerService;
import com.emit.encrypted.data.service.TimeSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl extends ListenerService {

    @Autowired
    private TimeSeriesService timeSeriesService;

    @Override
    public void startListening(WebSocketSession session) {
        try {
            while (true) {
                String encryptedStream = receiveEncryptedStream(session);
                processEncryptedStream(encryptedStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String receiveEncryptedStream(WebSocketSession session) throws Exception {
        // Implement receiving encrypted stream from the WebSocket session
        TextMessage message = (TextMessage) session.receiveMessage();
        return message.getPayload();
    }

    private void processEncryptedStream(String encryptedStream) {
        String[] encryptedMessages = encryptedStream.split("\\|");

        for (String encryptedMessage : encryptedMessages) {
            String decryptedMessage = decryptMessage(encryptedMessage);
            boolean isValid = validateDataIntegrity(decryptedMessage);

            if (isValid) {
                TimeSeriesEntity timeSeriesEntity = createTimeSeriesEntity(decryptedMessage);
                timeSeriesService.saveToTimeSeries(timeSeriesEntity);
            }
        }
    }

    private String decryptMessage(String encryptedMessage) {
        return encryptedMessage;
    }

    private boolean validateDataIntegrity(String decryptedMessage) {
        return false;
    }

    private TimeSeriesEntity createTimeSeriesEntity(String decryptedMessage) {
        return null;
    }
}
