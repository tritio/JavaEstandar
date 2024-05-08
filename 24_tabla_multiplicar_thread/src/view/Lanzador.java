package view;

import java.util.Scanner;

import principal.Multiplicar;

public class Lanzador {

	public static void main(String[] args) {
//		
//		Multiplicar n1 = new Multiplicar(2); 
//		Multiplicar n2 = new Multiplicar(4);
//		Thread m1 = new Thread(n1);
//		Thread m2 = new Thread(n2);
		new Thread(new Multiplicar(2)).start();
		new Thread(new Multiplicar(4)).start();
		new Thread(new Multiplicar(7)).start();
		
		
	}

}
