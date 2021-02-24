package com.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PatientDAO;
import com.javaBeans.Patient;

@WebServlet("/EditPatient")
public class EditPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditPatient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
				
		PatientDAO patientDAO = new PatientDAO();
		
		try {
			int id_p = Integer.parseInt(request.getParameter("id"));
			Patient patient = patientDAO.AfficherPation(id_p);
			
			request.setAttribute("id", patient.getId_user());
			request.setAttribute("prenom", patient.getFirstName());
			request.setAttribute("nom", patient.getLastName());
			request.setAttribute("tel", patient.getPhone());
			request.setAttribute("email", patient.getEmail());
			request.setAttribute("date_naiss", patient.getBirthDate());
			request.setAttribute("sex", patient.getSex());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/EditPatient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String date_naiss = request.getParameter("date_naiss");
		String Sex = request.getParameter("Sex");
		
		PatientDAO patientDAO = new PatientDAO();
		try {
			patientDAO.ModifierPation(id, prenom, nom, tel, email, date_naiss, Sex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Patient> patients = null; 
		try {
			patients = patientDAO.ListePatients();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("patients", patients);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("action", "edit");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Table_Patients.jsp").forward(request, response);

	}

}
