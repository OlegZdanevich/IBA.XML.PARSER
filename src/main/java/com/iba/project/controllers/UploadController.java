package com.iba.project.controllers;

import com.iba.project.parser.ParserXML;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet(name = "UploadController",urlPatterns = {"/upload"})
@MultipartConfig
public class UploadController extends HttpServlet {
    private final static long serialVersionUID=3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Part file=request.getPart("file");



        try(InputStream fileStream=file.getInputStream()) {

            ParserXML.parse(fileStream);

        } catch (Exception e) {
            //ToDo log
        }

        request.getRequestDispatcher("WEB-INF/views/view.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }

}