package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Contacto;

public class ContactoService {


	//1.-Nuevo Contacto
	//2.-Eliminar Contacto
	//3.-Actualizar edad
	//4.-Salir
	//
	//1: Se piden los datos del nuevo contacto y se guarda
	//2: Solicita el email y borra el contacto con dicho email
	//3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto 
	
	String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
	String usuario = "root";
	String password = "root";
	
	public void agregarContacto(Contacto contacto) {
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "insert into contactos(nombre, email, edad) values(?,?,?)";	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  contacto.getNombre());
			ps.setString(2,  contacto.getEmail());
			ps.setInt(3,  contacto.getEdad());
			ps.execute(); 
			System.out.println("¡Registro añadido!");
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean eliminarContacto (String email) {
		// delete from empleados where codigodep="BB45"
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "delete from contactos where email=?";	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			return ps.executeUpdate()>0;
		//	Statement st = con.createStatement();			
			//int resultado = st.executeUpdate(sql);
		}catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public boolean actualizarContacto (String email, int nuevaEdad) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "update contactos set edad= ? where  email=?"; 
				
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, nuevaEdad);
			ps.setString(2, email);
			return ps.executeUpdate()>0;
		}catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
