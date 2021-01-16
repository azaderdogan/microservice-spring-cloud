package com.azaderdogan.ticketservice.repository.elasticsearch;

import com.azaderdogan.ticketservice.entity.elasticsearch.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {

}
