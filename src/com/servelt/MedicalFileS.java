package com.servelt;

import java.io.IOException;


import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AppointmentDAO;
import com.DAO.MedicalFileDAO;
import com.javaBeans.MedicalFile;


@WebServlet("/MedicalFile")
public class MedicalFileS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MedicalFileS() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_patient = Integer.parseInt(request.getParameter("id"));
		MedicalFileDAO medicalFileDao = new MedicalFileDAO();
		
		try {
			MedicalFile medicalFile = medicalFileDao.getMedicalFileById(id_patient);
			
			request.setAttribute("medicalFile",medicalFile);
			this.getServletContext().getRequestDispatcher("/WEB-INF/medicalFile.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_appointment = Integer.parseInt(request.getParameter("id"));
		
		AppointmentDAO appointmentDao = new AppointmentDAO();
		
		try {
			boolean isDelete = appointmentDao.deleteAppointmentById(id_appointment);
			doGet(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
