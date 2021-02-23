package com.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.javaBeans.Patient;
import com.javaBeans.User;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Register() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cin = request.getParameter("cin");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		String sex = request.getParameter("sex");
		String birthDate = request.getParameter("birthdate");
		
		if(password.equals(confPassword)) {
			
			Patient patient = new Patient();
			
			patient.setEmail(email);
			patient.setFirstName(firstName);
			patient.setLastName(lastName);
			patient.setPhone(phone);
			patient.setCin(cin);
			patient.setPassword(password);
			patient.setSex(sex);
			patient.setBirthDate(birthDate);
			
			UserDAO userDAO = new UserDAO();
		
			try {
				boolean isExist = userDAO.isExist(email,cin);	
				if(isExist) {
					String message = "cet email est déjà utilisé.Essayer un autre";
	                request.setAttribute("message", message);
	                this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
					
				}
				else {
					userDAO.register(patient);
	                this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else {
			String message = "Mot de passe non confirmé!";
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		
		
	}

}
