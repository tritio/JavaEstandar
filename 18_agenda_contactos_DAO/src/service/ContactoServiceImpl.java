package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ContactoDao;
import model.Contacto;

public class ContactoServiceImpl implements ContactosService {

	ContactoDao contactoDao;
	public ContactoServiceImpl() {
		contactoDao = ContactoDao.of();
	}

	// no se admiten contactos con email duplicado
	@Override
	public boolean nuevoContacto(Contacto contacto) {
		if(contactoDao.FindByEmail(contacto.getEmail()) !=null) {
			return false;
		}
		contactoDao.save(contacto);
		return true;
	}
	
	// devuelve el contacto eliminado. Si no se ha eliminado ninguno, devuelve null
	@Override
	public Contacto eliminarContacto (String email) {
		Contacto contacto = contactoDao.FindByEmail(email);
		if (contacto==null) {
			return null;
		}
		contactoDao.deleteByEmail(email);
		return contacto;			
	}
		
	@Override
	public boolean actualizarContacto (String email, int nuevaEdad) {
		Contacto contacto = contactoDao.FindByEmail(email);
		if(contacto!=null) {
			contacto.setEdad(nuevaEdad);
			contactoDao.upDate(contacto);
			return true;
		}
		return false;
	}
	
	// buscar contacto por su clave primaria 
	@Override
	public Contacto buscarContactoPorId(int idContacto) {
		return contactoDao.findbyId(idContacto);
		
	}
	
	// recupera todos los contactos
	@Override
	public List<Contacto> getContactos() {
		return contactoDao.findAll();
	}
	
	private Contacto existeContactoPorEmail(String email) {
		return contactoDao.FindByEmail(email);
	} 
	
}
