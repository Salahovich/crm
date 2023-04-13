package com.salahovich.crm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOimp implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Customer getCustomer(int id) {
        Session session =  sessionFactory.openSession();
        return session.get(Customer.class, id);
    }   

    @Override
    public List<Customer> getCustomers() {
        Session session =  sessionFactory.openSession();
        
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> list = query.getResultList();

        System.out.println("****************************");
        System.out.println(list.toString());
        return list;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        session.save(customer);
           // session.persist(customer);
    }

    @Override
    public void updateCustomer(Customer target) {
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.saveOrUpdate(target);
        session.getTransaction().commit();
    }

    @Override
    public void deleteCusotmer(int id) {
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        Customer temp = session.get(Customer.class, id);
        session.remove(temp);
        session.getTransaction().commit();
    }

}

