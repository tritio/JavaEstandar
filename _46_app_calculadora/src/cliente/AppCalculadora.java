package cliente;

import java.util.Scanner;

import operaciones.Calculadora;

public class AppCalculadora {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		System.out.println("introduce un número: ");
		n1 = sc.nextInt();
		System.out.println("introduce otro número: ");
		n2 = sc.nextInt();
		Calculadora cal = new Calculadora();
		
		System.out.println("suma: " + cal.sumar(n1, n2) );
		System.out.println("resta: " + cal.restar(n1, n2) );
		System.out.println("multiplicación: " + cal.multiplicar(n1, n2) );
		System.out.println("división: " + cal.dividir(n1, n2) );
	}

}
