package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

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
		Gson gson=new Gson();
		
		// creamos objeto request que configura la petición
		String url="https://restcountries.com/v2/all";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();
		
		// Creamos el objeto client para hacer la llamada
		HttpClient client = HttpClient.newBuilder()
				.build();
		
		// realizamos la llamada
		try {
			HttpResponse<String> respuesta = client.send(request, BodyHandlers.ofString());
			return Arrays.stream(gson.fromJson(respuesta.body(), Pais[].class));  // fromJson devuelve un array. Lo convertimos a Stream para poder tratarlo
		} catch (IOException | InterruptedException e) {
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
