package it.prova.proprietariojpa.service.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.proprietariojpa.dao.EntityManagerUtil;
import it.prova.proprietariojpa.dao.proprietario.ProprietarioDAO;
import it.prova.proprietariojpa.model.Proprietario;

public class ProprietarioServiceImpl implements ProprietarioService {
	
	ProprietarioDAO proprietarioDAO;
	
	

	@Override
	public List<Proprietario> listAllProprietario() throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return proprietarioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Proprietario caricaSingolaProprietario(Long id) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return proprietarioDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Proprietario proprietarioInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.update(proprietarioInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.insert(proprietarioInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Long idProprietarioInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.delete(proprietarioDAO.get(idProprietarioInstance));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	public ProprietarioDAO getProprietarioDAO() {
		return proprietarioDAO;
	}

	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;
	}

}
