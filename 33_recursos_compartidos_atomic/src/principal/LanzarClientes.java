package principal;

import java.util.concurrent.atomic.AtomicInteger;



public class LanzarClientes {

	public static void main(String[] args) {
		AtomicInteger contador = new AtomicInteger();
		
		
		for(int i = 1; i <= 1000; i++) {
			new Thread(()-> contador.incrementAndGet()).start();
		}
		
		
		// ponemos un retardo para esperar que todas las tareas terminen
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ¿Cuánto debería valer el contador?
		System.out.println( contador.get());

	}

}
