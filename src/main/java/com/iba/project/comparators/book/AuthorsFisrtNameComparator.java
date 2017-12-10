package com.iba.project.comparators.book;

import com.iba.project.entity.book.Book;

import java.util.Comparator;

public class AuthorsFisrtNameComparator <T extends Book> implements Comparator<T> {
    public int compare(T e1, T e2)
    {
        if(e1.getAuther().getName().compareTo(e2.getAuther().getName())>0 ){
            return 1;
        } else {
            return -1;
        }

    }
}
