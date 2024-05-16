package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;


import service.DatosProvinciasService;

public class ComboBoxModelComunidadesImpl extends DefaultComboBoxModel<String> {
	
	List<String> comunidades;
	DatosProvinciasService datosProvinciaService = new DatosProvinciasService();
	public ComboBoxModelComunidadesImpl() {
		comunidades = datosProvinciaService.comunidades();
	}
	@Override
	public int getSize() {
		
		return comunidades.size();
	}
	@Override
	public String getElementAt(int index) {
		return comunidades.get(index);
	}
	
}
