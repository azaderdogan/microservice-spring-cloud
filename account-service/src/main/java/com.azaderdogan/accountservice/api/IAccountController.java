package com.azaderdogan.accountservice.api;

import com.azaderdogan.client.contract.AccountRequest;
import com.azaderdogan.client.contract.AccountResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IAccountController {


    ResponseEntity<AccountResponse> get(@PathVariable("id") String id);
    ResponseEntity<List<AccountResponse>> getAll();
    ResponseEntity<AccountResponse> save(AccountRequest accountRequest);
    ResponseEntity<AccountResponse>  update(String id,AccountRequest account);
    void delete(String id);
    ResponseEntity<Slice<AccountResponse>> pagination(Pageable pageable);

}
