package com.iba.project.comparators.book;

import com.iba.project.entity.book.Book;

import java.util.Comparator;

public class AuthorsLastNameComparator<T extends Book> implements Comparator<T> {
    public int compare(T e1, T e2)
    {
        if(e1.getAuther().getLastName().compareTo(e2.getAuther().getLastName())>0 ){
            return 1;
        } else {
            return -1;
        }

    }
}
