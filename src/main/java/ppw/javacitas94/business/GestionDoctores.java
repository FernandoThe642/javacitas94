package ppw.javacitas94.business;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ppw.javacitas94.dao.DoctorDAO;
import ppw.javacitas94.model.Doctor;




@Stateless
public class GestionDoctores {
	@Inject DoctorDAO doctorDAO;
	
	public void registrarDoctor(Doctor doctor) {
		if (doctor == null) {
			throw new IllegalArgumentException("Doctor no pued ser nulo");
		}

        
        try {
    		doctorDAO.agregarDoctor(doctor);
		} catch (Exception e) {
            throw new RuntimeException("No se pudo registrar");
		}

	}
	
	public Doctor consultarDoctor(int id) {
        Doctor doctor = doctorDAO.obtenerDoctor(id);
        if (doctor == null) {
            throw new RuntimeException("Operación no encontrada con ID: " + id);
        }
        return doctor;
	}
	
	
	
	public void modificarDoctor(Doctor doctor) {
		if (doctor == null ) {
			throw new IllegalArgumentException("La operación no puee ser nula.");
			}
	      
		Doctor doctorExiste = consultarDoctor(doctor.getId());
	      
		if (doctorExiste == null) {
			throw new RuntimeException("No se encontro la operación");
		}
		
        try {
            doctorDAO.actualizarDoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo modificar la operación.");
        }
	}
	
	

	   public List<Doctor> listarDoctores() {
	        try {
	            return doctorDAO.obtenerDoctores();
	        } catch (Exception e) {
	            throw new RuntimeException("No se pudo obtener la lista de doctores.");
	        }
	    }
	   
	   
	    public Doctor buscarPorEspecialidad(String especialidad) throws Exception {
	        Doctor doctor = doctorDAO.buscarDoctorPorEspecialidad(especialidad);
	        if (doctor == null) {
	            throw new Exception("No se encontró: " + especialidad);
	        }
	        return doctor;
	    }

	
	

}
