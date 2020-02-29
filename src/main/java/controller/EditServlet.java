package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import model.Realtor;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/editServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));

		if (type.equals("realtor")) {
			RealtorDAO rDAO = new RealtorDAO();
			Realtor realtor = rDAO.get(id);

			String name = request.getParameter("name");
			String description = request.getParameter("description");

			Part filePart = request.getPart("photo");

			if (!(filePart == null)) {
				InputStream fileContent = filePart.getInputStream();
				byte[] picture = IOUtils.toByteArray(fileContent);
				realtor.setPicture(picture);
			}

			realtor.setName(name);
			realtor.setDescription(description);
			rDAO.update(realtor);
			request.getServletContext().getRequestDispatcher("/view-all.jsp?type=realtor");
		}
	}
}
