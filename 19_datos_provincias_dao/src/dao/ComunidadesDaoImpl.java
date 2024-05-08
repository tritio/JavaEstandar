package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locator.LocatorConnection;
import model.Comunidad;

class ComunidadesDaoImpl implements ComunidadDao{

	public void saveComunidades(List<Comunidad> comunidades) {
		try (Connection con = LocatorConnection.getConnection();){
			String sql="insert into comunidades(codigo,nombre) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);//cancelamos autocommit, si un registro no se graba, entonces no se grabará ninguno.
			for(Comunidad c:comunidades){
				ps.setString(1, c.getCodigo());
				ps.setString(2, c.getNombre());
				ps.execute();
			}
			con.commit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveComunidad(Comunidad comunidad) {
		try (Connection con = LocatorConnection.getConnection();){
			String sql="insert into comunidades(codigo,nombre) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);	
			ps.setString(1, comunidad.getCodigo());
			ps.setString(2, comunidad.getNombre());
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean existComunidad(String codigo) {
		try (Connection con = LocatorConnection.getConnection();){
			String sql="select * from comunidades where codigo = ?";
			PreparedStatement ps=con.prepareStatement(sql);	
			ps.setString(1, codigo);
			
			ResultSet rs = ps.executeQuery();
			return rs.next(); // si se mueve al siguiente eso quiere decir que existe el registro por lo que da true
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
