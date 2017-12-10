package com.iba.project.controllers;

import com.iba.project.entity.book.Book;
import com.iba.project.xml.creater.CreateXML;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;

public class SaveBook {

    public static void saveBook(HttpServletRequest request,HttpServletResponse response) {

        String newName= (String) request.getParameter("filename");


        List<Book> books = (List<Book>) request.getSession().getAttribute("xmlTable");

        String data= CreateXML.createStreamWriter(books);

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\""+newName+"\"");

        try ( OutputStream outputStream = response.getOutputStream();){

            outputStream.write(data.getBytes());
            outputStream.flush();

        }
        catch (IOException exception)
        {
            //to do
        }

    }
}