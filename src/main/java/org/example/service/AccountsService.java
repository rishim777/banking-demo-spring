package org.example.service;

import org.example.model.Accounts;
import org.example.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountsService {

    List<Accounts> getAllAccounts();
    ResponseEntity<Accounts> getAccountById(Long id);

    void delAccount(Long id);

    Accounts addAccount(Accounts account);

    Accounts updateAccount(Long id, Accounts account);

}
