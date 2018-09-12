package com.tvestergaard.exercises.data;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;

    public Address()
    {

    }

    public Address(String street, String city)
    {
        this.street = street;
        this.city = city;
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
}
