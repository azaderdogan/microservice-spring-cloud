package com.azaderdogan.accountservice.service.implementation;

import com.azaderdogan.accountservice.entity.Account;
import com.azaderdogan.accountservice.repository.cassandra.AccountRepository;
import com.azaderdogan.accountservice.service.IAccountBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService implements IAccountBusiness {

    private final AccountRepository accountRepository;

    @Override
    public Account get(String id) {

        return accountRepository.findById(id).get();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(String id,Account account) {
        Assert.isNull(id,"Id cannot be null");
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account pagination() {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
