package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSeguro {

	AtomicInteger ai = new AtomicInteger(1);
	void incrementar() {
		System.out.println(ai.incrementAndGet());
	}
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(hola);
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
		System.out.println("máximo " + obj.ai.get());
		// ahora es seguro, no se pisará la variable, por tanto el resultado valdrá 1000

	}

}
