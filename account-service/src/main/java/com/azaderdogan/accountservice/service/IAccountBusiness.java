package com.azaderdogan.accountservice.service;

import com.azaderdogan.accountservice.entity.Account;

import java.util.List;

public interface IAccountBusiness {

    Account get(String id);
    Account save(Account account);
    Account update(String id,Account account);
    void delete(Account account);
   Account pagination();

    List<Account> getAll();
}
