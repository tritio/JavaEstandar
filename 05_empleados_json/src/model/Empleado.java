package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {

	// anotación de la propia librería Gson:
	@SerializedName(value="nombre")  // ahora la propiedad nombre del json aquí la llamaremos empleado
	private String empleado;
	private String email;
	private double salario;
	private String departamento;
}
