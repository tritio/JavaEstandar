package dao;

public class ComunidadesDaoFactory {

	// crear las instancias de los Impl para que no se tengan que crear desde los service
	public static ComunidadDao getComunidadesDao() {
		return new ComunidadesDaoImpl();
	}
	
	public static ProvinciaDao getProvinciasDao() {
		return new ProvinciasDaoImpl();
	}
	
	public static MunicipioDao getMunicipiosDao() {
		return new MunicipioDaoImpl();
	}
}
