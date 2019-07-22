package com.company.service;

import com.company.entity.Customer;

import java.util.List;

public interface CustomerService {

     List<Customer> getCustomers ();

     void saveCustomer(Customer theCustomer);

      Customer getCustomer (int theId);

    Customer deleteCustomer(Customer customer);
}
