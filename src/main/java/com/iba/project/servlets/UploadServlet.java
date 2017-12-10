package com.iba.project.servlets;

import com.iba.project.entity.book.Book;
import com.iba.project.xml.parser.ParserXML;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private final static long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part file = request.getPart("file");

        if (file.getContentType().equals("text/xml")){
            try (InputStream fileStream = file.getInputStream()) {

                List<Book> books = ParserXML.parse(fileStream);

                request.getSession().setAttribute("xmlTable", books);

            } catch (Exception e) {

                request.getSession().setAttribute("xmlTable", new ArrayList<>());
                //ToDo log
            }


            request.getRequestDispatcher("WEB-INF/views/view.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("status",-1);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }


    }




}