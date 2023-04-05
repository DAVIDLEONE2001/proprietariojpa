package it.prova.proprietariojpa.test;

import java.time.LocalDate;
import java.util.List;

import it.prova.proprietariojpa.dao.EntityManagerUtil;
import it.prova.proprietariojpa.model.Automobile;
import it.prova.proprietariojpa.model.Proprietario;
import it.prova.proprietariojpa.service.MyServiceFactory;
import it.prova.proprietariojpa.service.automobile.AutomobileService;
import it.prova.proprietariojpa.service.proprietario.ProprietarioService;

public class TestProprietario {

	public static void main(String[] args) {

		AutomobileService automobileServiceIstance = MyServiceFactory.getAutomobileServiceInstance();
		ProprietarioService proprietarioServiceIstance = MyServiceFactory.getProprietarioServiceInstance();

		try {

//			INIZIO TEST PROPRIETARIO**********************************************************

			System.out.println("In tabella Proprietario ci sono "
					+ proprietarioServiceIstance.listAllProprietario().size() + " elementi.");
//			testInserisciNuovoProprietario(proprietarioServiceIstance);
//			testListAllProprietario(proprietarioServiceIstance);
//			testAggiornaProprietario(proprietarioServiceIstance);
//			testRimuoviProprietario(proprietarioServiceIstance);
			System.out.println("In tabella Proprietario ci sono "
					+ proprietarioServiceIstance.listAllProprietario().size() + " elementi.");

//			FINE TEST PROPRIETARIO**********************************************************

//			INIZIO TEST AUTOMOBILE**********************************************************

			System.out.println("In tabella Automobile ci sono " + automobileServiceIstance.listAllAutomobile().size()
					+ " elementi.");
//			testErroreEtaAutomobile(proprietarioServiceIstance, automobileServiceIstance);
//			testInserisciNuovaAutomobile(proprietarioServiceIstance, automobileServiceIstance);
//			testAutomobiliConProprietarioConCFCheIniziaPer(proprietarioServiceIstance, automobileServiceIstance);
			testaAutoConProprietarioNatoDopo(proprietarioServiceIstance, automobileServiceIstance);
			
			System.out.println("In tabella Proprietario ci sono " + automobileServiceIstance.listAllAutomobile().size()
					+ " elementi.");

//			FINE TEST AUTOMOBILE**********************************************************

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

//	********************************************INIZIO TEST PROPRIETARIO**********************************************************

	private static void testInserisciNuovoProprietario(ProprietarioService proprietarioServiceIstance)
			throws Exception {

		System.out.println(".......testInserisciNuovoProprietario inizio.............");

		proprietarioServiceIstance
				.inserisciNuovo(new Proprietario("mario", "rossi", "jidbnibe", LocalDate.parse("1980-01-01")));

		List<Proprietario> presentiSulDB = proprietarioServiceIstance.listAllProprietario();

		if (presentiSulDB.size() < 1) {
			throw new RuntimeException(".......testInserisciNuovoProprietario fine: FAILED: Bd vouto.............");
		}
		System.out.println(".......testInserisciNuovoProprietario fine: PASSED.............");

	}

	private static void testListAllProprietario(ProprietarioService proprietarioServiceIstance) throws Exception {

		System.out.println(".......testListAllProprietario inizio.............");

		List<Proprietario> presentiSulDB = proprietarioServiceIstance.listAllProprietario();

		if (presentiSulDB.size() < 1) {
			throw new RuntimeException(".......testListAllProprietario fine: FAILED: Bd vouto.............");
		}
		System.out.println(".......testListAllProprietario fine: PASSED.............");

	}

	// setAutomobile(new Automobile("Toyota", "Yaris", "ABS0345")
	private static void testAggiornaProprietario(ProprietarioService proprietarioServiceIstance) throws Exception {

		System.out.println(".......testAggiornaProprietario inizio.............");

		List<Proprietario> presentiSulDB = proprietarioServiceIstance.listAllProprietario();

		presentiSulDB.get(presentiSulDB.size() - 1).setCognome("Luigi");

		List<Proprietario> presentiSulDBAggiornato = proprietarioServiceIstance.listAllProprietario();

		if (presentiSulDB.size() < 1) {
			throw new RuntimeException(".......testListAllProprietario fine: FAILED: Bd vouto.............");
		}

		System.out.println(".......testAggiornaProprietario fine: PASSED.............");

	}

	private static void testRimuoviProprietario(ProprietarioService proprietarioServiceIstance) throws Exception {

		System.out.println(".......testRimuoviProprietario inizio.............");

		proprietarioServiceIstance
				.inserisciNuovo(new Proprietario("Mimmo", "Carrisi", "MCAR02S04H501H", LocalDate.parse("1975-01-01")));

		List<Proprietario> presentiSulDB = proprietarioServiceIstance.listAllProprietario();

		proprietarioServiceIstance.rimuovi(presentiSulDB.get(presentiSulDB.size() - 1).getId());

		List<Proprietario> presentiSulDBAggiornato = proprietarioServiceIstance.listAllProprietario();

		if (presentiSulDB.size() < presentiSulDBAggiornato.size()) {
			throw new RuntimeException(
					".......testRimuoviProprietario fine: FAILED: Prprietario non rimosso.............");
		}
		System.out.println(".......testRimuoviProprietario fine: PASSED.............");

	}

//	********************************************FINE TEST PROPRIETARIO**********************************************************

//	********************************************INIZIO TEST AUTOMOBILE**********************************************************

	private static void testInserisciNuovaAutomobile(ProprietarioService proprietarioServiceIstance,
			AutomobileService automobileServiceIstance) throws Exception {

		System.out.println(".......testInserisciNuovaAutomobile inizio.............");

		List<Proprietario> proprietariPresentiSulDB = proprietarioServiceIstance.listAllProprietario();

		automobileServiceIstance.inserisciNuovo(new Automobile("Toyota", "Yaris", "ABS0345",
				proprietariPresentiSulDB.get(proprietariPresentiSulDB.size() - 1)));

		List<Automobile> automobiliPresentiSulDB = automobileServiceIstance.listAllAutomobile();

		if (automobiliPresentiSulDB.size() < 1) {
			throw new RuntimeException(".......testInserisciNuovaAutomobile fine: FAILED: Bd vouto.............");
		}
		System.out.println(".......testInserisciNuovaAutomobile fine: PASSED.............");

	}

	private static void testErroreEtaAutomobile(ProprietarioService proprietarioServiceIstance,
			AutomobileService automobileServiceIstance) throws Exception {

		System.out.println(".......testErroreEtaAutomobile inizio.............");

		proprietarioServiceIstance
				.inserisciNuovo(new Proprietario("Picci", "Suss", "MCAR02S04H501H", LocalDate.parse("2010-01-01")));

		List<Proprietario> proprietariPresentiSulDB = proprietarioServiceIstance.listAllProprietario();

		automobileServiceIstance.inserisciNuovo(new Automobile("BMW", "Yaris", "ABS0345",
				proprietariPresentiSulDB.get(proprietariPresentiSulDB.size() - 1)));
		List<Proprietario> proprietariPresentiSulDBDopoInsert = proprietarioServiceIstance.listAllProprietario();

		List<Automobile> automobiliPresentiSulDbErr = automobileServiceIstance.OttieniTuttiByErroreEta();

		if (automobiliPresentiSulDbErr.size() < 1) {
			throw new RuntimeException(
					".......testErroreEtaAutomobile fine: FAILED: mi apetto un errore.............");
		}
		for (Automobile automobile : automobiliPresentiSulDbErr) {
			automobileServiceIstance.rimuovi(automobile.getId());
		}
		proprietarioServiceIstance.rimuovi(proprietariPresentiSulDBDopoInsert.get(proprietariPresentiSulDBDopoInsert.size() - 1).getId());

		System.out.println(".......testErroreEtaAutomobile fine: PASSED.............");

	}
	
	private static void testAutomobiliConProprietarioConCFCheIniziaPer(ProprietarioService proprietarioServiceIstance,
			AutomobileService automobileServiceIstance) throws Exception {

		System.out.println(".......testAutomobiliConProprietarioConCFCheIniziaPer inizio.............");

		List<Proprietario> proprietariPresentiSulDB = proprietarioServiceIstance.listAllProprietario();

		

		List<Automobile> automobiliPresentiSulDBConCF = automobileServiceIstance.automobiliConProprietarioConCFCheIniziaPer("m");

		if (automobiliPresentiSulDBConCF.size() < 1) {
			throw new RuntimeException(".......testAutomobiliConProprietarioConCFCheIniziaPer fine: FAILED: Bd vouto.............");
		}
		System.out.println(".......testAutomobiliConProprietarioConCFCheIniziaPer fine: PASSED.............");

	}
	
	private static void testaAutoConProprietarioNatoDopo(ProprietarioService proprietarioServiceIstance,
			AutomobileService automobileServiceIstance) throws Exception {

		System.out.println(".......testaAutoConProprietarioNatoDopo inizio.............");

		List<Proprietario> proprietariPresentiSulDB = proprietarioServiceIstance.listAllProprietario();


		int automobiliConPropNatoDopo = automobileServiceIstance.autoConProprietarioNatoDopo(1900);
		
		System.out.println(automobiliConPropNatoDopo);

		if (automobiliConPropNatoDopo < 1) {
			throw new RuntimeException(".......testaAutoConProprietarioNatoDopo fine: FAILED: Bd vouto.............");
		}
		System.out.println(".......testaAutoConProprietarioNatoDopo fine: PASSED.............");

	}

//	********************************************FINE TEST AUTOMOBILE**********************************************************

}
