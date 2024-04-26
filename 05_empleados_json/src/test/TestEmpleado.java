package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.EmpleadoService;

class TestEmpleado {

	static EmpleadoService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service = new EmpleadoService();
	}

	@Test
	void testListarEmpleadosPorDepartamento() {
		assertEquals(2, service.listarEmpleadosPorDepartamento("RRHH").size());
	}

	@Test
	void testEmpleadoMayorSalario() {
		assertEquals("Javier", service.empleadoMayorSalario().getEmpleado());
	}

	@Test
	void testListaDepartamentos() {
		assertEquals(3, service.listaDepartamentos().size());
	}

}
