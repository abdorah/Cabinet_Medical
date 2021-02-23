package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AppointmentDAO;
import com.DAO.PatientDAO;
import com.javaBeans.Appointment;
import com.javaBeans.Patient;

@WebServlet("/Appointments")
public class Appointments extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Appointments() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/New-Appointment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        AppointmentDAO appointmentDao = new AppointmentDAO();
        PatientDAO patientDao = new PatientDAO();

        String datetime = request.getParameter("datetime");
        String[] strDate = datetime.split("T");
        String date = strDate[0]+' '+strDate[1]+":00";

        String description = request.getParameter("description");
        String typeofIllness = request.getParameter("treatment");

        //Patient patient = new Patient();

        try {
            Patient patient = patientDao.getPatientById(1);// getPatientById(((User)request.getSession().getAttribute("email")).getId());
            Appointment appointment = new Appointment(date, description, typeofIllness, false, patient);
            if(appointmentDao.takeAppointment(appointment)!=0) {
                appointment.setId_appointment(appointmentDao.takeAppointment(appointment));
            }
            doGet(request,response);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
