package it.prova.proprietariojpa.service.automobile;

import java.util.List;

import it.prova.proprietariojpa.dao.automobile.AutomobileDAO;
import it.prova.proprietariojpa.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {
	
	AutomobileDAO automobileDAO;
	
	

	@Override
	public List<Automobile> listAllAutomobile() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automobile caricaSingolaAutomobile(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idAutomobileInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Automobile> OttieniTuttiByErroreEta() {
		// TODO Auto-generated method stub
		return null;
	}

	public AutomobileDAO getAutomobileDAO() {
		return automobileDAO;
	}

	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO = automobileDAO;
	}

}
