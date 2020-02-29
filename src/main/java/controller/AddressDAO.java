package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;

public class AddressDAO implements DAO<Address> {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CIS175_MiniProject");

	public void cleanUp() {
		emf.close();
	}

	public Address get(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, id);
		em.close();
		return found;
	}

	public List<Address> getAll() {
		EntityManager em = emf.createEntityManager();
		List<Address> allItems = em.createQuery("SELECT address FROM Address address").getResultList();
		em.close();
		return allItems;
	}

	public void insert(Address addr) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(addr);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Address addr) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(addr);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Address addr) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("SELECT job FROM Address addr WHERE addr.id = :id",
				Address.class);
		typedQuery.setParameter("id", addr.getId());
		typedQuery.setMaxResults(1);

		Address result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
