package com.md.localstackdemo.controllers;

import com.md.localstackdemo.requests.NotificationRequest;
import com.md.localstackdemo.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/topic")
    public ResponseEntity<Void> sendNotificationTopic(@RequestBody NotificationRequest request) {
        log.info("sending message to SNS topic");
        notificationService.notifyTopic(request.toEntity());

        log.info("message sent to SNS topic");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/queue")
    public ResponseEntity<Void> sendNotificationQueue(@RequestBody NotificationRequest request) {
        log.info("sending message to SQS queue");
        notificationService.notifyQueue(request.toEntity());

        log.info("message sent to SQS queue");
        return ResponseEntity.ok().build();
    }
}
