package model;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

	private String producto;
	private String tienda;
	//private LocalDateTime fechaPedido;
	private double precio;
}
