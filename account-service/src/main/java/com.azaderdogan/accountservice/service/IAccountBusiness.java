package com.azaderdogan.accountservice.service;

import com.azaderdogan.accountservice.model.request.AccountSaveRequest;
import com.azaderdogan.accountservice.model.response.AccountResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IAccountBusiness {

    AccountResponse get(String id);
    AccountResponse save(AccountSaveRequest accountRequest);
    AccountResponse update(String id, AccountSaveRequest accountRequest);
    void delete(String id);
    Slice<AccountResponse> pagination(Pageable pageable);

    List<AccountResponse> getAll();
}
