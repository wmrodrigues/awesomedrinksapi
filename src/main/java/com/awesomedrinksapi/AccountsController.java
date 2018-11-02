package com.awesomedrinksapi;

import java.util.List;

import com.awesomedrinksapi.Models.Account;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    AccountsController() {

    }

    @GetMapping("/api/accounts/{id}")
    Account getOne(@PathVariable Long id) {
        Account account = new Account("washington.moises@gmail.", "Washington", "Rodrigues");
        return account;
    }
}
