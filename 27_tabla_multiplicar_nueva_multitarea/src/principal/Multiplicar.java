package principal;

public class Multiplicar implements Runnable {

	private int numero;
	
	public Multiplicar(int numero) {
		this.numero = numero;
	}
	@Override
	public void run() {
		
		for (int i = 1; i <= 10; i++ ) {
				System.out.println(numero +  " x " + i + " = " + numero * i);				
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
	}
	
}
