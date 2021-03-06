package com.openwebinars.springrest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.openwebinars.springrest.model.Cita;
import com.openwebinars.springrest.model.Empleado;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	List<Empleado> repo;
	
	@GetMapping("/empleado")
	public List<Empleado> list() {
		return repo;
	}
	
	@GetMapping("/empleado/{id}") 
	public Empleado getEmpleado(@PathVariable Long id, HttpServletResponse response) {
		if (id > 0 && id <= repo.size()) {
			return repo.get((int) (id-1));
		} else {
			//response.setStatus(404);
			//return null;
			//throw new EmpleadoNotFoundException();
			throw new EmpleadoNotFoundException(id);
		}
		
		
	}
	
	@GetMapping("/empleado/{id}/cita")
	public List<Cita> getCitasEmpleado(@PathVariable Long id) {
		if (id > 0 && id <= repo.size()) {
			return repo.get((int) (id-1)).getCitas();
		}
		
		return null;
	}
	
	@GetMapping("/empleado/{idE}/cita/{idC}")
	public Cita getCitaEmpleado(@PathVariable Long idE, @PathVariable Long idC,  HttpServletRequest request) throws NoHandlerFoundException {
		Cita result = null;
		
		if (idE > 0 && idE <= repo.size()) {
			List<Cita> citas = repo.get((int) (idE-1)).getCitas();
			if (citas != null) {
				for (Cita c : citas) 
					if (c.getId() == idC)
						result = c;
			}
		} 
				
		if (result != null)
			return result;
		else 
			throw new NoHandlerFoundException("GET", request.getRequestURL().toString(), null);
		
					
	}
	
	@PostConstruct
	private void init() {
		
		repo = new ArrayList<Empleado>();
		repo.add(new Empleado(1L, "Pepe", "Gotera", new Date()));
		repo.get(0).getCitas().add(new Cita(1L, "Reuni??n de trabajo", new Date()));
		repo.get(0).getCitas().add(new Cita(2L, "Visita a un cliente", new Date()));

		repo.add(new Empleado(2L, "Otilio", "Garc??a", new Date()));
		repo.get(1).getCitas().add(new Cita(3L, "Visita a un proveedor", new Date()));

		repo.add(new Empleado(3L, "Mortadelo", "G??mez", new Date()));
		repo.add(new Empleado(4L, "Filem??n", "Guzm??n", new Date()));
		repo.add(new Empleado(5L, "Super", "L??pez", new Date()));
	}
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="La cita no existe")
	@ExceptionHandler(NoHandlerFoundException.class)
	public void citaInexsistente() {
		//vac??o
	}
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="El empleado no existe")
	private class EmpleadoNotFoundException extends RuntimeException {
		
		private static final long serialVersionUID = -5798132769496018860L;

		public EmpleadoNotFoundException(Long id) {
			super(String.format("El empleado %d no existe",id));			
		}
		
	}
	

	
	



	

}
