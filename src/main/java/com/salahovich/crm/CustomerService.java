package com.salahovich.crm;

import java.util.List;

public interface CustomerService {
    
    public List<Customer> getCustomers();
    public void addCustomer(Customer c);
    public Customer getCustomer(int id);
    public void updateCustomer(Customer target);
    public void deleteCustomer(int id);
}
