package com.azaderdogan.client.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AccountRequest {


    private String username;

    private String name;

    private String password;

    private String surname;

    private String email;

    private Date dateOfBirth;
}
