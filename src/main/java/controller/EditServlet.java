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

import model.Address;
import model.ListingDetail;
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
			InputStream fileContent = filePart.getInputStream();

			if (fileContent.available() > 0) {
				byte[] picture = IOUtils.toByteArray(fileContent);
				realtor.setPicture(picture);
			}

			realtor.setName(name);
			realtor.setDescription(description);
			rDAO.update(realtor);
			request.getServletContext().getRequestDispatcher("/view-all.jsp?type=realtor").forward(request, response);
			;
		} else if (type.contentEquals("listing")) {

			RealtorDAO rDAO = new RealtorDAO();
			ListingDetailDAO lDAO = new ListingDetailDAO();

			ListingDetail detail = lDAO.get(id);
			Realtor realtor = rDAO.get(Integer.parseInt(request.getParameter("listing_agent")));
			
			detail.getAddress().setHouseNumber(Integer.parseInt(request.getParameter("house_num")));
			detail.getAddress().setStreet(request.getParameter("street"));
			detail.getAddress().setAptSuite(request.getParameter("apt_suite"));
			detail.getAddress().setCity(request.getParameter("city"));
			detail.getAddress().setState(request.getParameter("state"));
			detail.getAddress().setZip(Integer.parseInt(request.getParameter("zip")));

			Part filePart = request.getPart("photo");
			InputStream fileContent = filePart.getInputStream();
			if (fileContent.available() > 0) {
				byte[] picture = IOUtils.toByteArray(fileContent);
				detail.setPhoto(picture);
			}

			String price = request.getParameter("price");
			detail.setPrice(Integer.parseInt(price));
			
			detail.setNumBaths(Float.parseFloat(request.getParameter("num_baths")));
			detail.setNumBedrooms(Float.parseFloat(request.getParameter("num_beds")));
			detail.setRealtor(realtor);
			detail.setDescription(request.getParameter("description"));

			lDAO.update(detail);

			request.getServletContext().getRequestDispatcher("/view-all.jsp?type=listing").forward(request, response);
			;

		}

	}
}
