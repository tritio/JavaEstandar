package utilidades;

public class Conector {
	private String modo;
	private int tipo;
	private String dir;
	private boolean estado;
	private String protocolo;
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {		
		this.tipo = tipo;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	
	// definimos el builder  dentro de la clase, es algo que se suele hacer así
	// suelen ser clases anidadas, internas.
	
	public static class ConectorBuilder {
		Conector conector;
		
		public ConectorBuilder() {
			conector = new Conector();
		}
		
		public ConectorBuilder modo(String modo) {
			conector.setModo(modo);
			return this; // retorna el propio builder
		}
		
		public ConectorBuilder tipo(int tipo) {
			if(tipo < 0) {
				tipo = 0;
			}
			conector.setTipo(tipo);
			return this; 		
		}
		
		public ConectorBuilder dir(String dir) {
			conector.setDir(dir);
			return this;
		}
		
		public ConectorBuilder estado(boolean estado) {
			conector.setEstado(estado);
			return this;
		}
		
		public ConectorBuilder protocolo(String protocolo) {
			conector.setProtocolo(protocolo);
			return this;
		}
		
		public Conector build() {
			return conector;
		}
	}

	
}
