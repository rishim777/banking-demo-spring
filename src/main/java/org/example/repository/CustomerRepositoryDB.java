package org.example.repository;

import org.example.model.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("db")
//@Primary//in case constructor is present inside the defaultCustomerService then we need to uncomment the
//primary annotation because in that case spring will not be able to identify in default case which depenndency
//spring has to inject inside the constructor
public class CustomerRepositoryDB implements CustomerRepository {

  public List<Customer> findAll() {
    List<Customer> customers = new ArrayList<>();

    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banking?user=root&password=student");
      PreparedStatement ps = conn.prepareStatement("SELECT customer_id, name, city from customers");
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
        Customer customer = new Customer(
          rs.getString("customer_id"),
          rs.getString("name"),
          rs.getString("city")
        );
        customers.add(customer);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customers;
  }
}
