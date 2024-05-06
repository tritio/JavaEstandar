package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import locator.LocatorConnection;
import model.Curso;

public class CursosServiceImpl implements CursosService, CursosJsonService {
	
	String cadenaConexion = "jdbc:mysql://localhost:3306/formacion";
	String usuario="root";
	String password="root";
	@Override
	public Curso cursoPorId(int idCurso) {
		try(Connection con= LocatorConnection.getConnection();){		
			String sql="select * from cursos where idCurso=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idCurso);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Curso(rs.getInt("idCurso"),
							rs.getString("curso"),
							rs.getInt("duracion"),
							rs.getDouble("precio"),
							null);
			}
				
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean altaCurso(Curso curso) {
		if(cursoPorId(curso.getIdCurso())!=null) {
			return false;
		}
		try(Connection con= LocatorConnection.getConnection();){		
			String sql="insert into cursos(idCurso,curso,duracion,precio) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setInt(1, curso.getIdCurso());
			ps.setString(2, curso.getCurso());
			ps.setInt(3, curso.getDuracion());
			ps.setDouble(4, curso.getPrecio());
			ps.execute();//NO se manda otra vez la SQL
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Curso> cursosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
