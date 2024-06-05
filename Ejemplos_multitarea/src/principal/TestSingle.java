package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TestSingle {

	public static void main(String[] args) {
		 ExecutorService executor = Executors.newSingleThreadExecutor();  // ver apuntes
		// ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(()-> IntStream.rangeClosed(1, 100).forEach(System.out::println));
		executor.submit(()-> IntStream.rangeClosed(-100, -1).forEach(System.out::println));
		executor.shutdown();  // si no lo ponemos se queda sin terminar el programa como esperando
		// si usamos shtdownNow() se destruye sin esperar si las tareas han terminado o no

		
		// con newSingleThreadExecutor() se convierte en monotarea, puede ejecutarse el primer range o el segundo range primero , pero no se van intercalando
		// los números,  no es multitarea, porque solo hay un hilo
		// con newCachedThreadPool() es multitarea, puede alternarse
		
		
	}

}
