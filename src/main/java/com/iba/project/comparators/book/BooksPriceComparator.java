package com.iba.project.comparators.book;

import com.iba.project.entity.book.Book;

import java.util.Comparator;

public class BooksPriceComparator<T extends Book> implements Comparator<T> {


    public int compare(T e1, T e2)
    {
        if(e1.getPrice().compareTo(e2.getPrice())>0 ){
            return 1;
        } else {
            return -1;
        }

    }
}
