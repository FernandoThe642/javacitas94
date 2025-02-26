package ppw.javacitas94.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_DOCTOR")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private int id;
	
	@Column(name = "doc_cedula")
	private String cedulaDoctor;
	
	@Column(name = "doc_nombreDoctor")
	private String nombreDoctor;
	
	@Column(name = "doc_especialidad")
	private String especialidad; 
	
	@Column(name = "doc_correo")
	private String correo;
	
	
	public Doctor() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedulaDoctor() {
		return cedulaDoctor;
	}

	public void setCedulaDoctor(String cedulaDoctor) {
		this.cedulaDoctor = cedulaDoctor;
	}

	public String getNombreDoctor() {
		return nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", cedulaDoctor=" + cedulaDoctor + ", nombreDoctor=" + nombreDoctor
				+ ", especialidad=" + especialidad + ", correo=" + correo + "]";
	}
	
	
	
	
}

