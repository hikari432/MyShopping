package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;

@WebServlet("/CategoryListServlet")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    CategoryDAO dao = new CategoryDAO();

	    List<Category> categories = dao.findAll();

	    request.setAttribute("categories", categories);
	    
	    RequestDispatcher dispatcher =
	            request.getRequestDispatcher("/category.jsp");

	    dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
