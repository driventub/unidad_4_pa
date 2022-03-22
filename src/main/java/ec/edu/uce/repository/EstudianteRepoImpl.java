package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Estudiante;



@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo{
	
	private static final Logger LOG = LoggerFactory.getLogger(EstudianteRepoImpl.class); 
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	public Estudiante buscar(Integer id) {
		return this.e.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> myTypedQuery = (TypedQuery<Estudiante>) this.e
				.createQuery("SELECT f FROM Estudiante f    ",Estudiante.class);
		return myTypedQuery.getResultList();
		
	}

	@Override
	public void actualizar(Estudiante e) {
		this.e.merge(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	public void insertar(Estudiante e) {
		this.e.persist(e);
		
	}

}
