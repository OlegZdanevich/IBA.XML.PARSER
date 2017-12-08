package com.iba.project.servlets;

import com.iba.project.entity.book.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChangeElementsServlet", urlPatterns = {"/changeElement"})
public class ChangeElementsServlet extends HttpServlet {
    private final static long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");

        if(action.equals("Delete"))
        {
            deleteElement(request,response);
        }


        request.getRequestDispatcher("WEB-INF/views/view.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void deleteElement(HttpServletRequest request, HttpServletResponse response)
    {
        int idOfElement= Integer.parseInt(request.getParameter("id"));

        List<Book> books= (List<Book>) request.getSession().getAttribute("xmlTable");

        books.remove(idOfElement);
    }

}