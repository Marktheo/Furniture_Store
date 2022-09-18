package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileServlet() {
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
		String button = request.getParameter("button");
		
		if (button.equals("Update")){
			try {
				String message = dao.IdentityDAO.updateIdentity(fName, lName, birthday, sex, cpf, email);
				if(message != null) {
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Profile");
					dispatcher.forward(request, response);
				} else {
					message = "Account Updated Successfully";
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
					dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				String message = dao.IdentityDAO.deleteIdentity(fName, lName, birthday, sex, cpf, email);
				if(message != null) {
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Profile");
					dispatcher.forward(request, response);
				} else {
					message = "Account Deleted Successfully";
					request.setAttribute("message", message);
					request.getSession().setAttribute("stats", false);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
					dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
