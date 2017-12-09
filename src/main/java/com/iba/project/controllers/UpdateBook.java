package com.iba.project.controllers;

import com.iba.project.entity.book.Book;
import com.iba.project.entity.person.Person;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public class UpdateBook {

    private static final Logger log = Logger.getLogger(UpdateBook.class);

    public static void prepareToUpdateElement(HttpServletRequest request) {

        int idOfElement = Integer.parseInt(request.getParameter("id"));


        List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

        setAttributes(request, idOfElement, books.get(idOfElement));


    }

    public static void prepareToCreate(HttpServletRequest request) {
        int idOfElement = -1;
        Book emptyBook = new Book(new Person("", ""), "", new BigDecimal("0"));

        setAttributes(request, idOfElement, emptyBook);
    }


    public static boolean addElement(HttpServletRequest request) {
        boolean allSucsess=true;

        try {
            String authorName = request.getParameter("inputNameAuthor");
            String authorLastName = request.getParameter("inputLastNameAuthor");

            String name = request.getParameter("inputNameOfBook");
            BigDecimal price = new BigDecimal(request.getParameter("inputPriceOfBook"));
            if (price.intValue() < 0) throw new IllegalArgumentException();

            int idOfElement = (int) request.getSession().getAttribute("id");
            List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

            Book newBook = new Book(new Person(authorName, authorLastName), name, price);

            if (idOfElement >= 0) {
                books.remove(idOfElement);
            }


            books.add(newBook);


        } catch (NumberFormatException exception) {
            log.trace("Not a number id", exception);
            allSucsess=false;
        } catch (IllegalArgumentException exception) {
            log.trace("Id should be greater then zero", exception);
            allSucsess=false;
        }
        finally {
            request.getSession().removeAttribute("id");
            request.getSession().removeAttribute("book");
            return allSucsess;
        }


    }

    private static void setAttributes(HttpServletRequest request, int id, Book book) {
        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("book", book);
    }
}
