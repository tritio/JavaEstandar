package service;

import java.util.List;

import dao.PedidosDao;
import dao.TiendasDao;
import dao.TiendasPedidosDaoFactory;
import model.Pedido;

public class ComercioServiceImpl implements ComercioService {

	PedidosDao pedidosDao;
	TiendasDao tiendasDao;
	
	public ComercioServiceImpl() {
		pedidosDao = TiendasPedidosDaoFactory.getPedidosDao();
		tiendasDao = TiendasPedidosDaoFactory.getTiendasDao();
	}
	
	@Override
	public List<Pedido> leerFichero(String fichero) {
		List<Pedido> pedidos = tiendasDao.LeerFichero(fichero);
		return pedidos;
	}

	@Override
	public void guardarPedido(String fichero, String tienda) {		
		List<Pedido> pedidos = leerFichero(fichero);		
		pedidosDao.insertPedido(pedidos, tienda);	
	}

}
