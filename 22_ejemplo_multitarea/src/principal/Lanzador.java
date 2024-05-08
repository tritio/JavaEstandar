package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Lanzador {

	public static void main(String[] args) {
		TareaAscendente t1 = new TareaAscendente();
		TareaDescendente t2 = new TareaDescendente();
		
		t1.start();
		t2.start();

	}

}
