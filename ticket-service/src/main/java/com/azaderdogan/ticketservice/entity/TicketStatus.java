package com.azaderdogan.ticketservice.entity;

public enum TicketStatus {
    OPEN("Açık"),
    IN_PROGRESS("Üzerinde çalışılıyor"),
    RESOLVED("Çözüldü"),
    CLOSED("Kapandı");

    private String label;

    TicketStatus(String label){
        this.label = label;
    }
}
