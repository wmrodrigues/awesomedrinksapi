package com.awesomedrinksapi;

import java.util.List;

import com.awesomedrinksapi.Models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.awesomedrinksapi.Models.Account;
import com.awesomedrinksapi.Repositories.AccountRepository;


@RestController
public class AccountsController {

    @Autowired
    private AccountRepository accountRepository;

    AccountsController() {

    }

    @GetMapping("/api/accounts")
    Iterable<Account> getAll() {
        return accountRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    Account getOne(@PathVariable Long id) {
        Account account = new Account("washington.moises@gmail.", "Washington", "Rodrigues");
        return account;
    }

    @PostMapping("/api/accounts")
    Account post(@RequestBody Account account) {
        accountRepository.save(account);
        return account;
    }

    @PutMapping("/api/accounts/{id}")
    Account put(@RequestBody Account newAccount, @PathVariable Long id) {
        return accountRepository.findById(id)
                                .map(account -> {
                                    account.setName(newAccount.getName());
                                    account.setEmail(newAccount.getEmail());
                                    account.setFirstName(newAccount.setFirstName());
                                    account.setLastName(newAccount.setLastName());
                                    return accountRepository.save(account);
                                });
    }

    @DeleteMapping("/api/accounts/{id}")
    void delete(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }
}
