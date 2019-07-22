package com.company.dao;

import com.company.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {

//        get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //     create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
//        execute query and get result list
//        return the results
        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

//        get hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
//        save the customer
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, theId);
    }

    public Customer deleteCustomer(Customer customer) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(customer);

        return null;
    }
}

