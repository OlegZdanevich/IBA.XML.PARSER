package com.iba.project.controllers;

import com.iba.project.entity.book.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteBook {

    public static void deleteElement(HttpServletRequest request) {

        int idOfElement = Integer.parseInt(request.getParameter("id"));

        List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

        books.remove(idOfElement);


    }
}
