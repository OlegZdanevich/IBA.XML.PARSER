package com.iba.project.entity.book;

import com.iba.project.entity.person.Person;

import java.math.BigDecimal;

public class Book {
    Person auther = null;
    String name;
    BigDecimal price = null;

    public Book() {
    }

    public Book(Person auther, String name, BigDecimal price) {
        auther = new Person(auther.getName(), auther.getLastName());

        this.name = name;

        this.price = price;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (auther != null ? !auther.equals(book.auther) : book.auther != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return price != null ? price.equals(book.price) : book.price == null;
    }

    @Override
    public int hashCode() {
        int result = auther != null ? auther.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "auther=" + auther +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
