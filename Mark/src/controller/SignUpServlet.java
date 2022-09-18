package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String cpf = request.getParameter("cpf");
		
		String email = request.getParameter("email");
		String keyword = request.getParameter("keyword");
		
		try {
			String message = dao.RegisterDAO.createRegister(fName, lName, birthday, sex, cpf, email, keyword);
			request.setAttribute("message", message);
			if (message == "Account Generated Successfully") {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
				dispatcher.forward (request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp");
			dispatcher.forward (request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}