package com.azaderdogan.ticketservice.service.implementation;

import com.azaderdogan.client.AccountServiceClient;
import com.azaderdogan.client.contract.AccountResponse;
import com.azaderdogan.ticketservice.dto.TicketDto;
import com.azaderdogan.ticketservice.entity.PriorityType;
import com.azaderdogan.ticketservice.entity.Ticket;
import com.azaderdogan.ticketservice.entity.TicketStatus;
import com.azaderdogan.ticketservice.entity.elasticsearch.TicketModel;
import com.azaderdogan.ticketservice.repository.jpa.TicketRepository;
import com.azaderdogan.ticketservice.repository.elasticsearch.TicketElasticRepository;
import com.azaderdogan.ticketservice.service.ITicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

/**
 * validate service te ayrı olarak yazılabilirdi.
 */
@Service
@RequiredArgsConstructor
public class TicketService implements ITicketService {


    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private final AccountServiceClient accountServiceClient;


    @Transactional
    @Override
    public TicketDto save(TicketDto ticketDto) {
        //TİCKET ENTİTY YAP
        Ticket ticket = new Ticket();
        //TODO ACCOUNT APİ DAN DOĞRULA
        //todo ticket.setAssignee();
        ResponseEntity<AccountResponse> accountResponseEntity = accountServiceClient.get(ticketDto.getAssignee());


        if (ticketDto.getDescription() == null) {
            throw new IllegalArgumentException("Description boş olamaz");
        }
        if (accountResponseEntity.getStatusCode().value() != 200)
            throw new HttpClientErrorException(accountResponseEntity.getStatusCode(), "İstek başarısız");
        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticket.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountResponseEntity.getBody().getId());//accountut sonrada aldık
        //mysql kaydet
        ticket = ticketRepository.save(ticket);


        //ticket model nesnesi yarat
        TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .assignee(accountResponseEntity.getBody().getNameSurname())
                .id(ticket.getId())
                .ticketStatus(ticketDto.getTicketStatus())
                .priorityType(ticketDto.getPriorityType()).build();


        // elastic'e kaydet
        ticketElasticRepository.save(ticketModel);
        //oluşan nesneyi döndür
        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return modelMapper.map(ticketElasticRepository.findById(ticketId), TicketDto.class);
    }

    @Override
    public Page<TicketDto> getAll(Pageable pageable) {
        return null;
    }
}
