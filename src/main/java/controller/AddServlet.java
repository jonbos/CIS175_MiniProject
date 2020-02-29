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
		String path = "/index.jsp";

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
		} else if (type.equals("listing")) {
			ListingDetailDAO listingDAO = new ListingDetailDAO();
			ListingDetail ld = new ListingDetail();

			int houseNum = Integer.parseInt(request.getParameter("house_num"));
			String aptSuite = request.getParameter("apt_suite");
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int zip = Integer.parseInt(request.getParameter("zip"));
			Address addr = new Address();
			addr.setHouseNumber(houseNum);
			addr.setStreet(street);
			addr.setAptSuite(aptSuite);
			addr.setCity(city);
			addr.setState(state);
			addr.setZip(zip);

			int askingPrice = Integer.parseInt(request.getParameter("price"));
			float numBedrooms = Float.parseFloat(request.getParameter("num_beds"));
			float numBaths = Float.parseFloat(request.getParameter("num_baths"));
			int realtorId = Integer.parseInt(request.getParameter("listing_agent"));
			String description = request.getParameter("description");
			
			Part filePart = request.getPart("photo");
			InputStream fileContent = filePart.getInputStream();
			byte[] picture = IOUtils.toByteArray(fileContent);
			
			ld.setPhoto(picture);

			RealtorDAO realtorDAO = new RealtorDAO();
			Realtor r = realtorDAO.get(realtorId);

			ld.setAddress(addr);
			ld.setPrice(askingPrice);
			ld.setNumBaths(numBaths);
			ld.setNumBedrooms(numBedrooms);
			ld.setRealtor(r);
			ld.setDescription(description);
			listingDAO.insert(ld);

		}
		request.getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
