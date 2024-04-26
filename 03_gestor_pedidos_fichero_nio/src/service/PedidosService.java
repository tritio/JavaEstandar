package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

import model.Pedido;
import utilidades.Util;

public class PedidosService {
	String fichero="pedidos.csv";
	Path pt = Path.of("pedidos.csv");
	
	public void borrarPedidos() {

		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void nuevoPedido(Pedido pedido) {
		try {			
			Files.writeString(pt, Util.convertirPedidoACadena(pedido)+System.lineSeparator(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Pedido pedidoMasReciente()  {		
		try {
			return Files.lines(pt)
			.map(p-> Util.convertirCadenaAPedido(p))
			.max(Comparator.comparing(p-> (p.getFechaPedido())))			
			.orElse(null);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) {
		try {
			return Files.lines(pt)
				.map(l-> Util.convertirCadenaAPedido(l))
				.filter(p -> p.getFechaPedido().compareTo(f1)  >= 0 &&
				  p.getFechaPedido().compareTo(f2) <= 0)
				 .toList();
		} catch (IOException e) {
			e.printStackTrace();
			return List.of();
		}				
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		try {
			return Files.lines(pt)
				.map(l->Util.convertirCadenaAPedido(l))
				.min(Comparator.comparingLong(p->Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))))
				.orElse(null);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
		
	}
	
	public void eliminarPedido(String producto) {
		try  {
			List<String> nueva = Files.lines(pt)
				.map(p-> Util.convertirCadenaAPedido(p))
				.filter(p-> !p.getProducto().equals(producto))
				.map(p-> Util.convertirPedidoACadena(p))
				.toList();

			Files.write(pt, nueva);
			
		} catch(IOException e) {
			e.printStackTrace();			
		}	
	}
	
	public List<Pedido> pedidos() {
		try {
			return Files.lines(pt)
				.map(p -> Util.convertirCadenaAPedido(p))
				.toList();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
}
