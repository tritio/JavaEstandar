package view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import principal.Multiplicar;

public class Lanzador {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Multiplicar(5));
		executor.submit(new Multiplicar(7));
		executor.submit(new Multiplicar(8));
		
		// vaciar el pull cuando ya no hay hilos para usar
		executor.shutdown();
		
	}

}
