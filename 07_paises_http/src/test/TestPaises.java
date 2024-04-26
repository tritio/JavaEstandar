package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.PaisService;

class TestPaises {

	static PaisService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service = new PaisService();
	}

	@Test
	void testListarContinentes() {
		assertEquals(8,service.listarContinentes().size());
	}

	@Test
	void testListarPaisesPorContinente() {
		assertEquals(50,service.listarPaisesPorContinente("Asia").size());
		assertEquals(53,service.listarPaisesPorContinente("Europe").size());
	}

	@Test
	void testPaisMasPoblado() {
		assertEquals("China",service.paisMasPoblado().getNombre());
	}

	@Test
	void testPaisesAgrupadosPorContinente() {
		assertEquals(8,service.paisesAgrupadosPorContinente().size());
		// devuelve la cantidad de agrupaciones, en este caso 7 porque son 7 continentes las agrupaciones
	}

	@Test
	void testPaisAPartirCapital() {
		assertEquals("Afghanistan",service.paisAPartirCapital("Kabul").get().getNombre());
	}

}
