package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Empleado;

public class EmpleadoService {
	
	String dir = "C:\\miTemporal\\empleados.json";
//	Gson gson = new Gson();
// List<Empleado> empleados;

//	Implementar lógica de negocio de una aplicación que proporcione los siguientes métodos
//
//	-Lista de empleados de un determinado departamento
//	-Empleado con mayor salario
//	-Lista de departamentos 
	
	
	private Stream<Empleado> getEmpleados(){
		try {
			Gson gson=new Gson();
			return Arrays.stream (gson.fromJson(new FileReader(dir), Empleado[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	
	// Lista de empleados de un determinado departamento
	public List<Empleado> listarEmpleadosPorDepartamento(String departamento) {
		
//			 empleados = Arrays.asList(gson.fromJson(new FileReader(dir), Empleado[].class));
//			return empleados.stream()	
			return getEmpleados()
				.filter(e-> e.getDepartamento().equals(departamento))
				.toList();		
	}
	
//	-Empleado con mayor salario
	public Empleado empleadoMayorSalario() {
			
//			  empleados= Arrays.asList(gson.fromJson(new FileReader(dir), Empleado[].class));
//			  return empleados.stream()
				return getEmpleados()
					  .max(Comparator.comparingDouble(c-> c.getSalario()))
					  .orElse(null);		
	}
	
//	-Lista de departamentos 
	public List<String> listaDepartamentos() {		
//			  empleados= Arrays.asList(gson.fromJson(new FileReader(dir), Empleado[].class));
//			  return empleados.stream()
			return getEmpleados()
					 .map(e-> e.getDepartamento()) // Stream<String>
					 .distinct()
					 .toList();			
	}
}
