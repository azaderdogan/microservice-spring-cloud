package com.azaderdogan.accountservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
private String id;
    private String username;

    private String name;

    private String surname;

    private String email;

    private boolean active;

    private Date dateOfBirth;

}
