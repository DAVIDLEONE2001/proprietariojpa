package it.prova.proprietariojpa.service.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.proprietariojpa.dao.EntityManagerUtil;
import it.prova.proprietariojpa.dao.automobile.AutomobileDAO;
import it.prova.proprietariojpa.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {

	AutomobileDAO automobileDAO;

	@Override
	public List<Automobile> listAllAutomobile() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Automobile caricaSingolaAutomobile(Long id) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.update(automobileInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.insert(automobileInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Long IdAutomobileInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.delete(automobileDAO.get(IdAutomobileInstance));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public List<Automobile> OttieniTuttiByErroreEta() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.erroreEta();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	public AutomobileDAO getAutomobileDAO() {
		return automobileDAO;
	}

	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO = automobileDAO;
	}

	@Override
	public List<Automobile> automobiliConProprietarioConCFCheIniziaPer(String inizialeCF) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.propConCoFisc(inizialeCF);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public int autoConProprietarioNatoDopo(int anno) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.autoConPropNatoDopo(anno);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

}
