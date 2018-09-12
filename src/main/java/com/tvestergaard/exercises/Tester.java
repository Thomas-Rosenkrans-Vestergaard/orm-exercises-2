package com.tvestergaard.exercises;

import com.tvestergaard.exercises.data.Address;
import com.tvestergaard.exercises.data.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Tester
{

    public static void main(String[] args)
    {
        EntityManagerFactory emf         = Persistence.createEntityManagerFactory("jpau");
        EntityManager        em          = emf.createEntityManager();
        EntityTransaction    transaction = em.getTransaction();
        transaction.begin();

        Customer customer = new Customer("Thomas", "Vestergaard");
        customer.addAddress(new Address("Møllevangen 23", "Birkerød"));

        em.persist(customer);

        transaction.commit();
    }
}
