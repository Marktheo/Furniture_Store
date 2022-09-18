package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String description = null;
		String product = null;
		String button = request.getParameter("button");
		
		if(button.equals("Add to Cart - Chair")) {
			try {
				product = "Chair";
				description = dao.ProductDAO.readProduct(product);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (button.equals("Add to Cart - Table")) {
			try {
				product = "Table";
				description = dao.ProductDAO.readProduct(product);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (button.equals("Add to Cart - Bench")) {
			try {
				product = "Bench";
				description = dao.ProductDAO.readProduct(product);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (button.equals("Add to Cart - Chandeliers")) {
			try {
				product = "Chandeliers";
				description = dao.ProductDAO.readProduct(product);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (button.equals("Add to Cart - Sofa")) {
			try {
				product = "Sofa";
				description = dao.ProductDAO.readProduct(product);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				product = "Cabinet";
				description = dao.ProductDAO.readProduct(product);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		request.getSession().setAttribute("product", description);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cart");
		dispatcher.forward(request, response);
	}
}
