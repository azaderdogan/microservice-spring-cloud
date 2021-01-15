package com.azaderdogan.accountservice.api;

import com.azaderdogan.accountservice.model.request.AccountSaveRequest;
import com.azaderdogan.accountservice.model.response.AccountResponse;
import com.azaderdogan.accountservice.service.IAccountBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller - Rest
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")//yayın adresi
public class AccountApi implements IAccountController {

    //constructor injection autowiredten daha performanslı
    private final IAccountBusiness accountBusiness;

    @GetMapping("/{id}")
    @Override //eğer değeri pathten alıyorsam path variable diyorum.
    public ResponseEntity<AccountResponse> get(@PathVariable("id") String id) {
        /**
         * ResponseEntity bizim dışarıya vereceğimiz http status durum kodlarını kontrol eder.
         */
        return  ResponseEntity.ok(accountBusiness.get(id));

    }
    @GetMapping()
    @Override //eğer değeri pathten alıyorsam path variable diyorum.
    public ResponseEntity<List<AccountResponse>> getAll() {
        /**
         * ResponseEntity bizim dışarıya vereceğimiz http status durum kodlarını kontrol eder.
         */
        return  ResponseEntity.ok(accountBusiness.getAll());

    }

    @PostMapping
    @Override
    public ResponseEntity<AccountResponse> save(@RequestBody AccountSaveRequest account) {

        return ResponseEntity.ok(accountBusiness.save(account));
    }

    @PutMapping("/{id}")//update işlemleri outta yapılır
    @Override
    public ResponseEntity<AccountResponse> update(@PathVariable String id, @RequestBody AccountSaveRequest account) {
        accountBusiness.update(id,account);
        return null;
    }

    @DeleteMapping
    @Override
    public void delete(String id) {
        accountBusiness.delete(id);
    }

    @GetMapping("/page")
    @Override
    public ResponseEntity<Slice<AccountResponse>> pagination(Pageable pageable) {

        //todo
        return ResponseEntity.ok( accountBusiness.pagination(pageable));

    }
}
