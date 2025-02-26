package ppw.javacitas94.business;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ppw.javacitas94.dao.CitaMedicaDAO;
import ppw.javacitas94.model.CitaMedica;




@Stateless
public class GestionCitasMedicas {
	@Inject CitaMedicaDAO citaMedicaDAO;
	
	public void registrarCitaMedica(CitaMedica citaMedica) {
		if (citaMedica == null) {
			throw new IllegalArgumentException("CitaMedica no puede ser nula");
		}

        
        try {
    		citaMedicaDAO.agregarCitaMedica(citaMedica);
		} catch (Exception e) {
            throw new RuntimeException("No se pudo registrar");
		}

	}
	
	public CitaMedica consultarCitaMedica(int id) {
        CitaMedica citaMedica = citaMedicaDAO.obtenerCitaMedica(id);
        if (citaMedica == null) {
            throw new RuntimeException("Operación no encontrada con ID: " + id);
        }
        return citaMedica;
	}
	
	
	
	public void modificarCitaMedica(CitaMedica citaMedica) {
		if (citaMedica == null ) {
			throw new IllegalArgumentException("La operación no puee ser nula.");
			}
	      
		CitaMedica citaMedicaExiste = consultarCitaMedica(citaMedica.getId());
	      
		if (citaMedicaExiste == null) {
			throw new RuntimeException("No se encontro la operación");
		}
		
        try {
            citaMedicaDAO.actualizarCitaMedica(citaMedica);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo modificar la operación.");
        }
	}
	
	

	   public List<CitaMedica> listarCitasMedicas() {
	        try {
	            return citaMedicaDAO.obtenerCitaMedicas();
	        } catch (Exception e) {
	            throw new RuntimeException("No se pudo obtener la lista de citaMedicaes.");
	        }
	    }
	   
	   
	    public CitaMedica buscarPorCedulaPaciente(String cedulaPaciente) throws Exception {
	        CitaMedica citaMedica = citaMedicaDAO.buscarCitaMedicaPorCedulaPaciente(cedulaPaciente);
	        if (citaMedica == null) {
	            throw new Exception("No se encontró citas: " + cedulaPaciente);
	        }
	        return citaMedica;
	    }
	    
	    public List<CitaMedica> buscarCitasPorCedulaDoctor(String cedulaDoctor) {
	        List<CitaMedica> citas = citaMedicaDAO.buscarCitasPorCedulaDoctor(cedulaDoctor);
	        if (citas == null || citas.isEmpty()) {
	            throw new RuntimeException("No se encontraron citas: " + cedulaDoctor);
	        }
	        return citas;
	    }
	    
	    

}
