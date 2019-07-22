package com.company.dao;

import com.company.entity.Customer;

import java.util.List;

public interface CustomerDAO {

     List<Customer> getCustomers();

     void saveCustomer (Customer theCustomer);

     Customer getCustomer (int theId);

     Customer deleteCustomer(Customer customer);
}
