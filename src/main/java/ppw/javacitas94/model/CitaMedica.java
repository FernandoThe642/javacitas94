package ppw.javacitas94.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_CITAMEDICA")
public class CitaMedica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cm_id")
	private int id;
	
	@Column(name = "cm_cedulaPaciente")
	private String cedulaPaciente;
	
	@Column(name = "cm_nombrePaciente")
	private String nombrePacientel;
	
	@Column(name = "cm_correoPaciente")
	private String correoPaciente;
	
	@Column(name = "cm_fechaCita")
	private String fechaCita;
	
	@Column(name = "cm_horaCita")
	private String horaCita;
	
	@Column(name = "cm_especialidad")
	private String especialidad;
	
	@Column(name = "cm_estado")
	private String estado; //Pendiente|| Confirmada|| Cancelada
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cm_id")
    private List<Doctor> doctores;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCedulaPaciente() {
		return cedulaPaciente;
	}


	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}


	public String getNombrePacientel() {
		return nombrePacientel;
	}


	public void setNombrePacientel(String nombrePacientel) {
		this.nombrePacientel = nombrePacientel;
	}


	public String getCorreoPaciente() {
		return correoPaciente;
	}


	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}


	public String getFechaCita() {
		return fechaCita;
	}


	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}


	public String getHoraCita() {
		return horaCita;
	}


	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<Doctor> getDoctores() {
		return doctores;
	}


	public void setDoctores(List<Doctor> doctores) {
		this.doctores = doctores;
	}
	
	
	public void addTelefono(Doctor doctor) {
		if (this.doctores == null) {
			this.doctores = new ArrayList<>();
		}
		this.doctores.add(doctor);
	}
	
	


}