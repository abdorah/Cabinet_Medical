package com.servelt;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Appointments")
public class Appointments extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Appointments() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/New-Appointment.jsp").forward(request, response);
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* AppointmentDAO appointmentDao = new AppointmentDAO();
        Appointment appointment = null;

        String timeofAppointment;
        String dateofAppointment;
        timeofAppointment = request.getParameter("time");
        dateofAppointment = request.getParameter("date");
        Date date = null;
        try {
            date = (Date) new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(dateofAppointment+" "+timeofAppointment);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }

        String reason = request.getParameter("description");
        String typeofIllness = request.getParameter("state");
        int patient = ((User)request.getSession().getAttribute("currentUser")).getId();
        boolean notification = false;

        appointment.setDateofAppointment(date);
        appointment.setReason(reason);
        appointment.setTypeofIllness(typeofIllness);
        appointment.setPatient(patient);
        appointment.setNotification(notification);
        try {
            appointmentDao.takeAppointment(appointment);
            this.getServletContext().getRequestDispatcher("/WEB-INF/New-Appointment.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
