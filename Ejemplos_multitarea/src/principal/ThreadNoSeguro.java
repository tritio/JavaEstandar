package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadNoSeguro {

	int a = 0;
	void incrementar() {
		System.out.println(++a);
	}
	public static void main(String[] args) throws InterruptedException {
		var obj = new ThreadNoSeguro();
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 1; i <=1000; i++) {
			executor.submit(()-> {
				obj.incrementar();
				// llama a 100 hilos, 
				// la variable puede no llegar a 100 porque un hilo ha machacado a otro
			});
		}
		Thread.sleep(500);
		System.out.println("máximo " + obj.a);
		// se observa que a no es igual a 1000 porque unos hilos han pisado a otros
		
	}

}
