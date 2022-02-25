package org.example.service;

import org.example.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

  List<Customer> getAllCustomers();

  ResponseEntity<Customer> getCustomerById(Long id);

  void delCustomer(Long id);

  Customer addCustomer(Customer customer);

  Customer updateCustomer(Long id, Customer customer);
}
