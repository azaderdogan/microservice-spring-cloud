package com.azaderdogan.accountservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountSaveRequest {

    private String id;
    private String username;

    private String name;
    private  String password;

    private String surname;

    private String email;

    private Date dateOfBirth;
}
