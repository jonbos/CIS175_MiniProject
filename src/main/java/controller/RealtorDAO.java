package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Realtor;

public class RealtorDAO implements DAO<Realtor> {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CIS175_MiniProject");

	public void cleanUp() {
		emf.close();
	}

	public Realtor get(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Realtor found = em.find(Realtor.class, id);
		em.close();
		return found;
	}

	public List<Realtor> getAll() {
		EntityManager em = emf.createEntityManager();
		List<Realtor> allItems = em.createQuery("SELECT Realtor FROM Realtor Realtor").getResultList();
		em.close();
		return allItems;
	}

	public void insert(Realtor realtor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(realtor);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Realtor realtor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(realtor);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Realtor realtor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Realtor> typedQuery = em.createQuery("SELECT realtor FROM Realtor realtor WHERE realtor.id = :id",
				Realtor.class);
		typedQuery.setParameter("id", realtor.getId());
		typedQuery.setMaxResults(1);

		Realtor result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
