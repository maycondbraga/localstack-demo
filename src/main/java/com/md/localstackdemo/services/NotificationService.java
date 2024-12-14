package com.md.localstackdemo.services;

import com.md.localstackdemo.configs.EventsConfig;
import com.md.localstackdemo.entities.NotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final EventsConfig eventsConfig;
    private final NotificationMessagingTemplate notificationMessagingTemplate;
    private final QueueMessagingTemplate queueMessagingTemplate;

    public void notifyQueue(NotificationMessage message) {
        log.info("notifying queue: {}", eventsConfig.getQueue());
        queueMessagingTemplate.convertAndSend(eventsConfig.getQueue(), message);
    }

    public void notifyTopic(NotificationMessage message) {
        log.info("Notifying topic {}", eventsConfig.getTopic());
        notificationMessagingTemplate.sendNotification(eventsConfig.getTopic(), message, "notification");
    }
}
