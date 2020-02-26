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

/**
 * @author jonbos
 *
 */
public class HousePhotoDAO implements DAO<HousePhoto> {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CIS175_MiniProject");

	public void cleanUp() {
		emf.close();
	}

	public HousePhoto get(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		HousePhoto found = em.find(HousePhoto.class, id);
		em.close();
		return found;

	}

	public List<HousePhoto> getAll() {
		EntityManager em = emf.createEntityManager();
		List<HousePhoto> allItems = em.createQuery("SELECT photo FROM HousePhoto photo").getResultList();
		em.close();
		return allItems;
	}

	public void insert(HousePhoto photo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(photo);
		em.getTransaction().commit();
		em.close();
	}

	public void update(HousePhoto photo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(photo);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(HousePhoto photo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HousePhoto> typedQuery = em.createQuery("SELECT photo FROM HousePhoto photo WHERE photo.id = :id",
				HousePhoto.class);
		typedQuery.setParameter("id", photo.getId());
		typedQuery.setMaxResults(1);

		HousePhoto result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

}
