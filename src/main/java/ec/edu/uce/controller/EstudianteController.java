package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {

		Estudiante estu = this.estuService.buscar(idEstudiante);
//		Estudiante estu = new Estudiante();
//		estu.setId(idEstudiante);
//		estu.setNombre("Ana");
//		estu.setApellido("Marin");

		modelo.addAttribute("estu", estu);
		return "estudiante";
	}

	@GetMapping("todos")
	public String buscarTodos(Model modelo) {
		List<Estudiante> listaEstudiantes = this.estuService.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "lista";
	}

//	Se necesitan dos paginas
	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {

		this.estuService.insertar(estudiante);

		return "redirect:todos";
	}

//	@PostMapping("/insertar")
//	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo) {
//		
//		this.estuService.insertar(estudiante);
//		
//		return "lista";
//	}

	@GetMapping("/estudianteNuevo")
	public String obtenerDato(Estudiante estudiante) {
		return "estudiante_nuevo";

	}

//	Actualizar

	@GetMapping("estudianteActualiza/{idEstudiante}")
	public String obtenerActualizar(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante,
			Model modelo) {
		Estudiante estu = this.estuService.buscar(idEstudiante);
		modelo.addAttribute("estu", estu);
		return "estudiante_actualiza";
	}
	
	
//	
//	@PutMapping("actualiza/{idEstudiante}")
//	public String actualizarEstudiante(Estudiante estudiante, BindingResult result, Model modelo,
//			RedirectAttributes redirectAttrs) {
//		this.estuService.actualizar(estudiante);
//		return "redirect:todos";
//	}
//	
//	@PostMapping("actualizar/{idEstudiante}")
//	public String actualizarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante,
//			BindingResult result, Model modelo, RedirectAttributes redirectAttrs) {
//		estudiante.setId(idEstudiante);
//		this.estuService.actualizar(estudiante);
//		List<Estudiante> listaEstudiantes = this.estuService.buscarTodos();
//		modelo.addAttribute("estudiantes", listaEstudiantes);
//		return "lista";
//	}
//	
	@PutMapping("actualizar/{idEstudiante}")
	public String actualizarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante,
			BindingResult result, Model modelo, RedirectAttributes redirectAttrs) {
		estudiante.setId(idEstudiante);
		this.estuService.actualizar(estudiante);
//		List<Estudiante> listaEstudiantes = this.estuService.buscarTodos();
//		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "redirect:/estudiantes/todos";
	}

//	@PostMapping("borrar/{idEstudiante}")
//	public String eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
//		this.estuService.eliminar(idEstudiante);
//		List<Estudiante> listaEstudiantes = this.estuService.buscarTodos();
//		modelo.addAttribute("estudiantes", listaEstudiantes);
//		return "lista";
//	}
	@DeleteMapping("borrar/{idEstudiante}")
	public String eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		this.estuService.eliminar(idEstudiante);
//		List<Estudiante> listaEstudiantes = this.estuService.buscarTodos();
//		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "redirect:/estudiantes/todos";
	}

}
