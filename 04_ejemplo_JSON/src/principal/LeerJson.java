package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Ciudad;

public class LeerJson {

	public static void main(String[] args) {
		
		String dir = "C:\\miTemporal\\ciudades.json";
		Gson gson = new Gson();
		try {
			List<Ciudad> ciudades = Arrays.asList(gson.fromJson(new FileReader(dir), Ciudad[].class)); // convertir a un array de objetos Java
			ciudades.forEach(c-> System.out.println("Ciudad: " + c.getCiudad() + " - Población: "
			+ c.getPoblacion() + " - Temperatura: " + c.getTemperatura()));
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {			
			e.printStackTrace();
		} 

	}

}
