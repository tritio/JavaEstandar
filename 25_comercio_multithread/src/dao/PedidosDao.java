package dao;

import java.util.List;

import model.Pedido;

public interface PedidosDao {

	void insertPedido(List<Pedido> pedidos, String tienda);
}
