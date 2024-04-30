package view;

import model.Contacto;
import service.ContactoService;

public class OperacionesContacto {

	public static void main(String[] args) {

		ContactoService service = new ContactoService();
		
		Contacto cto = new Contacto(8,"josefina", "josefina@gmail.com", 24); 
	//	service.nuevoContacto(cto);
	//	 service.actualizarContacto("josefina@gmail.com", 21);
		Contacto eliminado =  service.eliminarContacto("josefina@gmail.com");
   //   
	}

}
