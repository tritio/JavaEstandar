package service;

import model.Alumno;

public interface AlumnosService {

	//	String cadenaConexion = "jdbc:mysql://localhost:3306/formacion";
	//	String usuario="root";
	//	String password="root";
	Alumno alumnoPorDni(String dni);

	boolean guardarAlumno(Alumno alumno);
	
	// A partir de Java 8 podríamos usar métodos estáticos de las propias interfaces en lugar de crear factorias
//	static AlumnosService of() {
//		return new AlumnosServiceImpl();
//	}

}