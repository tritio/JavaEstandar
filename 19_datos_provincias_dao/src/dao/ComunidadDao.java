package dao;

import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadDao {

	void saveComunidades(List<Comunidad> comunidades);
	void saveComunidad(Comunidad comunidad);
	boolean existComunidad(String codigo);
	
}
