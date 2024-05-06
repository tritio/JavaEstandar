package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class ContactoServiceImpl implements ContactosService {


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
	
	// no se admiten contactos con email duplicado
	@Override
	public boolean nuevoContacto(Contacto contacto) {
		if(existeContactoPorEmail(contacto.getEmail()) !=null) {
			System.out.println("ya existe ese email");
			return false;
		}
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {	
			String sql = "insert into contactos(nombre, email, edad) values(?,?,?)";	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  contacto.getNombre());
			ps.setString(2,  contacto.getEmail());
			ps.setInt(3,  contacto.getEdad());
			ps.execute(); 
			System.out.println("¡Registro añadido!");
			return true;
			
		}catch (SQLException ex) {
			ex.printStackTrace();			
			return false;
		}
		
	}
	
	// devuelve el contacto eliminado. Si no se ha eliminado ninguno, devuelve null
	@Override
	public Contacto eliminarContacto (String email) {
		Contacto contacto = existeContactoPorEmail(email);
		if (contacto==null) {
			return null;
		}
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "delete from contactos where email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			System.out.println("contacto borrado");
			return contacto;
			
		}catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}		
	}
	
	
	@Override
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
	
	// buscar contacto por su clave primaria 
	@Override
	public Contacto buscarContactoPorId(int idContacto) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {			
			String sql = "select * from contactos where idContacto=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idContacto);			
			ResultSet rs = st.executeQuery(); // no se le pasa sql porque se le pasa ya al prepareStatement
			
			// debemos movernos a la primera, y única fila, para poder extraer
			if(rs.next()) {
				return new  Contacto(rs.getInt("idContacto"), rs.getString("nombre"), rs.getString("email"), rs.getInt("edad"));
			}
			// otra forma si no hago el select con where
//			while(rs.next()) {
//				if((rs.getInt("idContacto")) == (idContacto)) {
//					return new Contacto(rs.getInt("idContacto"), rs.getString("nombre"), rs.getString("email"), rs.getInt("edad"));
//				}
//			}			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	// recupera todos los contactos
	@Override
	public List<Contacto> getContactos() {
		List<Contacto> contactos = new ArrayList<Contacto>();
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {			
			String sql = "select * from contactos";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				contactos.add(new Contacto(rs.getInt("idContacto"), rs.getString("nombre"),
						rs.getString("email"), rs.getInt("edad")));
			}			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
	
	private Contacto existeContactoPorEmail(String email) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password)){		
			String sql="select * from contactos where email=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Contacto(rs.getInt("idContacto"),
							rs.getString("nombre"),
							rs.getString("email"),
							rs.getInt("edad"));
			}
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	} 
	
}
