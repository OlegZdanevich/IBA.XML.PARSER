package com.iba.project.servlets;

import com.iba.project.controllers.DeleteBook;
import com.iba.project.controllers.UpdateBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeElementsServlet", urlPatterns = {"/changeElement"})
public class ChangeElementsServlet extends HttpServlet {
    private final static long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {

            case "Delete":
                DeleteBook.deleteElement(request, response);
                request.getRequestDispatcher("WEB-INF/views/view.jsp").forward(request, response);
                break;

            case "Edit":
                UpdateBook.prepareToUpdateElement(request);
                request.getRequestDispatcher("WEB-INF/views/edit.jsp").forward(request, response);
                break;


            case "Create":
                UpdateBook.prepareToCreate(request);
                request.getRequestDispatcher("WEB-INF/views/edit.jsp").forward(request, response);
                break;

            case "Update":
                boolean allSucsess=UpdateBook.addElement(request);
                if(allSucsess)
                {
                    request.getRequestDispatcher("WEB-INF/views/view.jsp").forward(request, response);
                }
                else {
                    request.setAttribute("answer",-1);
                    request.getRequestDispatcher("WEB-INF/views/view.jsp").forward(request, response);
                }

                break;


            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;


        }
    }


}