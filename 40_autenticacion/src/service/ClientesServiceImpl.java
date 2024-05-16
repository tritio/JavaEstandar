package service;

import dao.ClientesDao;
import dao.ClientesDaoFactory;
import model.Cliente;

public class ClientesServiceImpl implements ClientesService {

	ClientesDao clientesDao;
	public ClientesServiceImpl() {
		clientesDao = ClientesDaoFactory.getClientesDao();
	}
	
	@Override
	public boolean autenticar(String usuario, String password) {
		
		Cliente cliente = clientesDao.findByUsuario(usuario);
	 return cliente != null && cliente.getPassword() == password;
	}

	@Override
	public boolean registrar(Cliente cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())!=null) {
			return false;
		}
		clientesDao.save(cliente);
		return true;
	}

}
