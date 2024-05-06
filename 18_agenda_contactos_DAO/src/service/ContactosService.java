package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	// no se admiten contactos con email duplicado
	boolean nuevoContacto(Contacto contacto);

	// devuelve el contacto eliminado. Si no se ha eliminado ninguno, devuelve null
	Contacto eliminarContacto(String email);

	boolean actualizarContacto(String email, int nuevaEdad);

	// buscar contacto por su clave primaria 
	Contacto buscarContactoPorId(int idContacto);

	// recupera todos los contactos
	List<Contacto> getContactos();

}