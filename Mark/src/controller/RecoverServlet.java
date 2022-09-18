package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RecoverServlet")
public class RecoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RecoverServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String email = request.getParameter("email");
		String keyword = request.getParameter("keyword");
		try {
			String message = dao.RegisterDAO.updateRegister(keyword, email);
			request.setAttribute("message", message);
			if (message == null) {
				request.getSession().setAttribute("stats", true);
				response.sendRedirect("Login");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Recover");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}