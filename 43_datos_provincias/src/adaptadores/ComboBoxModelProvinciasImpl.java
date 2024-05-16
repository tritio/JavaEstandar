package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Provincia;
import service.DatosProvinciasService;

public class ComboBoxModelProvinciasImpl extends DefaultComboBoxModel<Provincia> {

	List<Provincia> provincias;
	DatosProvinciasService datosProvinciasService = new DatosProvinciasService();
	
	public ComboBoxModelProvinciasImpl(String comunidad) {
		provincias = datosProvinciasService.provinciasComunidad(comunidad);		
	}

	@Override
	public int getSize() {
		return provincias.size();
	}

	@Override
	public Provincia getElementAt(int index) {
		return provincias.get(index);
	}
	
	
}
