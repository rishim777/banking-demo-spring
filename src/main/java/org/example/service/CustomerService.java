package org.example.service;

import org.example.model.Customer;

import java.util.List;

public interface CustomerService {

  List<Customer> getAllCustomers();
  Customer getCustomer(Long id);

  void delCustomer(Long id);
}
