package it.prova.proprietariojpa.test;

import java.time.LocalDate;

import it.prova.proprietariojpa.dao.EntityManagerUtil;
import it.prova.proprietariojpa.model.Proprietario;
import it.prova.proprietariojpa.service.MyServiceFactory;
import it.prova.proprietariojpa.service.automobile.AutomobileService;
import it.prova.proprietariojpa.service.proprietario.ProprietarioService;

public class TestProprietario {

	public static void main(String[] args) {

		AutomobileService automobileServiceIstance = MyServiceFactory.getAbitanteServiceInstance();
		ProprietarioService proprietarioServiceIstance = MyServiceFactory.getMunicipioServiceInstance();

		try {

			testListAllProprietario(proprietarioServiceIstance);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	private static void testListAllProprietario(ProprietarioService proprietarioServiceIstance) throws Exception {

		proprietarioServiceIstance
				.inserisciNuovo(new Proprietario("mario", "rossi", "jidbnibe", LocalDate.parse("1980-01-01")));

		proprietarioServiceIstance.listAllProprietario();

	}

}
