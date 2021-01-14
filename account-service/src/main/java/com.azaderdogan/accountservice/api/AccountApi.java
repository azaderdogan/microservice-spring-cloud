package com.azaderdogan.accountservice.api;

import com.azaderdogan.accountservice.entity.Account;
import com.azaderdogan.accountservice.service.IAccountBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        /**
         * ResponseEntity bizim dışarıya vereceğimiz http status durum kodlarını kontrol eder.
         */
        return new ResponseEntity<>(accountBusiness.get(id), HttpStatus.OK);

    }
    @GetMapping()
    @Override //eğer değeri pathten alıyorsam path variable diyorum.
    public ResponseEntity<List<Account>> getAll() {
        /**
         * ResponseEntity bizim dışarıya vereceğimiz http status durum kodlarını kontrol eder.
         */
        return new ResponseEntity<>(accountBusiness.getAll(), HttpStatus.OK);

    }

    @PostMapping
    @Override
    public ResponseEntity<Account> save(@RequestBody Account account) {

        return ResponseEntity.ok(accountBusiness.save(account));
    }

    @PutMapping("/{id}")//update işlemleri outta yapılır
    @Override
    public ResponseEntity<Account> update(@PathVariable String id,@RequestBody  Account account) {
        accountBusiness.update(id,account);
        return null;
    }

    @DeleteMapping
    @Override
    public void delete(Account account) {
        accountBusiness.delete(account);
    }

    @Override
    public ResponseEntity<Account> pagination() {
        //todo
        return null;
    }
}
