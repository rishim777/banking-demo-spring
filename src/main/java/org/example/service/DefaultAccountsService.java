package org.example.service;

import org.example.model.Accounts;
import org.example.model.Customer;
import org.example.repository.AccountsRepository;
import org.example.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("accountsService")
public class DefaultAccountsService implements AccountsService{

    @Autowired
    private AccountsRepository repository;

    public DefaultAccountsService(AccountsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Accounts> getAccountById(Long id) {
        Optional<Accounts> accountbyId = repository.findById(id);
        if(accountbyId.isPresent()){
            return new ResponseEntity<>(accountbyId.get(), HttpStatus.OK);
        }
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //we are not returning ResponseEntity<Customer> object from here, spring is internally returning an object with default
        //keys like timestamp,error, etc and their values.
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found");
    }

    @Override
    public void delAccount(Long id) {
        ResponseEntity<Accounts> responseEntity=getAccountById(id);
        if(responseEntity.getStatusCode().is4xxClientError()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found");
        }
        repository.deleteById(id);
    }

    @Override
    public Accounts addAccount(Accounts account) {
        return repository.saveAndFlush(account);
    }

    @Override
    public Accounts updateAccount(Long id, Accounts account) {
        ResponseEntity<Accounts> responseEntity = getAccountById(id);
        if(responseEntity.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Account Id");
        }

        Accounts existingAccount=responseEntity.getBody();
        BeanUtils.copyProperties(account, existingAccount, "id");
        return repository.saveAndFlush(existingAccount);
    }
}
