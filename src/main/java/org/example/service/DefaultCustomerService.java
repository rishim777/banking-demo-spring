package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  public Customer getCustomer(Long id) {
    Optional<Customer> customerbyId = repository.findById(id);
    return customerbyId.orElseGet(Customer::new);

//  same as above
//    if(customerbyId.isPresent())
//      return customerbyId.get();
//    else
//      return new Customer();
  }

}
