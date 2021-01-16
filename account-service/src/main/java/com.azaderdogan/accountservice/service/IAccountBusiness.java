package com.azaderdogan.accountservice.service;

import com.azaderdogan.client.contract.AccountRequest;
import com.azaderdogan.client.contract.AccountResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IAccountBusiness {

    AccountResponse get(String id);
    AccountResponse save(AccountRequest accountRequest);
    AccountResponse update(String id, AccountRequest accountRequest);
    void delete(String id);
    Slice<AccountResponse> pagination(Pageable pageable);

    List<AccountResponse> getAll();
}
