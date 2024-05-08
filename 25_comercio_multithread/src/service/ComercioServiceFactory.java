package service;



public class ComercioServiceFactory {

	public static ComercioService getComercioService() {
		return new ComercioServiceImpl();
	}
}
