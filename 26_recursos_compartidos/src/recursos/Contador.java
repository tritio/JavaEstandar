package recursos;

public class Contador {

	private int valor;
	
	public void incrementar() {
		
		synchronized(this) {
			int temp = valor;
			temp = temp + 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valor = temp;
		}		
	}
	
	public int getValor() {
		return valor;
	}
}
