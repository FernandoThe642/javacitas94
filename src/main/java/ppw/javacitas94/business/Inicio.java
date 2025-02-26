package ppw.javacitas94.business;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ppw.javacitas94.model.Doctor;

@Singleton
@Startup
public class Inicio {
	
	
	@Inject 
	private GestionDoctores gDoctores;
	
	@PostConstruct
	public void init() {
		
		
		//_______________Inserción de Doctores_______________
		Doctor doctor1 = new Doctor();
		doctor1.setCedulaDoctor("1106598673");
		doctor1.setNombreDoctor("Juan Peréz");
		doctor1.setEspecialidad("Cardiología");
		doctor1.setCorreo("jperes@mail.com");
		gDoctores.registrarDoctor(doctor1);
		
		Doctor doctor2 = new Doctor();
		doctor2.setCedulaDoctor("0123697865");
		doctor2.setNombreDoctor("José Bustamante");
		doctor2.setEspecialidad("Dermatología");
		doctor2.setCorreo("jbustamante@mail.com");
		gDoctores.registrarDoctor(doctor2);
		
		Doctor doctor3 = new Doctor();
		doctor3.setCedulaDoctor("03598689635");
		doctor3.setNombreDoctor("Victor Cueva");
		doctor3.setEspecialidad("Traumatología");
		doctor3.setCorreo("vcueva@mail.com");
		gDoctores.registrarDoctor(doctor3);
		
		Doctor doctor4 = new Doctor();
		doctor4.setCedulaDoctor("1463698756");
		doctor4.setNombreDoctor("Pablo Morales");
		doctor4.setEspecialidad("Oncología");
		doctor4.setCorreo("pmorales@mail.com");
		gDoctores.registrarDoctor(doctor4);
		
	
		System.out.println("___________Doctores____________-");
		List<Doctor> doctores = gDoctores.listarDoctores();
		for(Doctor ope: doctores) {
			System.out.println(ope);
		}

}


}