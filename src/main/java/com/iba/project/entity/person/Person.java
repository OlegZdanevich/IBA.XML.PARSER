package com.iba.project.entity.person;

public class Person {
    String name;
    String lastName;

    public Person(String name,String lastName)
    {
        this.name=name;
        this.lastName=lastName;
    }

    public Person()
    {}

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
