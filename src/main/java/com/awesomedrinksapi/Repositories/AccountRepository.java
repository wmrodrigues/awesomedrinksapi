package com.awesomedrinksapi.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.awesomedrinksapi.Models.Account;


public interface AccountRepository extends CrudRepository<Account, Long> {
}
