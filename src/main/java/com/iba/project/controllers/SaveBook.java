package com.iba.project.controllers;

import com.iba.project.entity.book.Book;
import com.iba.project.xml.creater.CreateXML;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class SaveBook {

    private static final Logger log = Logger.getLogger(SaveBook.class);

    public static boolean saveBook(HttpServletRequest request, HttpServletResponse response) {

        String newName = (String) request.getParameter("filename");


        List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

        String data = CreateXML.createStreamWriter(books);

        boolean result=true;


        try (OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("text/xml");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + newName + "\"");

            if (data==null) throw new NullPointerException();
            outputStream.write(data.getBytes());
            outputStream.flush();

        }
        catch (NullPointerException exception)
        {
            log.trace("Try to download null",exception);

            result=false;
        }
        catch (IOException exception) {
            log.trace("Cannot create file to download", exception);

            result=false;
        }

        return result;
    }
}