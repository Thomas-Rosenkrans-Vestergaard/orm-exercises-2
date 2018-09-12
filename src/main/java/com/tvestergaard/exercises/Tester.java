package com.tvestergaard.exercises;

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

        //        Customer customer = new Customer("Thomas", "Vestergaard");
        //        Address  address  = new Address("Møllevangen 23", "Birkerød");
        //        customer.addAddress(address);
        //        address.addCustomer(customer);

        //        em.persist(customer);

        transaction.commit();

        //        Customer find = em.find(Customer.class, 1);
        //        System.out.println(find);
        //        System.out.println(find.getAddresses().get(0));
        //        System.out.println(find.getAddresses().get(0).getCustomers().get(0));
    }
}
