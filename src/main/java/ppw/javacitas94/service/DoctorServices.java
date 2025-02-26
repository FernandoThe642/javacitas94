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
import ppw.javacitas94.business.GestionDoctores;
import ppw.javacitas94.model.Doctor;


@Path("/doctores")
public class DoctorServices {

	
	@Inject 
	private GestionDoctores gDoctores;
	
	@GET 
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		try {
			List<Doctor> operaciones = gDoctores.listarDoctores();
			return Response.ok(operaciones).build();
		} catch (Exception e) {
			return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo obtener las doctores")).build();
		}
	}
	
	
	@GET
	@Path("/obtener/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("id") int id) {
        try {
            Doctor operacion = gDoctores.consultarDoctor(id);
            if (operacion == null) {
                return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Operación no encontrada")).build();
            }
            return Response.ok(operacion).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo encontrar el doctor")).build();
        }
	}
	
    
    
    @GET
    @Path("/buscar/{especialidad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorNombre(@PathParam("especialidad") String especialidad) {
        try {
            Doctor operacion = gDoctores.buscarPorEspecialidad(especialidad);
            return Response.ok(operacion).build();
        } catch (Exception e) {
            return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Doctor con especialidad no esocntrado: " + especialidad)).build();
        }
    }
    
    
    
    
    
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Doctor operacion) {
		try {
			gDoctores.registrarDoctor(operacion);
			return Response.ok(new Respuesta(Respuesta.EXITO, "Operación registrada Correctamente")).build();
		} catch (Exception e) {
			return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo resgistrar la operación.")).build();
		}
		
	}
	
    @PUT
    @Path("/actualizar") 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Doctor operacion) {
        try {
            Doctor operacionExiste = gDoctores.consultarDoctor(operacion.getId());
            if (operacionExiste == null) {
                return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Doctor no encontrada")).build();
            }
            gDoctores.modificarDoctor(operacion);
            return Response.ok(new Respuesta(Respuesta.EXITO, "Doctor actualizada correctamente")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(new Respuesta(Respuesta.ERROR, "No se pudo actualizar")).build();
        }
    }
}
