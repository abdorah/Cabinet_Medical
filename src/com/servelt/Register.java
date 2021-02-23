package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

//import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaBeans.User;
import com.DAO.UserDAO;


/**
 * Servlet implementation class Register
 */
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
		String fristName=request.getParameter("fristName");

		String lastName=request.getParameter("lastName");

		String phone=request.getParameter("phone");

		String email=request.getParameter("email");

		String password=request.getParameter("password");

		User user=new User(0, fristName, lastName, phone, email, password);

		UserDAO registerDao = new UserDAO();


		try {
			boolean isExist = registerDao.isExist(user.getEmail());
			if(isExist) {
				String message = "cette email est deja utiliser . essayer avec un autre";
				request.setAttribute("message", message);
				this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

			}
			else {
				registerDao.register(user);
				HttpSession session = request.getSession();
				session.setAttribute("user", user.getEmail());


				this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}