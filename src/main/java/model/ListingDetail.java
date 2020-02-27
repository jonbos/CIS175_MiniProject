package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	
	@Column(name="description")
	private String description;

	@Column(name="num_baths")
	private float numBaths;

	@Column(name="num_bedrooms")
	private float numBedrooms;
	
	@Column(name="price")
	private int price;

	//bi-directional many-to-one association to HousePhoto
	@OneToMany(mappedBy="listingDetail", cascade={CascadeType.ALL})
	private List<HousePhoto> housePhotos;

	//bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
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

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<HousePhoto> getHousePhotos() {
		return this.housePhotos;
	}

	public void setHousePhotos(List<HousePhoto> housePhotos) {
		this.housePhotos = housePhotos;
	}

	public HousePhoto addHousePhoto(HousePhoto housePhoto) {
		getHousePhotos().add(housePhoto);
		housePhoto.setListingDetail(this);

		return housePhoto;
	}

	public HousePhoto removeHousePhoto(HousePhoto housePhoto) {
		getHousePhotos().remove(housePhoto);
		housePhoto.setListingDetail(null);

		return housePhoto;
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