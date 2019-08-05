package com.company.controller;

import com.company.entity.Customer;
import com.company.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    public CustomerService getCustomerDAO() {
//        return customerService;
//    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        //get customers from DAO
        List<Customer> theCustomers = customerService.getCustomers();

        theModel.addAttribute("customers", theCustomers);

        // add customers to the model

        return "list-customers";
    }

    @GetMapping("/showFormForAddCustomer")
    public String showFormForAdd(Model theModel) {

//        create model attribute to bind form data


        Customer customer = new Customer();
        theModel.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer (@ModelAttribute("customer")Customer theCustomer){

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @RequestMapping("/showFormForUpdateCustomer")
    public String showFormForUpdateCustomer(@RequestParam("customerId") int theId, Model theModel){

        // get the customer from database

        Customer customer = customerService.getCustomer(theId);

        theModel.addAttribute("customer",customer);
        // set customer as a model attribute to pre- populate the form

        // send over to our customer
        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id) {

        Customer customer = customerService.getCustomer(id);

        customerService.deleteCustomer(customer);

        return "redirect:/customer/list";
    }
}
