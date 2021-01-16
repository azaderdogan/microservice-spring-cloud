package com.azaderdogan.ticketservice.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
//diğer trabloya kalıtım yapıyoruz.
@MappedSuperclass
public abstract class BaseEntityModel implements Serializable {

    @CreatedDate
    private Date createdBy;

    private Date updatedBy;
}
