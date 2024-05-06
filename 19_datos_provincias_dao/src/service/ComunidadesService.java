package service;

import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadesService {

	// salva la lista de comunidades, evitando guardar por segunda vez comunidades que ya existan en la bbdd.
	// devuelve el total de comunidades guardadas.
	// Hacer lo mismo para las provincias y para los municipios.
	int saveComunidades(List<Comunidad> comunidades);

	int saveProvincias(List<Provincia> provincias);

	int saveMunicipios(List<Municipio> municipios);

}