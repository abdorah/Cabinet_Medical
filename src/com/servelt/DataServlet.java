package com.servelt;

import com.DAO.DoctorDAO;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javaBeans.HomeData;


@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DataServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        DoctorDAO doctorDAO = new DoctorDAO();
        HomeData homeData = doctorDAO.getData();

//        List<User> listOfStudent = new ArrayList<User>();
        String jsonString = gson.toJson(homeData);

        response.setContentType("application/json");

        response.getWriter().write(jsonString);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
