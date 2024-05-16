package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pais {

	// anotación de la propia librería Gson:
	@SerializedName(value="name")  // ahora la propiedad nombre del json aquí la llamaremos empleado
	private String nombre;
	@SerializedName(value="region") 
	private String continente;
	private String capital;
	@SerializedName(value="population") 
	private String habitantes;
}

