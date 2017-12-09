package com.iba.project.entity.book;

import com.iba.project.entity.person.Person;

import java.math.BigDecimal;

public class Book {
    Person author = null;
    String name;
    BigDecimal price = null;

    public Book() {
    }

    public Book(Person author, String name, BigDecimal price) {
        this.author = new Person(author.getName(), author.getLastName());

        this.name = name;

        this.price = price;

    }

    public String getName() {
        return name;
    }

    public Person getAuther() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuther(Person auther) {
        this.author = auther;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return price != null ? price.equals(book.price) : book.price == null;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "auther=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
