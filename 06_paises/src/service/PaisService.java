package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pais;

/*
  Implementar lógica de negocio de una aplicación que proporcione información
sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes

-Lista de continentes
-Lista de paises a partir del continente
-Pais más poblado
-Tabla con paises agurpados por continente
-Pais a partir de su capital 
*/

public class PaisService {

	String dir = "C:\\temp\\paises.json";
	
	public Stream<Pais> getPaises() {
		try {
			Gson gson=new Gson();
			return Arrays.stream (gson.fromJson(new FileReader(dir), Pais[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	// Lista de continentes
	public List<String> listarContinentes() {
		return getPaises()
			.map(p->p.getContinente()) // Stream<Pais>
			.distinct()
			.toList();
	}
	
	// Lista de paises a partir del continente
	public List<Pais> listarPaisesPorContinente(String continente) {
		return getPaises()
				.filter(c-> c.getContinente().equalsIgnoreCase(continente))
				.toList();
	}
	
	// Pais más poblado
	public Pais paisMasPoblado() {
		return getPaises()
				.max(Comparator.comparingInt(p -> Integer.parseInt(p.getHabitantes())))
				.orElse(null);
	}
	
	// Tabla con paises agrupados por continente
	
	public Map<String, List<Pais>> paisesAgrupadosPorContinente() {
		return getPaises()
				.collect(Collectors.groupingBy(p -> p.getContinente()));
	}
	
	// Pais a partir de su capital 
	public Optional<Pais> paisAPartirCapital(String capital) {
		return   getPaises()
				.filter(p-> p.getCapital() != null &&  p.getCapital().equalsIgnoreCase(capital)) // Stream<Pais>
				.findFirst();
	}
	
	// País a partir de capital pero sólo mostrando el nombre del país
	public String nombrePaisAPartirCapital(String capital) {
		return  getPaises()
				.filter(p-> p.getCapital() != null &&  p.getCapital().equalsIgnoreCase(capital))
				.findFirst()
				.map(p->p.getNombre())
				.orElse("");
	}
	
}
