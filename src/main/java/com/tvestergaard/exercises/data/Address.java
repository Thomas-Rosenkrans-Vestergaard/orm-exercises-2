package com.tvestergaard.exercises.data;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Address
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public Address()
    {

    }

    public Address(String street, String city, Customer customer)
    {
        this.street = street;
        this.city = city;
        this.customer = customer;
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

    public Customer getCustomer()
    {
        return this.customer;
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

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
