package dao;

import java.util.List;

import model.Municipio;

public interface MunicipioDao {

	void saveMunicipios(List<Municipio> municipios);
	List<String> FindCodigos();
}
