package com.salahovich.crm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(Customer c) {
        customerDAO.addCustomer(c);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
       return customerDAO.getCustomer(id);
    }

    @Override
    public void updateCustomer(Customer target) {
        customerDAO.updateCustomer(target);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCusotmer(id);
    }
    
}
