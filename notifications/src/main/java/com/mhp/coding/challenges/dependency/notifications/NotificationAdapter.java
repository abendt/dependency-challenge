package com.mhp.coding.challenges.dependency.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.NotificationPort;

@Service
public class NotificationAdapter implements NotificationPort {

    @Autowired
    EmailHandler emailHandler;

    @Autowired
    PushNotificationHandler pushNotificationHandler;

    @Override
    public void inquiryCreated(final Inquiry inquiry) {
        emailHandler.sendEmail(inquiry);
        pushNotificationHandler.sendNotification(inquiry);
    }
}
