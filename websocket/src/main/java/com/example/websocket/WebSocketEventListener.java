package com.example.websocket;

import com.example.websocket.model.ChatMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.SimpleBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.List;
import java.util.Set;

@Component
public class WebSocketEventListener {

    private static final Logger logger =  LoggerFactory.getLogger(WebSocketEventListener.class);



    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @Autowired
    private RedisTemplate template;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
        Long size = template.opsForList().size("messageList");
        if(size != 0) {
            List<ChatMessage> messages = template.opsForList().range("messageList", 0, size);
            for(ChatMessage message : messages) {
                messageSendingOperations.convertAndSend("/topic/public", message);
            }
        }

    }



    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected: " + username);
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);
            messageSendingOperations.convertAndSend("/topic/public", chatMessage);
            template.opsForList();
        }
    }
}
