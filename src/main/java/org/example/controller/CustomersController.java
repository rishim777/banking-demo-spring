package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping()
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long id){
        customerService.delCustomer(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Customer addCustomer(@PathVariable Long id,@RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }
}
