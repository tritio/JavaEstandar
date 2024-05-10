package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		
		
		// tarea suma
		CompletableFuture <Integer> f1 = CompletableFuture.supplyAsync(()-> {
			int suma = 0;
			for (int i = 0; i <= 100; i++) {
				suma += i;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return suma;
		});
		
		// tarea factorial:
		
		CompletableFuture <Integer> f2 = CompletableFuture.supplyAsync(()->{
			int p = 1;
			for (int i = 1; i <= 6; i++) {
				p*=i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return p;
		});
		
		// el main sigue haciendo algo hasta que las tareas terminan, 
		// momento en el que se mostrarán los resultados
		
		f1.whenCompleteAsync((r, e)-> System.out.println("Suma de los números: " + r ));
		f2.whenCompleteAsync((r, e)-> System.out.println("El factorial es: " + r ));
		// si el main termina antes que alguno de ellos haya finalizado, no se mostrará
		
		for (int i = 1; i <= 100 ; i++)  {
			System.out.println("El main haciendo cosas....");
			Thread.sleep(50);
		}
		
	}

}
