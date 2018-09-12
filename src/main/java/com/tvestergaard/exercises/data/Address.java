package com.tvestergaard.exercises.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String street;
    private String city;

    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers = new ArrayList<>();

    public Address()
    {

    }

    public Address(String street, String city, List<Customer> customers)
    {
        this.street = street;
        this.city = city;
        this.customers = customers;
    }

    public Address(String street, String city)
    {
        this(street, city, new ArrayList<>());
    }

    public int getId()
    {
        return this.id;
    }

    public String getStreet()
    {
        return this.street;
    }

    public String getCity()
    {
        return this.city;
    }

    public List<Customer> getCustomers()
    {
        return this.customers;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
}
