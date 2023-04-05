package it.prova.proprietariojpa.service.proprietario;

import java.util.List;

import it.prova.proprietariojpa.dao.proprietario.ProprietarioDAO;
import it.prova.proprietariojpa.model.Proprietario;

public interface ProprietarioService {

	public List<Proprietario> listAllProprietario() throws Exception;

	public Proprietario caricaSingoloProprietario(Long id) throws Exception;

	public void aggiorna(Proprietario proprietarioInstance) throws Exception;

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception;

	public void rimuovi(Long idProprietarioInstance) throws Exception;
	
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);

}
