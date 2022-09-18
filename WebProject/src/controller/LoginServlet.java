package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Identity;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String email = request.getParameter("email");
		String keyword = request.getParameter("keyword");
		try {
			Identity identity = dao.RegisterDAO.readRegister(email, keyword);
			request.setAttribute("message", identity.getState());
			if (identity.getState().equals("Account Logged Successfully")) {
				request.getSession().setAttribute("stats", true);
				request.getSession().setAttribute("fName", identity.getfName());
				request.getSession().setAttribute("lName", identity.getlName());
				request.getSession().setAttribute("bDate", identity.getbDate());
				request.getSession().setAttribute("sex", identity.getSex());
				request.getSession().setAttribute("cpf", identity.getCpf());
				request.getSession().setAttribute("email", email);
				response.sendRedirect("Home");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}