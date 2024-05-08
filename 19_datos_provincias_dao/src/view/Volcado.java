package view;

import service.ComunidadesService;
import service.ComunidadesServiceFactory;
import service.DatosProvinciasService;

public class Volcado {

	public static void main(String[] args) {
		var comService= ComunidadesServiceFactory.getComunidadesService();
		var provService=new DatosProvinciasService();
		System.out.println("comunidades guardadas. " + comService.saveComunidades(provService.comunidades()));
		System.out.println("provincias guardadas: " + comService.saveProvincias(provService.provincias()));
		System.out.println("municipios guardados: " +  comService.saveMunicipios(provService.municipios()));
		System.out.println("Volcado completado!!");

	}

}
