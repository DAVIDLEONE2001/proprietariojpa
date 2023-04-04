package it.prova.proprietariojpa.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.proprietariojpa.model.Automobile;

public class AutomabileDAOimpl implements AutomobileDAO {

	private EntityManager entityManager;

	public AutomabileDAOimpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Automobile> list() throws Exception {

		return entityManager.createQuery("select from Automobile", Automobile.class).getResultList();

	}

	@Override
	public Automobile get(Long id) throws Exception {

		return entityManager.find(Automobile.class, id);

	}

	@Override
	public void update(Automobile automobileInput) throws Exception {

		if (automobileInput == null) {

			throw new Exception("Problema valore in input");
		}

		entityManager.merge(automobileInput);

	}

	@Override
	public void insert(Automobile automobileInput) throws Exception {
		
		if (automobileInput == null) {

			throw new Exception("Problema valore in input");
		}
		
		entityManager.persist(automobileInput);

	}

	@Override
	public void delete(Automobile automobileInput) throws Exception {
		
		if (automobileInput == null) {

			throw new Exception("Problema valore in input");
		}
		
		entityManager.remove(automobileInput);

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Automobile> erroreEta() {
		
		TypedQuery<Automobile> query = entityManager
				.createQuery("from automobile a where a.data like ?1", Automobile.class);
		query.setParameter(1, "%");
		
		return query.getResultList();
	}

}
