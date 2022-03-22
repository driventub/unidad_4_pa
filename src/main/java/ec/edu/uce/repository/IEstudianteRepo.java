package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Estudiante;

public interface IEstudianteRepo {
	public Estudiante buscar(Integer id);
	public List<Estudiante> buscarTodos();
	public void actualizar(Estudiante e);
	public void eliminar(Integer id);
	public void insertar(Estudiante e);
}
