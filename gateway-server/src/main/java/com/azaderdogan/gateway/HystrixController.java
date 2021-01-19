package com.azaderdogan.gateway;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fb")
@RestController
public class HystrixController {
    @GetMapping("/account")
    public String accountFallBack(){
        // bruada html cevap ta verilebilirdi
        return "Account service is not available.";
    }

    @GetMapping("/ticket")
    public String ticketFallBack(){
        return "Ticket service is not available.";
    }
}
