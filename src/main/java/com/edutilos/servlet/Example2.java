package com.edutilos.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by edutilos on 17.06.17.
 */
public class Example2 extends HttpServlet {
    private long id;
    private String name;
    private int age;
    private double wage;
    private boolean active;

    @Override
    public void init() throws ServletException {
        id = 1L ;
        name = "foobar";
        age = 10 ;
        wage = 100.0D ;
        active = true;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>").append("GET Request").append("</h1>")
                .append("<table><tr><td>Key</td><td>Value</td></tr>")
                .append("<tr><td>Id</td><td>").append(id).append("</td></tr>")
                .append("<tr><td>Name</td><td>").append(name).append("</td></tr>")
                .append("<tr><td>Age</td><td>").append(age).append("</td></tr>")
                .append("<tr><td>Wage</td><td>").append(wage).append("</td></tr>")
                .append("<tr><td>Active</td><td>").append(active).append("</td></tr>")
                .append("</table>");

        resp.setContentType("text/html");
        resp.getWriter().println(sb.toString());

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>").append("POST Request").append("</h1>")
                .append("<table><tr><td>Key</td><td>Value</td></tr>")
                .append("<tr><td>Id</td><td>").append(id).append("</td></tr>")
                .append("<tr><td>Name</td><td>").append(name).append("</td></tr>")
                .append("<tr><td>Age</td><td>").append(age).append("</td></tr>")
                .append("<tr><td>Wage</td><td>").append(wage).append("</td></tr>")
                .append("<tr><td>Active</td><td>").append(active).append("</td></tr>")
                .append("</table>");

        resp.setContentType("text/html");
        resp.getWriter().println(sb.toString());

    }


    @Override
    public void destroy() {

    }
}
