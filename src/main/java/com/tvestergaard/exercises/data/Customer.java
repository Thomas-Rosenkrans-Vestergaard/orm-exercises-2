package com.tvestergaard.exercises.data;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @Cascade(value = org.hibernate.annotations.CascadeType.REMOVE)
    private Address address;

    public Customer()
    {

    }

    public Customer(String firstName, String lastName, Address address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getId()
    {
        return this.id;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }
}
