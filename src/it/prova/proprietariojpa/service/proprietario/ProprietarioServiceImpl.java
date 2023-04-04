package it.prova.proprietariojpa.service.proprietario;

import java.util.List;

import it.prova.proprietariojpa.dao.proprietario.ProprietarioDAO;
import it.prova.proprietariojpa.model.Proprietario;

public class ProprietarioServiceImpl implements ProprietarioService {
	
	ProprietarioDAO proprietarioDAO;
	
	

	@Override
	public List<Proprietario> listAllProprietario() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietario caricaSingolaProprietario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Proprietario proprietarioInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idProprietarioInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	public ProprietarioDAO getProprietarioDAO() {
		return proprietarioDAO;
	}

	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;
	}

}
