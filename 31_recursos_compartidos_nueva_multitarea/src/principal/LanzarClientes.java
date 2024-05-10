package principal;

import recursos.Contador;

public class LanzarClientes {

	public static void main(String[] args) {
		
		Contador cont = new Contador();
		for(int i = 1; i <= 1000; i++) {
			new Thread(()-> cont.incrementar()).start();
		}
		
		
		// ponemos un retardo para esperar que todas las tareas terminen
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ¿Cuánto debería valer el contador?
		System.out.println(cont.getValor());

	}

}
