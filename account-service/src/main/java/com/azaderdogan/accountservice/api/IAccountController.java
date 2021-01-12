package com.azaderdogan.accountservice.api;

import com.azaderdogan.accountservice.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IAccountController {


    ResponseEntity<Account> get(@PathVariable("id") String id);
    ResponseEntity<List<Account>> getAll();
    ResponseEntity<Account> save(Account account);
    ResponseEntity<Account> update(String id,Account account);
    void delete(Account account);
    ResponseEntity<Account> pagination();

}
