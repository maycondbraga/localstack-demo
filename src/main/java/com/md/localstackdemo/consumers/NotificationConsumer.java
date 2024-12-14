package com.md.localstackdemo.consumers;

import com.amazonaws.services.sqs.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {
    @SqsListener(value = "${events.queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(Message message) {
        log.info("message id: {} - received message: {}", message.getMessageId(), message.getBody());
    }
}
