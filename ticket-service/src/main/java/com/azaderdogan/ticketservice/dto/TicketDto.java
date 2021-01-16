package com.azaderdogan.ticketservice.dto;

import com.azaderdogan.ticketservice.entity.PriorityType;
import com.azaderdogan.ticketservice.entity.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TicketDto {
    private  String id;
    private String description;

    private String notes;

    private String assignee; //account uuud

    private Date ticketDate;

    private String priorityType;

    private String ticketStatus;
}
