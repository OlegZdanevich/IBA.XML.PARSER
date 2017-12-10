package com.iba.project.servlets;

import com.iba.project.entity.book.Book;
import com.iba.project.xml.parser.ParserXML;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private final static long serialVersionUID = 3L;
    private static final Logger log = Logger.getLogger(UploadServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part file = request.getPart("file");

        if (file.getContentType().equals("text/xml")) {
            try (InputStream fileStream = file.getInputStream()) {

                List<Book> books = ParserXML.parse(fileStream);

                request.getSession().setAttribute("xmlTable", books);

                request.getRequestDispatcher("WEB-INF/views/view.jsp").forward(request, response);

            } catch (Exception exception) {
                log.trace("Cannot download file to server", exception);

                request.setAttribute("status", -2);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }



        } else {
            log.warn("Try to download incorrect file");

            request.setAttribute("status", -1);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }


    }


}