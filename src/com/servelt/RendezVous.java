package com.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AppointmentDAO;
import com.javaBeans.Appointment;

@WebServlet("/RendezVous")
public class RendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RendezVous() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String type = request.getParameter("type");
		AppointmentDAO appointmentDAO = new AppointmentDAO();		
		
		if(type.equals("A")) {
			try {				
				ArrayList<Appointment> appointments = appointmentDAO.ListeAppointmentNF();
				
				request.setAttribute("appointments", appointments);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/ListeRenderVous.jsp").forward(request, response);
		}
		else if(type.equals("N")) {
			try {
				appointmentDAO.Updatenotification();
				ArrayList<Appointment> appointments = appointmentDAO.ListeAppointmentNF();
				
				request.setAttribute("appointments", appointments);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/ListeRenderVous.jsp").forward(request, response);
		} 
		else if(type.equals("H")) {
			try {
				ArrayList<Appointment> appointments = appointmentDAO.ListeAppointmentF();
				
				request.setAttribute("appointments", appointments);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/H_RendezVous.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppointmentDAO appointmentDAO = new AppointmentDAO();
		
		int id_A = Integer.parseInt(request.getParameter("id"));
		
		try {
			appointmentDAO.deleteAppointmentById(id_A);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id_A", id_A);
		request.setAttribute("action", "supprimer");
		doGet(request, response);
	}

}
