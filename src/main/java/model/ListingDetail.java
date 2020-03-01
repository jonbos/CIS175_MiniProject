package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the listing_detail database table.
 * 
 */
@Entity
@Table(name="listing_detail")
@NamedQuery(name="ListingDetail.findAll", query="SELECT l FROM ListingDetail l")
public class ListingDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name="num_baths")
	private float numBaths;

	@Column(name="num_bedrooms")
	private float numBedrooms;

	@Lob
	private byte[] photo;

	private int price;

	//bi-directional many-to-one association to Address
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="adress_id")
	private Address address;

	//bi-directional many-to-one association to Realtor
	@ManyToOne
	private Realtor realtor;

	public ListingDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getNumBaths() {
		return this.numBaths;
	}

	public void setNumBaths(float numBaths) {
		this.numBaths = numBaths;
	}

	public float getNumBedrooms() {
		return this.numBedrooms;
	}

	public void setNumBedrooms(float numBedrooms) {
		this.numBedrooms = numBedrooms;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Realtor getRealtor() {
		return this.realtor;
	}

	public void setRealtor(Realtor realtor) {
		this.realtor = realtor;
	}

}