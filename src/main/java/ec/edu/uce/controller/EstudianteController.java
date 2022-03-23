package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
// se deberia poner en plural
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estuService;
	
//	@RequestMapping("/buscar/{idEstudiante}")
	@GetMapping("/buscar/{idEstudiante}")
//	@RequestMapping(path = "/buscar/{idEstudiante}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo ) {
		
		Estudiante estu =  this.estuService.buscar(idEstudiante);
//		Estudiante estu = new Estudiante();
//		estu.setId(idEstudiante);
//		estu.setNombre("Ana");
//		estu.setApellido("Marin");
		
		modelo.addAttribute("estu" , estu);
		return "estudiante";
	}
	
	
	@GetMapping("/buscar/todos")
	public String buscarTodos(Model modelo) {
		List<Estudiante> listaEstudiantes = this.estuService.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiantes );
		return "lista";
	}
	
//	Se necesitan dos paginas
//	public String insertarEstudiante() {
//		
//	}
	
	@GetMapping("/estudianteNuevo")
	public String obtenerDato() {
		return "estudiante_nuevo";
				
	}
	
}
