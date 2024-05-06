package view;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;

public class OperacionesContacto {

	public static void main(String[] args) {
		
		ContactosService service;  // es una interfaz
		
		Contacto cto = new Contacto(8,"josefina", "josefina@gmail.com", 24); 
	//	service.nuevoContacto(cto);
	//	 service.actualizarContacto("josefina@gmail.com", 21);
	//	Contacto eliminado =  service.eliminarContacto("josefina@gmail.com");
		Contacto eliminado = ContactosServiceFactory.getContactosService().eliminarContacto("josefina@gmail.com");
   //   
	}

}
