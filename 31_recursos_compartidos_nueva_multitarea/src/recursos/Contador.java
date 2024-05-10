package recursos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {

	private int valor;
	private Lock lock; // interfaz
		
	public Contador() {
		lock = new ReentrantLock();  // implementación de la interfaz
	}

	public void incrementar() {
		
			lock.lock();
			int temp = valor;
			temp = temp + 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valor = temp;
			lock.unlock();
	}
	
	public int getValor() {
		return valor;
	}
}
