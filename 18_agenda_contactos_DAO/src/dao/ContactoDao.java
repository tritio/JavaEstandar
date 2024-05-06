package dao;

import java.util.List;

import model.Contacto;

public interface ContactoDao {

	void save (Contacto contacto);
	Contacto FindByEmail(String email);
	void upDate(Contacto contacto);
	Contacto findbyId(int idContacto);
	List<Contacto> findAll();
	void deleteByEmail(String email);
	
	static ContactoDao of() {
		return new ContactoDaoImpl();
	}

	
}
