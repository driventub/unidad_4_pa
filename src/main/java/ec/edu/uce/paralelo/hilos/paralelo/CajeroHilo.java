package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.List;

public class CajeroHilo {
	private String nombre;
	private List<Integer> clientes;
	
//	Set y Get
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Integer> getClientes() {
		return clientes;
	}
	public void setClientes(List<Integer> clientes) {
		this.clientes = clientes;
	}
	public CajeroHilo(String nombre, List<Integer> clientes) {
		super();
		this.nombre = nombre;
		this.clientes = clientes;
	}
	
	
	
}
