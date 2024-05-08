package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pedido;

public class TiendasDaoImpl implements TiendasDao {

	@Override
	public List<Pedido> LeerFichero(String dir) {		
		try {
			Gson gson=new Gson();
			return Arrays.asList(gson.fromJson(new FileReader(dir), Pedido[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {

			System.out.println("pasa por aquí");
			e.printStackTrace();
			return List.of();
		}
	}
}
