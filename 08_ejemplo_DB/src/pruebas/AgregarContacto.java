package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AgregarContacto {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String password = "root";
		String name = "pepiño";
		String email = "pepiño@gmail.com";
		int edad = 25;
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
//			String sql = "insert into contactos(nombre, email, edad) values ( '" + name + "', '"
//					+ email + "'," + edad + ")";
			// consultas preparadas
			String sql = "insert into contactos(nombre, email, edad) values(?,?,?)";			
			// Statement st = con.createStatement();			
			// st.execute(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			// sustituir parámetros por valores
			ps.setString(1,  name);
			ps.setString(2,  email);
			ps.setInt(3,  edad);
			ps.execute();  // no se manda otra vez la SQL
			System.out.println("¡Registro añadido!");
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
