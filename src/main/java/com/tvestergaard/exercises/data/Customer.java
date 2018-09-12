package com.tvestergaard.exercises.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_address")
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

    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }

    public void addAddress(Address address)
    {
        this.addresses.add(address);
    }


    @Override public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
               Objects.equals(firstName, customer.firstName) &&
               Objects.equals(lastName, customer.lastName) &&
               Objects.equals(addresses, customer.addresses);
    }

    @Override public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, addresses);
    }
}
