package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenarCurso {

	/*
	Crearemmos una lista con cuatro cursos cualquiera (inventados) y la ordenaremos por fechaInicio. En caso
	de fechas iguales, se ordena por duracion. La clase Curso NO implementa Comparable 

	*/
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Java", 250, LocalDate.of(2023, 8, 3)));	
		cursos.add(new Curso("php", 150, LocalDate.of(2023, 8, 3)));	
		cursos.add(new Curso("css", 50, LocalDate.of(2024, 10, 4)));
		cursos.add(new Curso("html", 60, LocalDate.of(2022, 5, 11)));	
		
			
		
		
	
		// otra forma:
		 Collections.sort(cursos, new Comparator<Curso>() {

			@Override
			public int compare(Curso o1, Curso o2) {
				if(o1.getFechaInicio().equals(o2.getFechaInicio())) {
				return	Integer.compare(o1.getDuracion(), o2.getDuracion());
				} else {
					return o1.getFechaInicio().compareTo(o2.getFechaInicio());
				}
			}
			 
		 });
		
	}

}
