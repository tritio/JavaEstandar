package dao;

public class TiendasPedidosDaoFactory {

	public static PedidosDao getPedidosDao() {
		return new PedidosDaoImpl();
	}
	
	public static TiendasDao getTiendasDao() {
		return new TiendasDaoImpl();
	}
}
