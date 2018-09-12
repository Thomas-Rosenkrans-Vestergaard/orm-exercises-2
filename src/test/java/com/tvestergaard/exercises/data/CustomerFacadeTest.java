package com.tvestergaard.exercises.data;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;

public class CustomerFacadeTest
{

    private EntityManagerFactory emf    = Persistence.createEntityManagerFactory("jpau");
    private EntityManager        em     = emf.createEntityManager();
    private CustomerFacade       facade = new CustomerFacade(em);

    @Test
    public void getCustomer()
    {
        Customer customer = new Customer("Thomas", "Vestergaard");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        facade.addCustomer(customer);
        transaction.commit();

        assertEquals(customer, facade.getCustomer(customer.getId()));
    }

    @Test
    public void getCustomersAndAddCustomers()
    {
        EntityTransaction transaction = em.getTransaction();

        assertEquals(0, facade.getCustomers().size());

        transaction.begin();
        Customer customer = new Customer("Thomas", "Vestergaard");
        facade.addCustomer(customer);
        transaction.commit();

        assertEquals(1, facade.getCustomers().size());
        assertEquals(customer, facade.getCustomers().get(0));
    }

    @Test
    public void deleteCustomer()
    {
        EntityTransaction transaction = em.getTransaction();

        assertEquals(0, facade.getCustomers().size());

        transaction.begin();

        Customer customer = new Customer("Thomas", "Vestergaard");
        facade.addCustomer(customer);
        assertEquals(1, facade.getCustomers().size());
        facade.deleteCustomer(customer.getId());

        transaction.commit();

        assertEquals(0, facade.getCustomers().size());

    }

    @Test
    public void updateCustomer()
    {
        Customer          customer    = new Customer("Thomas", "Vestergaard");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(customer);
        transaction.commit();
        assertEquals(customer, em.find(Customer.class, customer.getId()));
        customer.setFirstName("NewFirstName");
        customer.setLastName("NewLastName");

        transaction.begin();
        facade.updateCustomer(customer);
        transaction.commit();

        assertEquals("NewFirstName", em.find(Customer.class, customer.getId()).getFirstName());
        assertEquals("NewLastName", em.find(Customer.class, customer.getId()).getLastName());
    }
}