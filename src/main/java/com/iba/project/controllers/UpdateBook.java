package com.iba.project.controllers;

import com.iba.project.entity.book.Book;
import com.iba.project.entity.person.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public class UpdateBook {

    public static void prepareToUpdateElement(HttpServletRequest request, HttpServletResponse response) {
        int idOfElement = Integer.parseInt(request.getParameter("id"));

        List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

        setAttributes(request,idOfElement,books.get(idOfElement));
    }

    public static void prepareToCreate(HttpServletRequest request,HttpServletResponse response)
    {
        int idOfElement=-1;
        Book emptyBook=new Book(new Person("",""),"",new BigDecimal("0"));

        setAttributes(request,idOfElement,emptyBook);
    }


    public static void addElement(HttpServletRequest request, HttpServletResponse response) {
        String authorName = request.getParameter("inputNameAuthor");
        String authorLastName = request.getParameter("inputLastNameAuthor");

        String name = request.getParameter("inputNameOfBook");
        BigDecimal price = new BigDecimal(request.getParameter("inputPriceOfBook"));

        int idOfElement = (int) request.getSession().getAttribute("id");
        List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

        Book newBook = new Book(new Person(authorName, authorLastName), name, price);

        if (idOfElement >= 0) {
            books.remove(idOfElement);
        }


        books.add(newBook);

        request.getSession().removeAttribute("id");
        request.getSession().removeAttribute("book");


    }

    private static void setAttributes(HttpServletRequest request,int id,Book book)
    {
        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("book", book);
    }
}
