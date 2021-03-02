package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AppointmentDAO;
import com.DAO.PatientDAO;
import com.javaBeans.Appointment;
import com.javaBeans.Patient;
import com.javaBeans.User;

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

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        int result = 0 ;
        try {
			result = appointmentDao.getAppointmentByDate(date);;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(result == 0) {

	        try {
	            Patient patient = patientDao.getPatientById(user.getId_user());
	            Appointment appointment = new Appointment(date, description, typeofIllness, false, patient);
	            
	            appointmentDao.takeAppointment(appointment);
	            
	        } catch (SQLException e2) {
	            e2.printStackTrace();
	        }
	        
	        request.setAttribute("action", "effectue");
	        this.getServletContext().getRequestDispatcher("/WEB-INF/home_patient.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("action", "refuse");
        	request.setAttribute("type", typeofIllness);
        	request.setAttribute("desc", description);
	        doGet(request,response);
        }
    }
    
}