package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
// se deberia poner en plural
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estuService;
	
	@RequestMapping("/buscar/{idEstudiante}")
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo ) {
		
		Estudiante estu =  this.estuService.buscar(idEstudiante);
//		Estudiante estu = new Estudiante();
//		estu.setId(idEstudiante);
//		estu.setNombre("Ana");
//		estu.setApellido("Marin");
		
		modelo.addAttribute("estu" , estu);
		return "estudiante";
	}
	
}
