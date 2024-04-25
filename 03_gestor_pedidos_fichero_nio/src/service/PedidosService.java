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
			.max(Comparator.comparing(p-> (Util.convertirCadenaAPedido(p)).getFechaPedido()))
			.map(p-> Util.convertirCadenaAPedido(p))
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
				 .filter(c -> Period.between(c.getFechaPedido() && f1),c.getFechaPedido() && f2)
				 .toList();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		// /.collect(Collectors.toMap(c->(int) Period.between(c.getFechaInicio(), c.getFechaFin())));
		
		
//		ArrayList<Pedido> aux=new ArrayList<Pedido>();
//		try(FileReader fr=new FileReader(fichero);
//				BufferedReader bf=new BufferedReader(fr);){
//			String linea;
//			while((linea=bf.readLine())!=null) {
//				Pedido p=Util.convertirCadenaAPedido(linea);
//				//si fecha del pedido es posterior o igual a f1 y anterior o igual a f2, se incluye
//				if(p.getFechaPedido().compareTo(f1)>=0&&p.getFechaPedido().compareTo(f2)<=0) {
//					aux.add(p);
//				}
//			}
//		}
//		catch(IOException ex) {
//			ex.printStackTrace();
//		}
//		return aux;
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		Pedido pAux=new Pedido();
		pAux.setFechaPedido(LocalDate.of(1, 1, 1));
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			String linea;
			while((linea=bf.readLine())!=null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				if(Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))<
						Math.abs(ChronoUnit.DAYS.between(pAux.getFechaPedido(), fecha))) {
					pAux=p;
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return pAux;
	}
	
	public void eliminarPedido(String producto) {
		
	}
	
	public List<Pedido> pedidos() {
		
	}
}
