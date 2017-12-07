package com.iba.project.entity.book;

import com.iba.project.entity.person.Person;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Book
{
    Person auther=null;
    String name;
    BigDecimal price=null;

    public Book()
    {
    }

    public Book(Person auther,String name, BigDecimal price)
    {
        auther=new Person(auther.getName(),auther.getLastName());

        this.name=name;

        this.price=price;

    }

    public String getName() {
        return name;
    }

    public Person getAuther() {
        return auther;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuther(Person auther) {
        this.auther = auther;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
