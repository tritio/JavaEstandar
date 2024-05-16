package service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import model.Pais;

public interface PaisesService {

	Stream<Pais> getPaises();

	// Lista de continentes
	List<String> listarContinentes();

	// Lista de paises a partir del continente
	List<Pais> listarPaisesPorContinente(String continente);

	// Pais más poblado
	Pais paisMasPoblado();

	Map<String, List<Pais>> paisesAgrupadosPorContinente();

	// Pais a partir de su capital 
	Optional<Pais> paisAPartirCapital(String capital);

	// País a partir de capital pero sólo mostrando el nombre del país
	String nombrePaisAPartirCapital(String capital);

}