package principal;

import java.io.Console;

public class ConsoleTest {

	public static void main(String[] args) {
		Console con = System.console();  // así como se instancia, método estático de la clase Console, pregunta de examen, nada de new Console()....
		String lenguaje = "Java";
		con.printf("bienvenido a  " + lenguaje);
		con.printf("Dime tu nombre: "); 
		String nombre = con.readLine();  
		con.printf("Te llamas " +  nombre);
	}
	
	// para ejecutarlo ir a la carpeta donde esté el .class y tecleamos
	// java nombre de la clase:
	
	// java ConsoleTest

}
