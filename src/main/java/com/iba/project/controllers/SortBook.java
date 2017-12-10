package com.iba.project.controllers;

import com.iba.project.comparators.book.AuthorsFisrtNameComparator;
import com.iba.project.comparators.book.AuthorsLastNameComparator;
import com.iba.project.comparators.book.BooksNameComparator;
import com.iba.project.comparators.book.BooksPriceComparator;
import com.iba.project.entity.book.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SortBook {
    public static void sort(HttpServletRequest request) {

        String command = request.getParameter("elements");

        List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

        switch (command) {
            case "Author Name":
                books.sort(new AuthorsFisrtNameComparator<>());
                break;

            case "Author LastName":
                books.sort(new AuthorsLastNameComparator<>());
                break;

            case "Name":
                books.sort(new BooksNameComparator<>());
                break;

            case "Price":
                books.sort(new BooksPriceComparator<>());
                break;
        }


    }
}
