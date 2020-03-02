package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListingDetail;
import model.Realtor;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String path = "/index.jsp";

		if (type.equals("listing")) {
			ListingDetailDAO lDAO = new ListingDetailDAO();
			ListingDetail detail = lDAO.get(id);
			lDAO.delete(detail);
			path = "/view-all.jsp?type=listing";
		} else if (type.equals("realtor")) {
			RealtorDAO rDAO = new RealtorDAO();
			Realtor realtor = rDAO.get(id);
			rDAO.delete(realtor);
			path = "/view-all.jsp?type=realtor";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}