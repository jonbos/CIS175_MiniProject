/**
 * 
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;
import model.HousePhoto;
import model.ListingDetail;

/**
 * @author jonbos
 *
 */
public class ListingDetailDAO implements DAO<ListingDetail> {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CIS175_MiniProject");

	public void cleanUp() {
		emf.close();
	}

	public ListingDetail get(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ListingDetail found = em.find(ListingDetail.class, id);
		em.close();
		return found;

	}

	public List<ListingDetail> getAll() {
		EntityManager em = emf.createEntityManager();
		List<ListingDetail> allItems = em.createQuery("SELECT listing_detail FROM ListingDetail listing_detail").getResultList();
		em.close();
		return allItems;
	}

	public void insert(ListingDetail detail) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(detail);
		em.getTransaction().commit();
		em.close();
	}

	public void update(ListingDetail detail) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(detail);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(ListingDetail detail) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListingDetail> typedQuery = em.createQuery("SELECT listing_detail FROM ListingDetail listing_detail WHERE listing_detail.id = :id",
				ListingDetail.class);
		typedQuery.setParameter("id", detail.getId());
		typedQuery.setMaxResults(1);

		ListingDetail result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

}
