package org.example.controller;

import org.example.model.Accounts;
import org.example.model.Customer;
import org.example.service.AccountsService;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")

public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @RequestMapping
    public List<Accounts> getAllAccounts(){
        return accountsService.getAllAccounts();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Accounts> getAccount(@PathVariable Long id){
        return accountsService.getAccountById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long id){
        accountsService.delAccount(id);
    }

    @PostMapping
    public Accounts addCustomer(@RequestBody Accounts account){
        return accountsService.addAccount(account);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Accounts addAccount(@PathVariable Long id,@RequestBody Accounts account){
        return accountsService.updateAccount(id,account);
    }
}
