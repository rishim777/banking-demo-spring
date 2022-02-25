package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("customerService")
public class DefaultCustomerService  implements CustomerService {

  @Autowired
  private CustomerRepository repository;

  public void setCustomerRepository(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  @Override
  public ResponseEntity<Customer> getCustomerById(Long id) {
    Optional<Customer> customerbyId = repository.findById(id);
    if(customerbyId.isPresent()){
      return new ResponseEntity<>(customerbyId.get(), HttpStatus.OK);
    }
      //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      //we are not returning Customer object from here, spring is internally returning an object with default
      //keys like timestamp,error, etc and their values which might be of ResponseEntity type
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found");

//  same as above
//    if(customerbyId.isPresent())
//      return customerbyId.get();
//    else
//      return new Customer();
  }

  @Override
  public void delCustomer(Long id) {
    repository.deleteById(id);
  }

}
