package testing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exceptions.ErrorFuenteDatosException;
import service.NotasService;

class TestNotasService {
	static NotasService service = new NotasService();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		service.borrarNotas();
		// añadimos unas cuentas notas de prueba
		service.agregarNota(5.0);
		service.agregarNota(8.0);
		service.agregarNota(1.0);
		service.agregarNota(6.0);
	}

	@Test
	void testCalcularMedia() {
		try {
			assertEquals(5.0, service.calcularMedia());
		} catch (ErrorFuenteDatosException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testMax() {
		try {
			assertEquals(8.0, service.max());
		} catch (ErrorFuenteDatosException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testMin() {
		try {
			assertEquals(1.0, service.min());
		} catch (ErrorFuenteDatosException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testObtenerNotas() {
		try {
			assertEquals(4, service.obtenerNotas().size());
		} catch (ErrorFuenteDatosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Double [] notas = new Double[] {5.0, 8.0, 1.0, 6.0};		
		 Double[] convertido = null;
		try {
			convertido = service.obtenerNotas().toArray(new Double[0]);
		} catch (ErrorFuenteDatosException e) {
			e.printStackTrace();
		}
		 assertArrayEquals(notas, convertido);
	}

}
