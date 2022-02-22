package org.example;

import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryDB;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//if an object is maintaining the state i.e if any component has many states then we have to make it a
//prototype bean or else it will be created as a singleton bean
@Configuration
@ComponentScan
public class AppConfig {

}
