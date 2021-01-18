package com.azaderdogan.notification;

import com.azaderdogan.client.com.azaderdogan.messaging.TicketNotification;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class) //kuyruğa bağlanıyoruz
public class NotificationDistributionService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){

        System.out.println("--------------------------------------");
        System.out.println("Notification alindi kullanıcılara gönderiliyor .");
        System.out.println( "Notification -> " + ticketNotification.toString());

    }
}
