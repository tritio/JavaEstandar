package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Cliente;

public class ClientesDaoImpl implements ClientesDao {


	@Override
	public Cliente findByUsuario(String usuario) {
		Cliente cl=new Cliente();
		try(Connection con=LocatorConnection.getConnection()) {
			String sql="select * from where usuario = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
			return new Cliente(rs.getInt("idCliente"),
					rs.getString("usuario"),
					rs.getString("email"),
					rs.getString("password"),
					rs.getInt("telefono"));					
			}
			return null;
			
		}catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void save(Cliente cliente) {
		try(Connection con=LocatorConnection.getConnection()){		
			String sql="insert into clientes(usuario, password, email,telefono) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cliente.getUsuario());
			ps.setString(2, cliente.getPassword());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getTelefono());
			ps.execute();		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}		
	}

}
