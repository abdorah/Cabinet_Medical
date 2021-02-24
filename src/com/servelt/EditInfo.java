package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PatientDAO;
import com.javaBeans.Patient;
import com.javaBeans.User;

@WebServlet("/EditInfo")
public class EditInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PatientDAO patientDAO = new PatientDAO();
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
	        
		try {
	        
			int id_p = user.getId_user();
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/EditInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
