package com.edutilos.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by edutilos on 17.06.17.
 */
public class Example3PostParams extends HttpServlet {
    private static final String newline = "<br/>";
    @Override
    public void init() throws ServletException {
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            double wage = Double.parseDouble(req.getParameter("wage"));
            boolean active = Boolean.parseBoolean(req.getParameter("active"));
            StringBuilder sb = new StringBuilder();
            sb.append("<h2>POST Request</h2>")
                    .append("Id = ").append(id).append(newline)
                    .append("Name = ").append(name).append(newline)
                    .append("Age = ").append(age).append(newline)
                    .append("Wage = ").append(wage).append(newline)
                    .append("Active = ").append(active).append(newline);

            out.println(sb.toString());
        } catch(Exception ex) {
            out.println(ex.getMessage());
        }
    }

    @Override
    public void destroy() {
    }
}
