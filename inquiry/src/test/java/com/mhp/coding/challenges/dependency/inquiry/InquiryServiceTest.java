package com.mhp.coding.challenges.dependency.inquiry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InquiryServiceTest {

    @Mock
    NotificationPort notificationPort;

    @InjectMocks
    InquiryService inquiryService;

    @Test
    public void notificationIsSentOnInquiryCreation() {
        inquiryService.create(new Inquiry());

        Mockito.verify(notificationPort).inquiryCreated(Mockito.any());
    }
}
