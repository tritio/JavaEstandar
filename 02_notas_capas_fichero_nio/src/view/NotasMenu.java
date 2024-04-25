package view;

import java.util.List;
import java.util.Scanner;

import exceptions.ErrorFuenteDatosException;
import service.NotasService;

public class NotasMenu {
	static NotasService service = new NotasService();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			presentarMenu();
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				agregarNota();
				break;
			case 2:
				presentarMedia();
				break;
			case 3:
				presentarExtremas();
				break;
			case 4:
				mostrarTodas();
				break;
			case 5:
				System.out.println("hasta luego");
				break;
			default: 
				System.out.println("opción no válida");
			}				
		}while(opcion != 5); 

	}
	
	static void presentarMenu() {
		System.out.println("""
				
				1.- Agregar nota
				2.- Ver nota media
				3.- Ver nota máxima y mínima
				4.- Mostrar todas las notas
				5.- Salir
				""");
	
	}
	
	static void mostrarTodas() {
		try {
			System.out.println("las notas son: " + service.obtenerNotas());
		} catch (ErrorFuenteDatosException e) {
			e.printStackTrace();
			System.out.println("hubo un error al mostrar las notas");
		}
	}
	
	static void presentarMedia() {
		try {
			System.out.println("La media es: " + service.calcularMedia());
		} catch (ErrorFuenteDatosException e) {
			System.out.println("hubo un error al mostrar la media");
		}
	}
	
	static void presentarExtremas() {
		try {
			System.out.println("La nota más alta es: " + service.max());
			System.out.println("La nota más baja es: " + service.min());
		} catch (ErrorFuenteDatosException e) {
			e.printStackTrace();
			System.out.println("hubo un error al leer las notas extremas");
			System.out.println(e.getMessage());
		}
		
	}
	
	static void agregarNota() {
		double nota = 0;
		System.out.println("Introduce la nota: ");
		Scanner sc = new Scanner(System.in);
		nota = sc.nextDouble();
		service.agregarNota(nota);
		
	}
}
