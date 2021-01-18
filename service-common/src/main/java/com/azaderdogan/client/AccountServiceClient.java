package com.azaderdogan.client;

import com.azaderdogan.client.contract.AccountResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ticket service ve account serviceteki getbyıd metdodunu kullanarak
 * asignee işlemini (validasyonunu)gerçekleştirecek.
 * Asignee'nin idsini mysqle kaydedeceğiz. adını ve soyadını ise
 * elasticsearche kaydederek full text search işlemni gerçekleştirecez.
 * service ler arassı iletişimi library gibi bir modülde toplayıp tüm apiler
 * birbirlerini kolayca implemente edebilecek
 */

@FeignClient("account-service")
public interface AccountServiceClient {

    @RequestMapping("/account/{id}")
    ResponseEntity<AccountResponse> get(@PathVariable("id") String id);

    public static void metot3() {

    }
    
}
