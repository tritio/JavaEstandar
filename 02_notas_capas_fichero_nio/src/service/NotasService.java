package service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.ErrorFuenteDatosException;

public class NotasService {
	//String ruta = "c:\\miTemporal\\notas.txt";
	Path pt = Path.of("c:\\miTemporal\\notas.txt");
	
	public void borrarNotas() {
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarNota(double nota) {		
		try {
			Files.writeString(pt, nota+System.lineSeparator(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);			
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	public double calcularMedia() throws ErrorFuenteDatosException {		
		try {
			return Files.lines(pt) // devuelve un Stream<String>
			.collect(Collectors.averagingDouble(l->Double.parseDouble(l)));
			
		} catch (IOException e) {			
			e.printStackTrace();
			throw new ErrorFuenteDatosException(); // provoca la excepción y la propagamos
		}
	}
	
	public double max() throws ErrorFuenteDatosException {
		try {
			return Files.lines(pt) // Stream<String> por lo que el resultado de todo sería un Optional
			.max(Comparator.comparingDouble(l->Double.parseDouble(l))) // Optional<String>
			.map(c-> Double.parseDouble(c)) // Optional<Double>
			.orElse(0.0);
			
		} catch (IOException e) {			
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}
	}
	
	public double min()  throws ErrorFuenteDatosException {
		try {
			return Files.lines(pt) 
			.min(Comparator.comparingDouble(l->Double.parseDouble(l)))
			.map(c-> Double.parseDouble(c))
			.orElse(null);	
		} catch (IOException e) {			
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}	
	}
	
	public List<Double> obtenerNotas() throws ErrorFuenteDatosException {
		try {
			return Files.lines(pt) 
				.map(n-> Double.parseDouble(n))
				.toList();
			
		} catch (IOException e) {			
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}	
	}
}
