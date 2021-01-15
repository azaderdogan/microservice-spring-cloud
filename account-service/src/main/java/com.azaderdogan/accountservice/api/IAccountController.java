package com.azaderdogan.accountservice.api;

import com.azaderdogan.accountservice.model.request.AccountSaveRequest;
import com.azaderdogan.accountservice.model.response.AccountResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IAccountController {


    ResponseEntity<AccountResponse> get(@PathVariable("id") String id);
    ResponseEntity<List<AccountResponse>> getAll();
    ResponseEntity<AccountResponse> save(AccountSaveRequest accountRequest);
    ResponseEntity<AccountResponse>  update(String id,AccountSaveRequest account);
    void delete(String id);
    ResponseEntity<Slice<AccountResponse>> pagination(Pageable pageable);

}
