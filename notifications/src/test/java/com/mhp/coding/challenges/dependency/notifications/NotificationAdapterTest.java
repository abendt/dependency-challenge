package com.mhp.coding.challenges.dependency.notifications;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;

@RunWith(MockitoJUnitRunner.class)
public class NotificationAdapterTest {

    @InjectMocks
    NotificationAdapter objectUnderTest;

    @Mock
    EmailHandler emailHandler;

    @Mock
    PushNotificationHandler pushNotificationHandler;

    @Test
    public void emailHandlerIsSendOnInquiryCreation() {
        objectUnderTest.inquiryCreated(new Inquiry());

        Mockito.verify(emailHandler).sendEmail(Mockito.any());
    }

    @Test
    public void notificationIsSentOnInquiryCreation() {
        objectUnderTest.inquiryCreated(new Inquiry());

        Mockito.verify(pushNotificationHandler).sendNotification(Mockito.any());
    }
}
