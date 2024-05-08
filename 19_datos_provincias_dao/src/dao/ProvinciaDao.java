package dao;

import java.util.List;

import model.Provincia;

public interface ProvinciaDao {
	void saveProvincias(List<Provincia> provincias);
	List<String> findCodigos();
}
