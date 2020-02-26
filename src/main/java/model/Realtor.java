package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the realtor database table.
 * 
 */
@Entity
@NamedQuery(name="Realtor.findAll", query="SELECT r FROM Realtor r")
public class Realtor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="name")
	private String name;

	@Column(name="picture_url")
	private String pictureUrl;

	//bi-directional many-to-one association to ListingDetail
	@OneToMany(mappedBy="realtor")
	private List<ListingDetail> listingDetails;

	public Realtor() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public List<ListingDetail> getListingDetails() {
		return this.listingDetails;
	}

	public void setListingDetails(List<ListingDetail> listingDetails) {
		this.listingDetails = listingDetails;
	}

	public ListingDetail addListingDetail(ListingDetail listingDetail) {
		getListingDetails().add(listingDetail);
		listingDetail.setRealtor(this);

		return listingDetail;
	}

	public ListingDetail removeListingDetail(ListingDetail listingDetail) {
		getListingDetails().remove(listingDetail);
		listingDetail.setRealtor(null);

		return listingDetail;
	}

}