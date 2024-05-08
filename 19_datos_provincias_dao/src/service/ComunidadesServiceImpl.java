package service;

import java.util.ArrayList;
import java.util.List;

import dao.ComunidadDao;
import dao.ComunidadesDaoFactory;
import dao.MunicipioDao;
import dao.ProvinciaDao;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

class ComunidadesServiceImpl implements ComunidadesService {
	
	ComunidadDao comunidadDao;
	ProvinciaDao provinciaDao;
	MunicipioDao municipioDao;
	
	public ComunidadesServiceImpl() {
		comunidadDao = ComunidadesDaoFactory.getComunidadesDao();
		provinciaDao = ComunidadesDaoFactory.getProvinciasDao();
		municipioDao = ComunidadesDaoFactory.getMunicipiosDao();
	}
		
	
	@Override
	public int saveComunidades(List<Comunidad> comunidades) {
		/*Solución utilizando saveComunidad
		 * int cont = 0; 
		 * for(Comunidad c: comunidades) {
		 * if(!comunidadDao.existComunidad(c.getCodigo())) {
		 * comunidadDao.saveComunidad(c);
		 *  cont++; }
		 *  }
		 *   return cont;
		 */
		// utilizando programación funcional:
		
//		return comunidades.stream()
//				.filter(c->!comunidadDao.existComunidad(c.getCodigo()))
//				.peek(c->comunidadDao.save(c))
//				.count();
		// solución utilizando saveComunidades (una lista):
		int cont = 0; 
		List<Comunidad> comunidadesAGuardar = new ArrayList<Comunidad>();
		for(Comunidad c: comunidades) {
			if(!comunidadDao.existComunidad(c.getCodigo())) {
				 comunidadesAGuardar.add(c);
				 cont++;
			}
		}
		comunidadDao.saveComunidades(comunidadesAGuardar);
		return cont;
			
		// utilizando programación funcional:
		
//		List<Comunidad> aux = comunidades.stream()
//				.filter(c->!comunidadDao.existComunidad(c.getCodigo()))
//				.toList();
//		comunidadDao.saveComunidades(aux);
//		return aux.size();
		
	}


	@Override
	public int saveProvincias(List<Provincia> provincias) {		
		List<String> codigos = provinciaDao.findCodigos();
		List<Provincia> aux = provincias.stream()
				.filter(p -> !codigos.contains(p.getCodigo()))			
				.toList();
		provinciaDao.saveProvincias(aux);
		return aux.size();
	}
	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		List<String> codigos = municipioDao.FindCodigos();
		List<Municipio> aux = municipios.stream()
				.filter(p -> !codigos.contains(p.getCodigo()))			
				.toList();
		municipioDao.saveMunicipios(aux);
		return aux.size();
	}	
	
}
