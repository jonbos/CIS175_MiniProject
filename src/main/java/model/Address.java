package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "apt_suite")
	private String aptSuite;

	@Column(name = "city")
	private String city;

	@Column(name = "house_number")
	private int houseNumber;

	@Column(name = "state")
	private String state;

	@Column(name = "street")
	private String street;

	@Column(name = "zip")
	private int zip;

	// bi-directional many-to-one association to ListingDetail
	@OneToMany(mappedBy = "address")
	private List<ListingDetail> listingDetails;

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAptSuite() {
		return this.aptSuite;
	}

	public void setAptSuite(String aptSuite) {
		this.aptSuite = aptSuite;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public List<ListingDetail> getListingDetails() {
		return this.listingDetails;
	}

	public void setListingDetails(List<ListingDetail> listingDetails) {
		this.listingDetails = listingDetails;
	}

	public ListingDetail addListingDetail(ListingDetail listingDetail) {
		getListingDetails().add(listingDetail);
		listingDetail.setAddress(this);

		return listingDetail;
	}

	public ListingDetail removeListingDetail(ListingDetail listingDetail) {
		getListingDetails().remove(listingDetail);
		listingDetail.setAddress(null);

		return listingDetail;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", aptSuite=" + aptSuite + ", city=" + city + ", houseNumber=" + houseNumber
				+ ", state=" + state + ", street=" + street + ", zip=" + zip + ", listingDetails=" + listingDetails
				+ "]";
	}
	
	public String getHouseNumberAndStreet() {
		return this.houseNumber + " " + this.street;
	}
	
	
}