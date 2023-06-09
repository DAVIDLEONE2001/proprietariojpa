package it.prova.proprietariojpa.service.automobile;

import java.util.List;

import it.prova.proprietariojpa.dao.automobile.AutomobileDAO;
import it.prova.proprietariojpa.model.Automobile;

public interface AutomobileService {

	public List<Automobile> listAllAutomobile() throws Exception;

	public Automobile caricaSingolaAutomobile(Long id) throws Exception;

	public void aggiorna(Automobile automobileInstance) throws Exception;

	public void inserisciNuovo(Automobile automobileInstance) throws Exception;

	public void rimuovi(Long idAutomobileInstance) throws Exception;
	
	public List<Automobile> OttieniTuttiByErroreEta();
	
	public void setAutomobileDAO(AutomobileDAO automobileDAO);
	
	public List<Automobile> automobiliConProprietarioConCFCheIniziaPer(String inizialeCF) throws Exception;
	
	public int autoConProprietarioNatoDopo(int anno) throws Exception;
	
	


}
