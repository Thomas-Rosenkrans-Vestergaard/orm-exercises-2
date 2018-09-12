package com.tvestergaard.exercises.data;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @Cascade(value = org.hibernate.annotations.CascadeType.REMOVE)
    @JoinColumn(name = "customer")
    private List<Address> addresses = new ArrayList<>();

    public Customer()
    {

    }

    public Customer(String firstName, String lastName, List<Address> addresses)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }

    public Customer(String firstName, String lastName)
    {
        this(firstName, lastName, new ArrayList<>());
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

    public List<Address> getAddresses()
    {
        return this.addresses;
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

    public void addAddress(Address address)
    {
        this.addresses.add(address);
    }

    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }
}
