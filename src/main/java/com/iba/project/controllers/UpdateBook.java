package com.iba.project.controllers;

import com.iba.project.entity.book.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UpdateBook {

    public static void prepareToUpdateElement(HttpServletRequest request, HttpServletResponse response)
    {
        int idOfElement= Integer.parseInt(request.getParameter("id"));

        List<Book> books= (List<Book>) request.getSession().getAttribute("xmlTable");

        request.getSession().setAttribute("id",idOfElement);
        request.getSession().setAttribute("book", books.get(idOfElement));
    }

    public static void updateElement(HttpServletRequest request,HttpServletResponse response)
    {

    }
}
