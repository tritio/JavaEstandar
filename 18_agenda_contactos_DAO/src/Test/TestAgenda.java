package Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.ContactosService;
import service.ContactosServiceFactory;

class TestAgenda {

	static ContactosService service;  // es una interfaz
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 service = ContactosServiceFactory.getContactosService();
	}


	@Test
	void testBuscarContactoPorId() {
		assertEquals(88, service.buscarContactoPorId(3).getEdad());
		assertNull(service.buscarContactoPorId(30));
	}

	@Test
	void testGetContactos() {
		assertEquals(4, service.getContactos().size());
	}

}
