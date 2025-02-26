package ppw.javacitas94.dao;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ppw.javacitas94.model.Doctor;



@Stateless
public class DoctorDAO {
	
	@PersistenceContext 
	private EntityManager emDoctor;
	


	public void agregarDoctor(Doctor doctor) {	
			emDoctor.persist(doctor);
	}
	
	public Doctor obtenerDoctor(int id) {
			return emDoctor.find(Doctor.class, id);
	}
	
	public void actualizarDoctor(Doctor doctor) {
			emDoctor.merge(doctor);
	}
	
	public void eliminarDoctor(int id) {
    		Doctor doctorExiste = emDoctor.find(Doctor.class, id);
    		if (doctorExiste != null) {
				emDoctor.remove(doctorExiste);
			} else {
				throw new RuntimeException("No existe en la base de datos.");
			}
	}
	
	public List<Doctor> obtenerDoctores(){
			String jpql = "SELECT doctor FROM Doctor doctor";
			Query query = emDoctor.createQuery(jpql, Doctor.class);
			return query.getResultList();	
	}
	
	
	
    public Doctor buscarDoctorPorEspecialidad(String especialidad) {
        try {
            return emDoctor.createQuery("SELECT d FROM Doctor d WHERE d.especialidad = :especialidad", Doctor.class)
                    .setParameter("especialidad", especialidad)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


}
