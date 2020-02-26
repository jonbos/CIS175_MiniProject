package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the house_photos database table.
 * 
 */
@Entity
@Table(name="house_photos")
@NamedQuery(name="HousePhoto.findAll", query="SELECT h FROM HousePhoto h")
public class HousePhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="is_default")
	private byte isDefault;

	@Lob
	private byte[] photo;

	//bi-directional many-to-one association to ListingDetail
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="listing_id")
	private ListingDetail listingDetail;

	public HousePhoto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(byte isDefault) {
		this.isDefault = isDefault;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public ListingDetail getListingDetail() {
		return this.listingDetail;
	}

	public void setListingDetail(ListingDetail listingDetail) {
		this.listingDetail = listingDetail;
	}

}