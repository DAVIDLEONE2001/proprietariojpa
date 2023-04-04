package it.prova.proprietariojpa.service;

import it.prova.municipioabitantejpa.service.municipio.MunicipioService;
import it.prova.municipioabitantejpa.service.municipio.MunicipioServiceImpl;
import it.prova.proprietariojpa.dao.MyDaoFactory;
import it.prova.proprietariojpa.service.automobile.AutomobileService;
import it.prova.proprietariojpa.service.automobile.AutomobileServiceImpl;

public class MyServiceFactory {

	// rendiamo le istanze restituite SINGLETON
	private static AutomobileService automobileServiceInstance = null;
	private static MunicipioService municipioServiceInstance = null;

	public static AutomobileService getAbitanteServiceInstance() {
		if (automobileServiceInstance == null) {
			automobileServiceInstance = new AutomobileServiceImpl();
			automobileServiceInstance.setAutomobileDAO
		}
		return automobileServiceInstance;
	}

	public static MunicipioService getMunicipioServiceInstance() {
		if (municipioServiceInstance == null) {
			municipioServiceInstance = new MunicipioServiceImpl();
			municipioServiceInstance.setMunicipioDAO(MyDaoFactory.getMunicipioDAOInstance());
		}
		return municipioServiceInstance;
	}

}
