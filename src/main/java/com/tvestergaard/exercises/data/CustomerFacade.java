package com.tvestergaard.exercises.data;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerFacade
{

    private final EntityManager manager;

    public CustomerFacade(EntityManager manager)
    {
        this.manager = manager;
    }

    public Customer getCustomer(int id)
    {
        return manager.find(Customer.class, id);
    }

    public List<Customer> getCustomers()
    {
        return manager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    public void addCustomer(Customer customer)
    {
        manager.persist(customer);
    }

    public void deleteCustomer(int id)
    {
        CriteriaBuilder          builder      = manager.getCriteriaBuilder();
        CriteriaDelete<Customer> query        = builder.createCriteriaDelete(Customer.class);
        Root<Customer>           customerRoot = query.from(Customer.class);
        query.where(builder.equal(customerRoot.get("id"), id));

        manager.createQuery(query).executeUpdate();
    }

    public void updateCustomer(Customer customer)
    {
        manager.unwrap(Session.class).update(customer);
    }
}
