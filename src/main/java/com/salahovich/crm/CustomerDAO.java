package com.salahovich.crm;

import java.util.List;

public interface CustomerDAO {
    
    public Customer getCustomer(int id);

    public List<Customer> getCustomers();

    public void addCustomer(Customer cusotmer);
    
    public void updateCustomer(Customer target);

    public void deleteCusotmer(int id);
}
