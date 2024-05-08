package principal;

import service.ComercioService;
import service.ComercioServiceFactory;

public class Lanzador  {

	static String ruta1 = "C:\\miTemporal\\tienda1.json";
	static String ruta2 = "C:\\miTemporal\\tienda2.json";
	static String ruta3 = "C:\\miTemporal\\tienda3.json";
	
	public static void main(String[] args) {
	
		ComercioService service = ComercioServiceFactory.getComercioService();
		new Thread(()-> service.guardarPedido(ruta1, "tienda1")).start();
		new Thread(()-> service.guardarPedido(ruta2, "tienda2")).start();
		new Thread(()-> service.guardarPedido(ruta3, "tienda3")).start();
		System.out.println("Tiendas insertadas correctamente.");
		
	}

	
}
