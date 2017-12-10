package com.iba.project.comparators.book;

import com.iba.project.entity.book.Book;

import java.util.Comparator;

public class BooksNameComparator <T extends Book> implements Comparator<T> {

    public int compare(T e1, T e2)
    {
        if(e1.getName().compareTo(e2.getName())>0 ){
            return 1;
        } else {
            return -1;
        }

    }
}
