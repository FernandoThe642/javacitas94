package ppw.javacitas94.dao;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ppw.javacitas94.model.CitaMedica;

@Stateless
public class CitasMedicasDAO {
	
	@PersistenceContext 
	private EntityManager emCitaMedica;
	


	public void agregarCitaMedica(CitaMedica citaMedica) {	
			emCitaMedica.persist(citaMedica);
	}
	
	public CitaMedica obtenerCitaMedica(int id) {
			return emCitaMedica.find(CitaMedica.class, id);
	}
	
	public void actualizarCitaMedica(CitaMedica citaMedica) {
			emCitaMedica.merge(citaMedica);
	}
	
	public void eliminarCitaMedica(int id) {
    		CitaMedica citaMedicaExiste = emCitaMedica.find(CitaMedica.class, id);
    		if (citaMedicaExiste != null) {
				emCitaMedica.remove(citaMedicaExiste);
			} else {
				throw new RuntimeException("No existe en la base de datos.");
			}
	}
	
	public List<CitaMedica> obtenerCitaMedicas(){
			String jpql = "SELECT citaMedica FROM CitaMedica citaMedica";
			Query query = emCitaMedica.createQuery(jpql, CitaMedica.class);
			return query.getResultList();	
	}
	
	
	
    public CitaMedica buscarCitaMedicaPorNombre(String nombre) {
        try {
            return emCitaMedica.createQuery("SELECT d FROM CitaMedica d WHERE o.nombreCitaMedica = :nombreCitaMedica", CitaMedica.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
