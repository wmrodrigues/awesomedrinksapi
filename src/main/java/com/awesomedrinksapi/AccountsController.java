package com.awesomedrinksapi;

import com.awesomedrinksapi.Exceptions.AccountNotFoundException;
import com.awesomedrinksapi.Models.Account;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.awesomedrinksapi.Repositories.AccountRepository;


@RestController
public class AccountsController {

    private final AccountRepository accountRepository;

    AccountsController(AccountRepository repository) {
        this.accountRepository = repository;

    }

    @GetMapping("/api/accounts")
    Iterable<Account> getAll() {
        return accountRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    Account getOne(@PathVariable Long id) {
        return accountRepository.findById(id)
                    .orElseThrow(() -> new AccountNotFoundException(id));
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
                                    account.setFirstName(newAccount.getFirstName());
                                    account.setLastName(newAccount.getLastName());
                                    account.setBirthdate(newAccount.getBirthdate());
                                    return accountRepository.save(account);
                                })
                                .orElseGet(() -> {
                                    newAccount.setId(id);
                                    return accountRepository.save(newAccount);
                                });
    }

    @DeleteMapping("/api/accounts/{id}")
    void delete(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }
}
