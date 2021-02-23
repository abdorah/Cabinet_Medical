package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MedicalFileDAO;
import com.javaBeans.MedicalFile;
import com.javaBeans.User;

@WebServlet("/Info_patient")
public class Info_patient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Info_patient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
		int id_patient = user.getId_user();
		MedicalFileDAO medicalFileDao = new MedicalFileDAO();
		
		try {
			MedicalFile medicalFile = medicalFileDao.getMedicalFileById(id_patient);
			
			request.setAttribute("medicalFile",medicalFile);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Info_patient.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
