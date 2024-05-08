package service;
import java.util.List;

import model.Pedido;

public interface ComercioService {

	public List<Pedido> leerFichero(String fichero);
	
	public void guardarPedido(String fichero, String tienda);
	
}
