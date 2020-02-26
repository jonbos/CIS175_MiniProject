import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import controller.AddressDAO;
import controller.HousePhotoDAO;
import controller.ListingDetailDAO;
import model.Address;
import model.HousePhoto;
import model.ListingDetail;

public class ListingTester {

	public static void main(String[] args) throws IOException {
		BufferedImage bImage = ImageIO.read(new File("sample.jpeg"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos);
		byte[] data = bos.toByteArray();

		ListingDetail ld = new ListingDetail();
		ListingDetailDAO lDAO = new ListingDetailDAO();
		
		HousePhotoDAO photoDAO = new HousePhotoDAO();
		HousePhoto p = new HousePhoto();
		p.setPhoto(data);
		photoDAO.insert(p);
	}
}
