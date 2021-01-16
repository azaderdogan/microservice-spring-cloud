package com.azaderdogan.ticketservice.service;

import com.azaderdogan.ticketservice.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {

    TicketDto save(TicketDto ticketDto);

    TicketDto update(String id, TicketDto ticketDto);
    TicketDto getById(String ticketId);

    Page<TicketDto> getAll(Pageable pageable);

}
