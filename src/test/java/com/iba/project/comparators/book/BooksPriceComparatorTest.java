package com.iba.project.comparators.book;

import com.iba.project.entity.book.Book;
import com.iba.project.entity.person.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class BooksPriceComparatorTest {
    Book book1=null;
    Book book2=null;

    BigDecimal element1 = null;
    BigDecimal element2 = null;

    BooksPriceComparator comparator = null;

    @Before
    public void setUp() {
        element1 = new BigDecimal("-3");
        element2 = new BigDecimal("100");

        comparator = new BooksPriceComparator();

        book1=new Book(new Person("OLEG","Zdanevich"),"blabla",element1);
        book2=new Book(new Person("OLEG","Zdanevich"),"blabla",element2);
    }

    @After
    public void tearDown() {
        element1 = null;
        element2 = null;

        comparator = null;

        book1=null;
        book2=null;
    }

    @Test
    public void compare() {
        assertTrue(comparator.compare(book1, book2) == -1);
        assertTrue(comparator.compare(book2, book1) == 1);
    }
}