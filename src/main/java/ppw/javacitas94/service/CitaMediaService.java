package ppw.javacitas94.service;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ppw.javacitas94.business.GestionCitasMedicas;
import ppw.javacitas94.model.CitaMedica;



@Path("/citas")
public class CitaMediaService {

	
	@Inject 
	private GestionCitasMedicas gCitasMedicas;
	
	@POST
	@Path("/cita-medica")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response crear(CitaMedica citaMedica) {
		try {
			gCitasMedicas.registrarCitaMedica(citaMedica);
			return Response.ok(new Respuesta(Respuesta.EXITO, "Cita Medicaregistrada Correctamente")).build();
		} catch (Exception e) {
			return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo resgistrar")).build();
		}
		
	}
	
	
	@GET 
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		try {
			List<CitaMedica> citaMedicas = gCitasMedicas.listarCitasMedicas();
			return Response.ok(citaMedicas).build();
		} catch (Exception e) {
			return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo obtener las citaMedicaes")).build();
		}
	}
	
	
	@GET
	@Path("/obtener/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("id") int id) {
        try {
            CitaMedica citaMedica = gCitasMedicas.consultarCitaMedica(id);
            if (citaMedica == null) {
                return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Operación no encontrada")).build();
            }
            return Response.ok(citaMedica).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo encontrar la operación")).build();
        }
	}
	
    @PUT
    @Path("/cita-medica/{id}/cancelar") 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id) {
        try {
            CitaMedica citaMedicaExiste = gCitasMedicas.consultarCitaMedica(id);
            if (citaMedicaExiste == null) {
                return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "CitaMedica no encontrada")).build();
            }
            citaMedicaExiste.setEstado("Cancelada");
            gCitasMedicas.modificarCitaMedica(citaMedicaExiste);
            return Response.ok(new Respuesta(Respuesta.EXITO, "CitaMedica actualizada correctamente")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo actualizar")).build();
        }
    }
	
	
   
    
    
    @GET
    @Path("paciente/{cedulaPaciente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorNombre(@PathParam("cedulaPaciente") String cedulaPaciente) {
        try {
            CitaMedica citaMedica = gCitasMedicas.buscarPorCedulaPaciente(cedulaPaciente);
            return Response.ok(citaMedica).build();
        } catch (Exception e) {
            return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Cita no encontrada con cedulaPaciente: " + cedulaPaciente)).build();
        }
    }
    
    
    @GET
    @Path("/doctor/{cedulaDoctor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarCitasPorCedulaDoctor(@PathParam("cedulaDoctor") String cedulaDoctor) {
        try {
            List<CitaMedica> citas = gCitasMedicas.buscarCitasPorCedulaDoctor(cedulaDoctor);
            return Response.ok(citas).build();
        } catch (Exception e) {
            return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Cita no encontradoa con cedulaDortor: " + cedulaDoctor)).build();
        }
    }
    
}
