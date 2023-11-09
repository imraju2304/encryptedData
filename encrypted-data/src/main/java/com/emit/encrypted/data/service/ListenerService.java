package com.emit.encrypted.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.emit.encrypted.data.service.Impl.ListenerServiceImpl;

@Controller
public class ListenerService {

    @Autowired
    private ListenerServiceImpl listenerService;

    @MessageMapping("/connect")
    public void connect(String emitterId, WebSocketSession session) {
        listenerService.startListening(session);
    }
}
