package operaciones;

import static util.Utilidades.*;  // importar todos los métodos estáticos de la clase Utilidades

public class Calculadora {
	
	public int sumar(int a, int b) {
		return a + b;
	}
	
	public int multiplicar(int a, int b) {
		return a * b;
	}
	
	public int restar(int a, int b) {
			return mayor(a, b) - menor(a, b);  // llamando a métodos del paquete Utilidades			
	}
	
	public int dividir(int a, int b) {
		return mayor(a, b) / menor(a, b);
	}
}
