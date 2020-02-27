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
 * Servlet implementation class AddServlet
 */
@WebServlet("/addServlet")
@MultipartConfig
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");

		if (type.equals("realtor")) {
			RealtorDAO realtorDAO = new RealtorDAO();
			Realtor r = new Realtor();
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			Part filePart = request.getPart("photo");
			InputStream fileContent = filePart.getInputStream();
			byte[] picture = IOUtils.toByteArray(fileContent);
			r.setDescription(description);
			r.setName(name);
			r.setPicture(picture);
			
			realtorDAO.insert(r);
			
			request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
