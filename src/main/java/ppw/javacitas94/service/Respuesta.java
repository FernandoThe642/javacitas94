package ppw.javacitas94.service;

public class Respuesta {
	
	private String estado;
	private String mensaje;
	
	public static final String EXITO= "EXITO";
	public static final String ERROR = "ERROR";
	
	
	public Respuesta(String estado, String mensaje) {
		this.estado = estado;
		this.mensaje = mensaje;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}