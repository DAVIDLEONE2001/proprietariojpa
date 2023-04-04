package it.prova.proprietariojpa.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.proprietariojpa.model.Automobile;
import it.prova.proprietariojpa.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {
	
	private EntityManager entityManager;

	public ProprietarioDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Proprietario> list() throws Exception {
		
		return entityManager.createQuery("select from proprietario", Proprietario.class).getResultList();
	}

	@Override
	public Proprietario get(Long id) throws Exception {
		
		return entityManager.find(Proprietario.class, id);
	}

	@Override
	public void update(Proprietario proprietarioInput) throws Exception {
		
		if (proprietarioInput == null) {

			throw new Exception("Problema valore in input");
		}

		entityManager.merge(proprietarioInput);

	}

	

	@Override
	public void insert(Proprietario proprietarioInput) throws Exception {
		
		if (proprietarioInput == null) {

			throw new Exception("Problema valore in input");
		}
		
		entityManager.persist(proprietarioInput);

	}

	@Override
	public void delete(Proprietario proprietarioInput) throws Exception {
		
		

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub

	}

}
