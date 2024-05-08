package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Provincia;

class ProvinciasDaoImpl implements ProvinciaDao {

	@Override
	public void saveProvincias(List<Provincia> provincias) {
		try (Connection con = LocatorConnection.getConnection();){
			String sql="insert into provincias(codigo,nombre, codComunidad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);//cancelamos autocommit, si un registro no se graba, entonces no se grabará ninguno.
			for(Provincia c:provincias){
				ps.setString(1, c.getCodigo());
				ps.setString(2, c.getNombre());
				ps.setString(3, c.getCodComunidad() );
				ps.execute();
			}
			con.commit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<String> findCodigos() {
		List<String> codigos=new ArrayList<String>();
		try (Connection con=LocatorConnection.getConnection()){
			String sql="select codigo from provincias";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(
			rs.next
			()) {
				codigos.add(rs.getString(1));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return codigos;
	} 
	

}
