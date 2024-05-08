package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Lanzador {

	public static void main(String[] args) {
		TareaAscendente t1 = new TareaAscendente();
		TareaDescendente t2 = new TareaDescendente();
		Thread ta = new Thread(t1);
		Thread td = new Thread(t2);
		
		ta.start();
		td.start();

	}

}
