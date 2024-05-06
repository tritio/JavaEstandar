package service;

import java.util.List;

import model.Curso;

public interface CursosJsonService {

	Curso cursoPorId(int idCurso);
	List<Curso> cursosAlumnos();

	boolean altaCurso(Curso curso);

}