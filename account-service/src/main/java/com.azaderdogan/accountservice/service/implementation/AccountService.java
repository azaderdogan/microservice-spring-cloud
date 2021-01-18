package com.azaderdogan.accountservice.service.implementation;

import com.azaderdogan.accountservice.entity.Account;
import com.azaderdogan.accountservice.repository.cassandra.AccountRepository;
import com.azaderdogan.accountservice.service.IAccountBusiness;
import com.azaderdogan.client.contract.AccountRequest;
import com.azaderdogan.client.contract.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountService implements IAccountBusiness {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    @Override
    public AccountResponse get(String id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(account, AccountResponse.class);
    }
    @Transactional
    @Override
    public AccountResponse save(AccountRequest accountRequest) {
        Account account = modelMapper.map(accountRequest, Account.class);
        accountRepository.save(account);
        return modelMapper.map(account, AccountResponse.class);
    }
    @Transactional
    @Override
    public AccountResponse update(String id, AccountRequest accountRequest) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> account = Optional.ofNullable(accountRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new));

        Account accountToUpdate = account.map(item -> {
            item.setDateOfBirth(accountRequest.getDateOfBirth());
            item.setName(accountRequest.getName());
            item.setSurname(accountRequest.getSurname());
            return item;
        }).orElseThrow(IllegalArgumentException::new);
        accountToUpdate = accountRepository.save(accountToUpdate);
        return modelMapper.map(accountToUpdate, AccountResponse.class);
    }

    @Transactional
    @Override
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        accountRepository.delete(account);
    }

    @Override
    public Slice<AccountResponse> pagination(Pageable pageable) {
        Slice<Account> accountSlice = accountRepository.findAll(pageable);

        return null;
    }

    @Override
    public List<AccountResponse> getAll() {
        return accountRepository
                .findAll()
                .stream()
                .map(account -> modelMapper.map(account,AccountResponse.class))
                .collect(Collectors.toList());
    }
/*

    private Account saveRequestToAccount(AccountSaveRequest accountsr) {
        return Account.builder()
                .name(accountsr.getName())
                .surname(accountsr.getSurname())
                .email(accountsr.getEmail())
                .active(false)
                //todo buraya bak.
                .createdAt(Date.from(Instant.now()))
                .dateOfBirth(accountsr.getDateOfBirth())
                .id(accountsr.getId() == null ? UUID.randomUUID().toString() : accountsr.getId())
                .password(accountsr.getPassword())
                .username(accountsr.getUsername())
                .build();
    }

    private Account requestToAccount(AccountRequest accountRequest) {
        return Account.builder()
                .name(accountRequest.getName())
                .surname(accountRequest.getSurname())
                .email(accountRequest.getEmail())
                .active(false)
                .dateOfBirth(accountRequest.getDateOfBirth())
                .id(accountRequest.getId())
                .username(accountRequest.getUsername())
                .build();
    }

    private AccountResponse accountToResponse(Account account) {
        return AccountResponse.builder()
                .name(account.getName())
                .surname(account.getSurname())
                .email(account.getEmail())
                .active(account.getActive())
                .dateOfBirth(account.getDateOfBirth())
                .id(account.getId())
                .username(account.getUsername())
                .build();
    }
*/

}
