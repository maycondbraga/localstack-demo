package com.md.localstackdemo.requests;

import com.md.localstackdemo.entities.NotificationMessage;

public record NotificationRequest(String from, String to, String content) {
    public NotificationMessage toEntity() {
        return new NotificationMessage(from, to, content);
    }
}
