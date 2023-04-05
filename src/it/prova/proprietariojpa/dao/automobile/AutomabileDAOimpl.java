package it.prova.proprietariojpa.dao.automobile;

import java.time.LocalDate;
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

		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();

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
		this.entityManager = entityManager;

	}

	@Override
	public List<Automobile> erroreEta() {

		TypedQuery<Automobile> query = entityManager
				.createQuery("from Automobile a where a.proprietario.dataDiNascita > ?1", Automobile.class);
		query.setParameter(1, LocalDate.now().minusYears(18));

		return query.getResultList();
	}

	@Override
	public List<Automobile> propConCoFisc(String cod) {

		TypedQuery<Automobile> query = entityManager.createQuery("from Automobile a where a.proprietario.cf like ?1",
				Automobile.class);
		query.setParameter(1, cod + "%");

		return query.getResultList();
	}

	@Override
	public int autoConPropNatoDopo(int anno) {

		TypedQuery<Long> query = entityManager.createQuery(
				"select count(a.id) from Automobile a where year(a.proprietario.dataDiNascita) > ?1", Long.class);
		query.setParameter(1, anno);
		
		int count = query.getSingleResult().intValue();

		return count;
	}

}
