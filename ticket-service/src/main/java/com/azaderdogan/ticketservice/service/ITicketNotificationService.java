package com.azaderdogan.ticketservice.service;

import com.azaderdogan.ticketservice.entity.Ticket;

public interface ITicketNotificationService {
     void sendToQueue(Ticket ticket);
}
